package usingpayment.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.connection.ConnectionProvider;
import payment.model.dao.PaymentDao;
import payment.model.vo.Payment;
import usingpayment.model.dao.UsingPaymentDao;
import usingpayment.model.vo.UsingPayment;

public class UsingPaymentService {

	private UsingPaymentDao upDao = new UsingPaymentDao();
	private PaymentDao pDao = new PaymentDao();

	/**
	 * 
	 * @param up
	 * @return
	 */
	public String checkUsing(UsingPayment up) {

		//결제내역 있는지 확인하는 메소드 
		String result;

		try(Connection conn = ConnectionProvider.getConnection()) {

			//dao 맨 끝에 있는 결제 내역을 가져옴

			result = upDao.check(conn, up);
 
			//			if(result.equals("true")) conn.commit();
			//			else conn.rollback();

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}






	/**
	 * 
	 * @param up
	 * @return
	 */
	public int insert(UsingPayment up) {

		int result;

		try(Connection conn = ConnectionProvider.getConnection()) {

			//dao 맨 끝에 있는 결제 내역을 가져옴
			System.out.println("p.getUserId " + up.getUserId());
			
			result = upDao.insert(conn,up);
			System.out.println("UsingPaymentService insert의 결과값  : " + result);
			if(result >0) conn.commit();
			else conn.rollback();


		}catch(SQLException e) {
			throw new RuntimeException(e);


		}

		return result;

	}


	/**
	 * 
	 * @param up
	 * @param p
	 * @return
	 */
	public int pointusing(UsingPayment up,Payment p) {

		int result2;


		try(Connection conn = ConnectionProvider.getConnection()) {

			System.out.println("usingPaymentService : "+upDao.usingselectOne(conn, up));

			System.out.println("포인트를 뺄꺼에요! : " +((upDao.usingselectOne(conn, up)) -(up.getPay())));

			
			if(upDao.usingselectOne(conn, up) > up.getPay()) {
				System.out.println("여기는 이프입니다");
				System.out.println((upDao.usingselectOne(conn, up)) -(up.getPay()));
				
				p.setUserPoint((upDao.usingselectOne(conn, up))-(up.getPay())); //유저포인트 
				result2 = upDao.pointusing(conn,up,p);
				conn.commit();
				
				return result2;
			}else {
				System.out.println("여기는 엘스입니다.");
				conn.rollback();
				return 0;
			}


		}catch(SQLException e) {
			throw new RuntimeException(e);


		}

	}


	/**
	 * 
	 */
	public ArrayList<UsingPayment> select(String userId) {

		ArrayList<UsingPayment> list;
		try(Connection conn = ConnectionProvider.getConnection()) {

			list = upDao.selectList(conn, userId);

			System.out.println("UsingPaymentService : "+list.toString());

			//close(conn);



		}catch(SQLException e) {
			throw new RuntimeException(e);


		}




		return list;


	}
	
	

}
