package MidProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dbUnit.ConnectionProvider;
import dbUnit.jdbcUtil;

/** 
 * @name : ������
 * @date : 2019. 5. 7. 
 * @description : �¼� ���� ��� ����
*/

/**
 * @name : ������
 * @date : 2019. 5. 13.
 * @description : �¼� �߰�
 */

public class ReservationDao {

	public MovieDto dto = new MovieDto();
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	public int rMax;
	public int rest_seat1;
	public int rest_seat2;
	public int rest_seat3;
	// 2019.05.13 ������ �¼� �߰� ����
	public String[][] seat_chk_f = new String[][] { { "A01", "B01", "C01", "D01" }, { "A02", "B02", "C02", "D02" },
			{ "A03", "B03", "C03", "D03" }, { "A04", "B04", "C04", "D04" } };
	public String[][] seat_chk = new String[4][4]; // ����Ǿ� �ִ� �¼����� Ȯ���ϱ� ���� 2���� ��Ʈ�� �迭
	public boolean snack_btn_flag = true;
	public boolean ticket_btn_flag = true;

	public void deleteDao() {
		dto = new MovieDto();
	}

	public void insertTicketInfo() {
		
		conn = ConnectionProvider.getConnection();
		sql = "insert into ticket values(t_id_seq.nextval,'',?,?,?)"; // order_id �߿� ���� ���� ��
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNum_of_people());
			pstmt.setInt(2, (dto.getNum_of_people() * 9000));
			pstmt.setInt(3, dto.getM_id());
			int check = pstmt.executeUpdate();
			
			if (check > 0)
				System.out.println("ticket info insert complete");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public void insertPayTable(int snackCharge) {
		
		SnackDao sdao = new SnackDao();
		
		int tid = getMaxTID();
		int order_id = sdao.getMaxOrderID();
		
		conn = ConnectionProvider.getConnection();
		sql = "update pay set t_id = ?, charge = ? where order_id = ?";
		
		//System.out.println(tid);
		//System.out.println(order_id);
		//System.out.println(snackCharge);
		//System.out.println(getTotalCharge());
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tid);
			pstmt.setInt(2, snackCharge + getTotalCharge());
			pstmt.setInt(3, order_id);

