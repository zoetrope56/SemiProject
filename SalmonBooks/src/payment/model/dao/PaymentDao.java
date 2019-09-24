package payment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import article.dao.FreeboardArticleDao;
import jdbc.JdbcUtil;
import payment.model.vo.Payment;

public class PaymentDao {

	private Properties prop;

	public PaymentDao() {
		prop = new Properties();

		String filePath = FreeboardArticleDao.class
				.getResource("/config/payment-query.properties").getPath();
		try{
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}




	public int insert(Connection conn, Payment p) {

		int result = 0;

		PreparedStatement pstmt = null;
		//		ResultSet rset = null;

		String sql = prop.getProperty("InsertPayment");
		//		System.out.println(sql);

		try { 
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, p.getUserId());
			pstmt.setInt(2, p.getPoint());

			pstmt.setInt(3, p.getUserPoint());


			//System.out.println("paymentDao : "+p.getPoint());

			result = pstmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			JdbcUtil.close(pstmt);
		}

		return result;
	}





	public int selectOne(Connection conn, Payment p) {
		//마지막 적립포인트 가져오는 부분 

		int result = 0;
		PreparedStatement pstmt = null;


		String sql = prop.getProperty("selectOne");
		try { 
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, p.getUserId());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("USER_POINT");
			}
			
			System.out.println("PaymentDao selectOne - userid : " + p.getUserId());
			System.out.println("PaymentDao selectOne : "+result);


		}catch(SQLException e) {
			e.printStackTrace();

		}finally {
			JdbcUtil.close(pstmt);
		}

		return result;


	}


	/**
	 * 결제내역 조회
	 * @param conn
	 * @param userId
	 * @return
	 */

	public ArrayList<Payment> selectList(Connection conn,String userId) {

		ArrayList<Payment> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectList");
		System.out.println("sql : " + sql);

		try {



			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			list = new ArrayList<Payment>();

			while(rset.next()) {
				Payment p = new Payment();
				p.setpDate(rset.getDate("pdate"));
				p.setStatus(rset.getString("STATUS"));
				p.setPoint(rset.getInt("POINT"));
				p.setUserPoint(rset.getInt("USER_POINT"));
				System.out.println("PaymentDao : "+p);

				list.add(p);
 			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);

		}
		System.out.println("[PaymentDao] : "+list.toString());
		return list;


	}




	public int selectUserPoint(Connection conn, String userId) {
		int point = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectUserPoint");
		System.out.println("sql : " + sql);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				point = rset.getInt("USER_POINT");
				System.out.println("PaymentDao : "+point);
 			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);

		}
		System.out.println("[PaymentDao] : "+point);
		return point;
	}

}