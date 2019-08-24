package MidProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import dbUnit.ConnectionProvider;
import dbUnit.DriverProvider;
import dbUnit.jdbcUtil;

/**
 * @name : 이민호
 * @date : 2019. 5. 8.
 * @description : snack 메뉴 dao 구현
 */

public class SnackDao {

	public SnackDto dto = new SnackDto();
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql, sql1;

	public void insertPayinfo() { // snack만 주문했을시 insert방법 2019.05.13 이민호	
		int snackCharge = getTotalCharge();
		
		try {
			
			conn = ConnectionProvider.getConnection();
			sql = "insert into pay values('',order_id_seq.nextval,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snackCharge);
			
			int check = pstmt.executeUpdate();
			if (check > 0)
				System.out.println("pay table insert complete");
			else
				System.out.println("pay table insert failed");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insertpayinfo error");
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public void deleteDao() {
		dto = null;
		dto = new SnackDto();
	}

	public void print() {
		System.out.println(popcornAmount());
		System.out.println(cokeAmount());
		System.out.println(hotDogAmount());
		System.out.println(beerAmount());
		System.out.println(getTotalCharge());
	}

	public void setPopcorn(int popcorn) {
		dto.setPopcornAmount(popcorn);
		System.out.println("popcorn amount : " + popcorn);
	}

	public void setHotDog(int hotDog) {
		dto.setHotdogAmount(hotDog);
		System.out.println("hotDog amount : " + hotDog);
	}

	public void setCoke(int coke) {
		dto.setCokeAmount(coke);
		System.out.println("coke amount : " + coke);
	}

	public void setBeer(int beer) {
		dto.setBeerAmount(beer);
		System.out.println("beer amount : " + beer);
	}

	public int popcornAmount() {
		return dto.getPopcornAmount();
	}

	public int cokeAmount() {
		return dto.getCokeAmount();
	}

	public int hotDogAmount() {
		return dto.getHotdogAmount();
	}

	public int beerAmount() {
		return dto.getBeerAmount();
	}

	public int getTotalCharge() {
		
		int total;
		total = (8000 * dto.getPopcornAmount()) + (3000 * dto.getCokeAmount()) + (4000 * dto.getHotdogAmount())
				+ (5000 * dto.getBeerAmount());
		
		return total;
	}

	public void printSnackInfo(JTextArea t) {
		
		if (dto != null) {
			
			t.append("============스낵===================\n");
			
			if (popcornAmount() != 0) {
				t.append("팝콘 : " + popcornAmount() + "\t" + popcornAmount() * 8000 + "\n");
			}
			
			if (cokeAmount() != 0) {
				t.append("콜라 : " + cokeAmount() + "\t" + cokeAmount() * 3000 + "\n");
			}
			
			if (hotDogAmount() != 0) {
				t.append("핫도그 : " + hotDogAmount() + "\t" + hotDogAmount() * 4000 + "\n");
			}
			
			if (beerAmount() != 0) {
				t.append("맥주 : " + beerAmount() + "\t" + beerAmount() * 5000 + "\n");
			}
		}

	}

	public void insertSnackOrder(int popcorn, int coke, int hotDog, int beer) { // 최종적으로 SNACK_ORDER 테이블에 밀어넣을 것들
		int check = 0;
		
		ReservationDao dao = new ReservationDao();
		makeOrderID(); // 데이터삽입시 pay테이블의 order_id 생성
		
		int order_id = getMaxOrderID(); // pay테이블의 제일 높은 order_id값 가져옴
		conn = ConnectionProvider.getConnection();
		dto = new SnackDto(popcorn, coke, hotDog, beer);
		
		sql = "insert into snack_order values(?,?,?,?)";

		try {
			
			if (dto.getPopcornAmount() != 0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, order_id);
				pstmt.setInt(2, SnackDto.popcornID);
				pstmt.setInt(3, dto.getPopcornAmount());
				pstmt.setInt(4, (dto.getPopcornAmount() * 8000)); // 팝콘 오더갯수가 0개면 charge = 0
				
				check = pstmt.executeUpdate();
				if (check > 0)
					System.out.println("popcorn insert complete");
			}
			
			if (dto.getCokeAmount() != 0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, order_id);
				pstmt.setInt(2, SnackDto.cokeID);
				pstmt.setInt(3, dto.getCokeAmount());
				pstmt.setInt(4, (dto.getCokeAmount() * 3000));
				
				check = pstmt.executeUpdate();
				if (check > 0) 
					System.out.println("coke insert complete");
			}
			
			if (dto.getHotdogAmount() != 0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, order_id);
				pstmt.setInt(2, SnackDto.hotDogID);
				pstmt.setInt(3, dto.getHotdogAmount());
				pstmt.setInt(4, (dto.getHotdogAmount() * 4000));
				check = pstmt.executeUpdate();
				if (check > 0)
					System.out.println("hotdog insert complete");
			}
			
			if (dto.getBeerAmount() != 0) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, order_id);
				pstmt.setInt(2, SnackDto.beerID);
				pstmt.setInt(3, dto.getBeerAmount());
				pstmt.setInt(4, (dto.getBeerAmount() * 5000));
				