			int check = pstmt.executeUpdate();
			if (check > 0)
				System.out.println("insert pay table complete");
			
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("sql error");
		} finally {
			jdbcUtil.close(rs); // ����
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public int getMaxTID() {
		
		int max = 0;
		
		conn = ConnectionProvider.getConnection();
		sql = "select max(t_id) from ticket";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				max = rs.getInt("max(t_id)");
			} else
				System.out.println("no data");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return max;
	}

	public void printMovieInfo(JTextArea t) {
		
		if (dto != null) {
			t.append("=========KITRI MOVIE=============\n");
			t.append("��ȭ���� : " + dto.getM_name() + "\n");
			t.append("��ȭ�� : " + dto.getM_id() + "��" + "\t" + "�ð�: " + dto.getM_time() + "\n");
			t.append("�¼�" + "\n" + dto.getM_seat() + "\n");
			t.append("���Ź�ȣ : " + getMaxTID() + "\n"); // �̹�ȣ 2019.05.13

		}
	}

	public int getTotalCharge() {
		return (9000 * dto.getNum_of_people());
	}

	public void movieChoice() {
		
		String m_name = dto.getM_name();
		
		int m_location = 0;
		
		dto.setM_name(m_name);
		
		try { //
			
			conn = ConnectionProvider.getConnection();
			sql = "select m_location, ID from MOVIE where M_NAME = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getM_name());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				m_location = rs.getInt("m_location"); // 19/05/14 ������ ����
				
				dto.setM_location(m_location);
				dto.setM_id(rs.getInt("ID"));
				
			} else {
				System.out.println("��ȭ ���� ����");
			}

			sql = "select running_time from MOVIE where M_NAME = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getM_name());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto.setM_runningtime(rs.getInt("running_time"));
			} else {
				System.out.println("��ȭ ���� ����");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�ִ� �ο� ���� �Դϴ�.");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}

	}

	public void dayChoice() { // 19/05/14 ������ ����
		
		rest_seat1 = 0;
		rest_seat2 = 0;
		rest_seat3 = 0;

		try { 
			
			conn = ConnectionProvider.getConnection();
			sql = "select count(*) from SEAT where M_LOCATION = ? AND DAY = ? AND SEATED = 'Y' GROUP BY DAY";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setString(2, setterDate(0, "yy/05/dd"));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat1 = rs.getInt("count(*)");
			}

			sql = "select count(*) from SEAT where M_LOCATION = ? AND DAY = ? AND SEATED = 'Y' GROUP BY DAY";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setString(2, setterDate(1, "yy/05/dd"));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat2 = rs.getInt("count(*)");
			}
			
			sql = "select count(*) from SEAT where M_LOCATION = ? AND DAY = ? AND SEATED = 'Y' GROUP BY DAY";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setString(2, setterDate(2, "yy/05/dd"));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat3 = rs.getInt("count(*)");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� �¼� �� ���� �Դϴ�.");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public void timeChoice() { // 19/05/14 ������ ����

		rest_seat1 = 0;
		rest_seat2 = 0;
		rest_seat3 = 0;

		try { 
			System.out.println(dto.toString());
			System.out.println(dto.getM_day());
			conn = ConnectionProvider.getConnection();
			sql = "select count(*) from SEAT where M_LOCATION = ? AND TIME = 9 AND DAY = ? AND SEATED = 'Y' GROUP BY TIME";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setString(2, dto.getM_day());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat1 = rs.getInt("count(*)");
			} else {
				rest_seat1 = 0;
			}

			sql = "select count(*) from SEAT where M_LOCATION = ? AND TIME = 14 AND DAY = ? AND SEATED = 'Y' GROUP BY TIME";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setString(2, dto.getM_day());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat2 = rs.getInt("count(*)");
			} else {
				rest_seat2 = 0;
			}

			sql = "select count(*) from SEAT where M_LOCATION = ? AND TIME = 18 AND DAY = ? AND SEATED = 'Y' GROUP BY TIME";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setString(2, dto.getM_day());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat3 = rs.getInt("count(*)");
			} else {
				rest_seat3 = 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� �¼� ���� ���� �Դϴ�.");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public void seatChoice() { // 2019.05.13 ������ �¼� �߰� ����
		System.out.println(dto.toString());

		try { 
			conn = ConnectionProvider.getConnection();
			sql = "select count(*) from SEAT where M_LOCATION = ? AND TIME = ? AND DAY = ? AND SEATED = 'Y' GROUP BY TIME";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getM_location());
			pstmt.setInt(2, dto.getM_time());
			pstmt.setString(3, dto.getM_day());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rest_seat1 = rs.getInt("count(*)");
			} else {
				rest_seat1 = 0;
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					sql = "select SEATED from SEAT where M_LOCATION = ? AND TIME = ? AND DAY = ? AND SEAT_NUM = ?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, dto.getM_location());
					pstmt.setInt(2, dto.getM_time());
					pstmt.setString(3, dto.getM_day());
					pstmt.setString(4, seat_chk_f[i][j]);
					rs = pstmt.executeQuery();

					if (rs.next()) {
						seat_chk[i][j] = rs.getString("SEATED");
						// System.out.println(seat_chk[i][j]);
					} else {
						seat_chk[i][j] = "N";
					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� �¼� ���� ���� �Դϴ�.");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public void movieNameLoad(JRadioButton[] a) { // DB�� �ִ� ��ȭ�� �ҷ��� �̸��� ������ִ� �Լ�
		
		int i = 0;
		
		try { 
			
			conn = ConnectionProvider.getConnection();
			sql = "select M_NAME from MOVIE ORDER BY ID"; // ���̺� �ִ� ��� ��ȭ ������ ������
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					a[i].setText(rs.getString("M_NAME")); // ������ ��ȭ������
					i++;
				} while (rs.next());
			} else {
				a[i].setText("������������");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public int movieCount() { // ���̺� ����� ��ȭ�� ���� ���ϴ� �Լ�
		
		int i = 0;
		
		try { 
			
			conn = ConnectionProvider.getConnection();
			sql = "select M_NAME from MOVIE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					i++;
				} while (rs.next());
			} else {
				i = 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return i;
	}

	public void movieNameRankLoad(JRadioButton[] a, String[] name) { // ���ż����� �ҷ���

		for (int i = 0; i < movieCount(); i++) {
			a[i].setText(name[i]);
		}
		
	}

	public String rankname(int a) {
		
		sql = "select m_name from movie where id=?";
		
		String m_name = "";
		
		try {
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				do {
					m_name = rs.getString("m_name");
				} while (rs.next());
			} else {
				System.out.println("...");
			}

		} catch (Exception e) {
			System.out.println("��¿���");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}

		return m_name;
	}

	public void rankInsertName(int a, JTextArea b) {
		
		String name = "";

		sql = "select m_name from movie where id=?";

		try {
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				do {
					b.append(rs.getString("m_name"));
					b.append("\n");
				} while (rs.next());
			} else {
				//System.out.println("...");
			}
			
		} catch (Exception e) {
			System.out.println("��¿���");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}

	}

	// ��ȭ������ ���ϱ����� �Լ�
	public int[] rankCount(int mcnt) {
		
		sql = "select m_id, count(m_id)*count(num_of_people) from ticket GROUP BY m_id order by count(*) desc";

		int[] movieRank = new int[mcnt];
		
		int i = 0; // �迭�� �ε����� ���ϱ� ���� ����
		
		try {
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				do {
					movieRank[i] = rs.getInt("m_id");
					i++;
				} while (rs.next());
			} else {
				System.out.println("��������");
			}
		} catch (Exception e) {
			System.out.println("��¿���");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return movieRank;
	}

	// �̹�ȣ 2019.05.13 �ǽð� ��¥ �߰� JPanel02�� ������
	public String setterDate(int moveDate, String forMatter) {
		
		Date today = new Date();
		Date selDate = new Date();
		SimpleDateFormat form = new SimpleDateFormat(forMatter);
		selDate.setTime(today.getTime() + (1000 * 60 * 60 * 24) * moveDate);
		
		return form.format(selDate);
		
	}

	public void insertSeat() { // �̹�ȣ 2019.05.13 seat table �߰�
		
		int tid = getMaxTID();
		
		ArrayList<String> seat = new ArrayList();
		
		seat = dto.getM_seat();
		
		conn = ConnectionProvider.getConnection();
		sql = "insert into seat values(?,?,?,?,?,?)";
		
		try {
			
			for (int i = 0; i < seat.size(); i++) { // ������ �¼� ������ŭ loop�� ���鼭 db�� insert�� ����
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, tid);
				pstmt.setString(2, seat.get(i));
				pstmt.setString(3, dto.getM_locationString());
				pstmt.setString(4, dto.getM_day());
				pstmt.setInt(5, dto.getM_time());
				pstmt.setString(6, "Y");
				int check = pstmt.executeUpdate();
				
				if (check > 0) {
					System.out.println("db table seat insert complete");
				}
				else {
					System.out.println(i + "��°���� " + "db table seat insert failed");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertSeat sql error");
		} finally {
			jdbcUtil.close(rs); // ����
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}

	}

	public int[] indexSerch(String[] a) {
		
		String[] rename = { "a", "1", "c", "������", "��" };
		String[] tmp = new String[rename.length];
		int[] arr = new int[rename.length];
		
		for (int i = 0; i < rename.length; i++) {
			tmp[i] = rename[i];
		}

		Arrays.sort(rename, String.CASE_INSENSITIVE_ORDER);
		
		for (int i = 0; i < rename.length; i++) {
			for (int j = 0; j < rename.length; j++) {
				if (tmp[i] == (rename[j])) {
					arr[i] = j;
				}
			}
		}
		return arr;
	}

	public int compareTime() {
		
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
		sql = "select to_char(sysdate,'hh24') curTime from dual";
		conn = ConnectionProvider.getConnection();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return Integer.parseInt(rs.getString("curTime"));
			}
			else {
				System.out.println("failed to bring time from db");
				return -1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql error");
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return 1;
	}

	public String compareDate() {
		
		String today = null;
		
		sql = "select to_char(sysdate, 'yy/mm/dd') today from dual";
		
		try {
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				today = rs.getString("today");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return today;
	}

	public String[] dbGetName(int a) {
		
		String[] name = new String[a];
		
		sql = "select m_name from movie";
		
		int i = 0;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				do {
					name[i] = rs.getString("m_name");
					i++;
				} while (rs.next());
			} else {
				//System.out.println("...");
			}

		} catch (Exception e) {
			System.out.println("��¿���");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}

		return name;
	}

}