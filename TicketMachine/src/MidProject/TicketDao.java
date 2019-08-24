package MidProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.ComboPopup;

import dbUnit.ConnectionProvider;
import dbUnit.jdbcUtil;

/**
 * @author KITRI
 * @name : ȫ��� @date : 2019. 5. 8.
 * @description : ���� Ȯ�� ��� ���� �Լ�����
 */
public class TicketDao {

	private TicketDto dto;
	private String sql;
	private Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt2;
	private ResultSet rs;
	private ResultSet rs2;
	private JTextArea a;

//todo - (�������� ��Ȳ) seat���̺� ������ tid������ �����ͻ���
//                  seat_num ���� ���Խ� [ ] ��ȣǥ�û���

	public void print(JTextArea a) {
		sql = "select * from ticket";
		dto = new TicketDto();
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				a.append(String.valueOf(rs.getInt("t_id")) + "\t" + rs.getString("phone") + "\n");
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

	// 2019.05.14 �̹�ȣ ����
	// 2019.05.15 �̹�ȣ ����
	   // 2019.05.14 �̹�ȣ ����
	   // 2019.05.15 �̹�ȣ ����
	   public boolean phoneSerch(JTextArea a, String phone) {
	      boolean flag = true;
	      int tid = 0;
	      sql = "select t.t_id tid, t.phone tp, t.num_of_people tnop, t.charge tc, t.m_id tm, m.m_name mname, to_char(s.day,'yy/mm/dd') day from seat s,ticket t, movie m where t.m_id = m.id and s.t_id = t.t_id and phone = ?";
	      dto = new TicketDto();
	      boolean bbb = false;
	      try {
	         conn = ConnectionProvider.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         dto.setPhone(phone);
	         pstmt.setString(1, dto.getPhone());
	         rs = pstmt.executeQuery();

	         a.setText("");// â�� �ʱ�ȭ ��Ű�� ���Ͽ�

	         if (rs.next() == true) {
	            do {
	               //System.out.println("dddddddddd");
	               bbb = true;
	               a.append("-----------------------����Ƽ��------------------------------\n");
	               a.append("��ȭ: " + "\t" + rs.getString("mname") + "\n");
	               a.append("���Ź�ȣ :\t" + String.valueOf(rs.getInt("tid")) + "\n");
	               a.append("��ȭ��ȣ :\t" + rs.getString("tp") + "\n");
	               a.append("�ο��� :\t" + String.valueOf(rs.getInt("tnop")) + "\n");
	               a.append("������ �ݾ� : \t" + String.valueOf(rs.getInt("tc")) + "��\n");
	               a.append("��ȭ�� : \t" + String.valueOf(rs.getInt("tm")) + "��\n");
	               a.append("��¥:"+ "\t"+String.valueOf(rs.getString("day"))+"\n");
	               tid = rs.getInt("tid");

	               sql = "select s.seat_num ssn from seat s, ticket t where s.t_id = t.t_id and s.t_id = ?";
	               pstmt2 = conn.prepareStatement(sql);
	               pstmt2.setInt(1, tid);
	               rs2 = pstmt2.executeQuery();
	               a.append("�¼����� :\t");
	               while (rs2.next()) {
	                  
	                  a.append(String.valueOf(rs2.getString("ssn")) + " ");
	               }
	               a.append("\n");

	            } while (rs.next());

	            // tid = rs.getInt("t_id");
	            // System.out.println(rs.getInt("t_id"));
	            // break;
	         } else {
	            a.append("�������");
	            flag = false;
	         }

//	                  if(rs.next()) {
//	                     sql = "select s.seat_num ssn from seat s, ticket t where s.t_id = t.t_id and s.t_id = ?";
//	                     pstmt2 = conn.prepareStatement(sql);
//	                     pstmt2.setInt(1, tid);
//	                     rs2 = pstmt2.executeQuery();
//	                     a.append("�¼����� :\t");
//	                     while (rs2.next()) {
//	                        a.append(String.valueOf(rs2.getString("ssn")) + " ");
//	                     }
//	                     return true;
//	                  }
	      } catch (Exception e) {
	         System.out.println("��¿���");
	         e.printStackTrace();
	      } finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(pstmt);
	         jdbcUtil.close(rs2);
	         jdbcUtil.close(pstmt2);
	         jdbcUtil.close(conn);
	      }
	      return bbb;
	   }

