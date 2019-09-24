package usingpayment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import article.dao.FreeboardArticleDao;
import jdbc.JdbcUtil;
import payment.model.vo.Payment;
import usingpayment.model.vo.UsingPayment;

public class UsingPaymentDao {

	private Properties prop;


	public UsingPaymentDao() {
		prop = new Properties();

		String filePath = FreeboardArticleDao.class
				.getResource("/config/payment-query.properties").getPath();
		try{
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}




	/**
	 * 결제내역이 있는지 체크
	 * @param conn
	 * @param up
	 * @return
	 */
	public String check(Connection conn, UsingPayment up) {

		String result = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("CheckUsingPayment");
		System.out.println(sql);
		try { 
			//System.out.println("화려한 장미가 있고 가시가 있고 이젠 너무많이 지쳐버렸어어어어어 아무리 두눈을");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, up.getNno());
			pstmt.setInt(2, up.getDno());
			pstmt.setString(3, up.getUserId());

			System.out.println(up.getNno() + " " + up.getDno() + " " +up.getUserId());

			rset = pstmt.executeQuery();
			System.out.println("이얍!");

			if(rset.next()) {
				result = "true";
				System.out.println("결제값이 있네요");

			}else {
				result = "false";
				System.out.println("결제값이 없네요");
			}
			System.out.println(result);
			System.out.println("결과값이에요 : " + result);

		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return result;

	}




	/**
	 * 소설결제내역 추가
	 * @param conn
	 * @param up
	 * @return
	 */
	public int insert(Connection conn, UsingPayment up) {

		int result =0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("InsertUsingPayment");

		try { 
			pstmt = conn.prepareStatement(sql);


			pstmt.setInt(1,up.getNno());
			pstmt.setString(2, up.getTitle());
			pstmt.setInt(3,up.getDno());
			pstmt.setInt(4,up.getPay());
			pstmt.setString(5, up.getUserId());


			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			JdbcUtil.close(pstmt);
		}

		return result;
	}




	/**
	 * 소설포인트만큼 포인트 사용하고 페이먼트에서 포인트 차감
	 * @param conn
	 * @param up
	 * @return
	 */
	public int pointusing(Connection conn, UsingPayment up, Payment p) {

		int result2 =0;

		PreparedStatement pstmt = null;

		String sql = prop.getProperty("PointUse");

		try { 
			pstmt = conn.prepareStatement(sql);

			//아이디, 페이 , 유저포인트 
			//사용한 만큼 페이먼트 테이블에 인설트 시켜주는 부분 
			pstmt.setString(1,up.getUserId());
			pstmt.setInt(2, up.getPay());
			pstmt.setInt(3,p.getUserPoint());
			System.out.println("UsingPaymentDao pointusing : " +p.getUserPoint());

			result2 = pstmt.executeUpdate();


		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			JdbcUtil.close(pstmt);
		}

		return result2;

	}

	public int usingselectOne(Connection conn, UsingPayment up) {
		//마지막 포인트 가져오는 부분 

		int result2 = 0;
		PreparedStatement pstmt = null;


		String sql = prop.getProperty("selectOne");
		try { 
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, up.getUserId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result2 = rs.getInt("USER_POINT");
			}

			//System.out.println("김혜련은 보아라 " +up.getUserId() );


		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			JdbcUtil.close(pstmt);
		}

		return result2;


	}

	public ArrayList<UsingPayment> selectList(Connection conn,String userId) {

		ArrayList<UsingPayment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("usingPayList");
		System.out.println("sql : " + sql);

		try { 
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();

			list = new ArrayList<UsingPayment>();

			while(rset.next()) {
				UsingPayment up = new UsingPayment();
				// 구매일, 제목, 회차, 결제금액
				up.setuDate(rset.getDate("udate"));
				up.setTitle(rset.getString("title"));
				up.setDno(rset.getInt("dno"));
				up.setPay(rset.getInt("pay"));

				list.add(up);


			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);

		}

		return list;
	}

}