				check = pstmt.executeUpdate();
				if (check > 0)
					System.out.println("beer insert complete");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
	}

	public int getMaxOrderID() {
		int result = -1;
		conn = ConnectionProvider.getConnection();
		sql = "select max(order_id) from pay"; // order_id 중에 제일 높은 값
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max(order_id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);

		}
		return result; // 제일 높은order_id return
	}

	public void makeOrderID() {
		try {
			conn = ConnectionProvider.getConnection();
			sql = "insert into pay values('',order_id_seq.nextval,'')";
			pstmt = conn.prepareStatement(sql);
			int check = pstmt.executeUpdate(); // pay table에 null | order_id | null 삽입
			if (check > 0) {
				System.out.println("order id insert success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql error");
		} finally {
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);

		}
	}

	public void deleteOrder() { // 뒤로가기나 취소눌렀을때 SnackPannel02에서(장바구니메뉴)
		int order_id = getMaxOrderID();
		try {
			conn = ConnectionProvider.getConnection();
			sql = "delete from snack_order where order_id = ?"; // snack_order에서 주문지우고
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_id);
			int check = pstmt.executeUpdate();
			if (check > 0)
				System.out.println("snack_order table delete complete");
			pstmt.close();
			sql = "select t_id from pay where order_id = ?"; // pay테이블에서 해당 order_id를 지우기위 해 조회
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery(); // 쿼리실행
			if (rs.next()) {

				if (rs.getString("t_id") == null) { // 만약 해당 테이블의 t_id가 null이면
					sql = "delete from pay where order_id = ?"; // 지워라
					pstmt.close();
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, order_id);
					check = pstmt.executeUpdate();
					if (check > 0)
						System.out.println("pay table order_id delete complete");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		} // connection 끊으면 안됨.

	}

	// max(order_id) 와 param:(snack_id)로 amount값 가져오기 string return
	public String getAmount(int snack_id) {
		int order_id = getMaxOrderID();

		String amount = null;
		try {
			conn = ConnectionProvider.getConnection();
			sql = "select amount from snack_order where snack_id = ? and order_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, snack_id);
			pstmt.setInt(2, order_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				amount = Integer.toString(rs.getInt("amount"));
			} else
				System.out.println("not found" + rs.getInt("amount"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return amount;
	}

	public String getSnackTotalAmount() { // 제일 최근 order_id로 tatal charge를 계산한값 return
		String total = null;
		int order_id = getMaxOrderID();

		try {
			conn = ConnectionProvider.getConnection();
			sql = "select sum(charge) from snack_order where order_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				total = Integer.toString(rs.getInt("sum(charge)"));
			} else
				System.out.println("sql error");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close(rs);
			jdbcUtil.close(pstmt);
			jdbcUtil.close(conn);
		}
		return total;
	}

}