	   // 2019.05.14 �̹�ȣ ���� + 19/05/14 ������ ����
	   public boolean tIdSerch(JTextArea a, String tid) {
	      boolean flag = true;

	      sql = "select t.t_id tid, t.phone tp, t.num_of_people tnop,t.charge tc,t.m_id tmid, s.seat_num ssn,m.m_name mname,to_char(s.day,'yy/mm/dd') day from seat s, ticket t,movie m where s.t_id = t.t_id and t.m_id=m.id and s.t_id = ?";
	      dto = new TicketDto();

	      try {
	         conn = ConnectionProvider.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         a.setText("");// â�� �ʱ�ȭ ��Ű�� ���Ͽ�
	         if (tid.equals("")) {
	            a.append("���ų�������");
	            return false;
	         }
	         int id = Integer.parseInt(tid);// tid�� int���̱� ������ �ڷ��� ��ȯ
	         dto.settId(id);
	         pstmt.setInt(1, id);
	         rs = pstmt.executeQuery();
	         do {
	            if (rs.next() == true) {
	               a.append("-----------------------����Ƽ��------------------------------\n");
	               a.append("��ȭ: " + "\t" + String.valueOf(rs.getString("mname")) + "\n");
	               a.append("���Ź�ȣ :\t" + String.valueOf(rs.getInt("tid")) + "\n");
	               a.append("��ȭ��ȣ :\t" + rs.getString("tp") + "\n");
	               a.append("�ο��� :\t" + String.valueOf(rs.getInt("tnop")) + "\n");
	               a.append("������ �ݾ� : \t" + String.valueOf(rs.getInt("tc")) + "��\n");
	               a.append("��ȭ�� : \t" + String.valueOf(rs.getInt("tmid")) + "��\n");
	               a.append("��¥:"+ "\t"+ String.valueOf(rs.getString("day")) + "\n");
	               // a.append("�¼����� : " + String.valueOf(rs.getString("ssn")));
	               // return true;
	               break;
	            } else {
	               a.append("���� ���� ����");
	               flag = false;
	            }
	         } while (rs.next());

	         if (flag) {
	            sql = "select t.t_id tid, t.phone tp, t.num_of_people tnop,t.charge tc,t.m_id tmid, s.seat_num ssn from seat s, ticket t where s.t_id = t.t_id and s.t_id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            a.append("�¼����� :\t");
	            while (rs.next()) {
	               a.append(String.valueOf(rs.getString("ssn")) + " ");
	            }
	            return true;
	         }

	      } catch (Exception e) {
	         System.out.println("��¿���");
	         e.printStackTrace();
	      } finally {
	         jdbcUtil.close(rs);
	         jdbcUtil.close(pstmt);
	         jdbcUtil.close(conn);
	      }
	      return false;
	   }

	public void tComboInsert(JComboBox<String> b) {

		sql = "select * from ticket where t_id=?";

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.gettId());
			rs = pstmt.executeQuery();
			b.removeAllItems();
			if (rs.next() == true) {
				do {

					b.addItem(String.valueOf(rs.getInt("t_id")));
				} while (rs.next());
			} else {
				b.addItem("���ų�������");
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

	public void pComboInsert(JComboBox<String> b) {

		sql = "select * from ticket where phone=?";

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			rs = pstmt.executeQuery();

			b.removeAllItems();
			if (rs.next() == true) {
				do {

					b.addItem(String.valueOf(rs.getInt("t_id")));
				} while (rs.next());
			} else {
				b.addItem("���ų�������");
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

	public void ticketDelete(JComboBox<String> a, JTextArea textArea) {
		String tmp = a.getSelectedItem().toString();// �޺��ڽ��� ���õ� ������ �ҷ��´�.

		try {
//	        sql = "delete seat where t_id=?";
			conn = ConnectionProvider.getConnection();
//	        pstmt = conn.prepareStatement(sql);
//	        pstmt.setInt(1, Integer.parseInt(tmp));
			//
//	        int check = pstmt.executeUpdate();

			sql = "delete snack_order where order_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(tmp));
			int check = pstmt.executeUpdate();

//	        sql = "delete pay where t_id=?";
//	        pstmt = conn.prepareStatement(sql);
//	        pstmt.setInt(1, Integer.parseInt(tmp));
//	        check = pstmt.executeUpdate();

			sql = "delete ticket where t_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(tmp));
			check = pstmt.executeUpdate();

			if (check > 0) {
				textArea.setText("");// �ʱ�ȭ
				textArea.append("������ҿϷ�");
			} else {
				System.out.println("���� ����");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}
}