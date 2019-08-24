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
 * @name : 홍사명 @date : 2019. 5. 8.
 * @description : 예매 확인 취소 관련 함수구현
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

//todo - (결제후의 상황) seat테이블에 기존의 tid값으로 데이터삽입
//                  seat_num 열값 삽입시 [ ] 괄호표시빼기

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
			System.out.println("출력에러");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	// 2019.05.14 이민호 수정
	// 2019.05.15 이민호 수정
	   // 2019.05.14 이민호 수정
	   // 2019.05.15 이민호 수정
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

	         a.setText("");// 창을 초기화 시키기 위하여

	         if (rs.next() == true) {
	            do {
	               //System.out.println("dddddddddd");
	               bbb = true;
	               a.append("-----------------------예매티켓------------------------------\n");
	               a.append("영화: " + "\t" + rs.getString("mname") + "\n");
	               a.append("예매번호 :\t" + String.valueOf(rs.getInt("tid")) + "\n");
	               a.append("전화번호 :\t" + rs.getString("tp") + "\n");
	               a.append("인원수 :\t" + String.valueOf(rs.getInt("tnop")) + "\n");
	               a.append("결제할 금액 : \t" + String.valueOf(rs.getInt("tc")) + "원\n");
	               a.append("영화관 : \t" + String.valueOf(rs.getInt("tm")) + "관\n");
	               a.append("날짜:"+ "\t"+String.valueOf(rs.getString("day"))+"\n");
	               tid = rs.getInt("tid");

	               sql = "select s.seat_num ssn from seat s, ticket t where s.t_id = t.t_id and s.t_id = ?";
	               pstmt2 = conn.prepareStatement(sql);
	               pstmt2.setInt(1, tid);
	               rs2 = pstmt2.executeQuery();
	               a.append("좌석정보 :\t");
	               while (rs2.next()) {
	                  
	                  a.append(String.valueOf(rs2.getString("ssn")) + " ");
	               }
	               a.append("\n");

	            } while (rs.next());

	            // tid = rs.getInt("t_id");
	            // System.out.println(rs.getInt("t_id"));
	            // break;
	         } else {
	            a.append("내용없음");
	            flag = false;
	         }

//	                  if(rs.next()) {
//	                     sql = "select s.seat_num ssn from seat s, ticket t where s.t_id = t.t_id and s.t_id = ?";
//	                     pstmt2 = conn.prepareStatement(sql);
//	                     pstmt2.setInt(1, tid);
//	                     rs2 = pstmt2.executeQuery();
//	                     a.append("좌석정보 :\t");
//	                     while (rs2.next()) {
//	                        a.append(String.valueOf(rs2.getString("ssn")) + " ");
//	                     }
//	                     return true;
//	                  }
	      } catch (Exception e) {
	         System.out.println("출력에러");
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

	   // 2019.05.14 이민호 수정 + 19/05/14 나다윤 수정
	   public boolean tIdSerch(JTextArea a, String tid) {
	      boolean flag = true;

	      sql = "select t.t_id tid, t.phone tp, t.num_of_people tnop,t.charge tc,t.m_id tmid, s.seat_num ssn,m.m_name mname,to_char(s.day,'yy/mm/dd') day from seat s, ticket t,movie m where s.t_id = t.t_id and t.m_id=m.id and s.t_id = ?";
	      dto = new TicketDto();

	      try {
	         conn = ConnectionProvider.getConnection();
	         pstmt = conn.prepareStatement(sql);
	         a.setText("");// 창을 초기화 시키기 위하여
	         if (tid.equals("")) {
	            a.append("예매내역없음");
	            return false;
	         }
	         int id = Integer.parseInt(tid);// tid가 int형이기 때문에 자료형 번환
	         dto.settId(id);
	         pstmt.setInt(1, id);
	         rs = pstmt.executeQuery();
	         do {
	            if (rs.next() == true) {
	               a.append("-----------------------예매티켓------------------------------\n");
	               a.append("영화: " + "\t" + String.valueOf(rs.getString("mname")) + "\n");
	               a.append("예매번호 :\t" + String.valueOf(rs.getInt("tid")) + "\n");
	               a.append("전화번호 :\t" + rs.getString("tp") + "\n");
	               a.append("인원수 :\t" + String.valueOf(rs.getInt("tnop")) + "\n");
	               a.append("결제할 금액 : \t" + String.valueOf(rs.getInt("tc")) + "원\n");
	               a.append("영화관 : \t" + String.valueOf(rs.getInt("tmid")) + "관\n");
	               a.append("날짜:"+ "\t"+ String.valueOf(rs.getString("day")) + "\n");
	               // a.append("좌석정보 : " + String.valueOf(rs.getString("ssn")));
	               // return true;
	               break;
	            } else {
	               a.append("예매 내역 없음");
	               flag = false;
	            }
	         } while (rs.next());

	         if (flag) {
	            sql = "select t.t_id tid, t.phone tp, t.num_of_people tnop,t.charge tc,t.m_id tmid, s.seat_num ssn from seat s, ticket t where s.t_id = t.t_id and s.t_id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            a.append("좌석정보 :\t");
	            while (rs.next()) {
	               a.append(String.valueOf(rs.getString("ssn")) + " ");
	            }
	            return true;
	         }

	      } catch (Exception e) {
	         System.out.println("출력에러");
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
				b.addItem("예매내역없음");
			}
		} catch (Exception e) {
			System.out.println("출력에러");
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
				b.addItem("예매내역없음");
			}

		} catch (Exception e) {
			System.out.println("출력에러");
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public void ticketDelete(JComboBox<String> a, JTextArea textArea) {
		String tmp = a.getSelectedItem().toString();// 콤보박스에 선택된 내용을 불러온다.

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
				textArea.setText("");// 초기화
				textArea.append("예약취소완료");
			} else {
				System.out.println("내역 없음");
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