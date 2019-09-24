package payment.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.x.Notice;

import jdbc.connection.ConnectionProvider;
import payment.model.dao.PaymentDao;
import payment.model.vo.Payment;

public class PaymentService {


	private PaymentDao pDao = new PaymentDao();

	public int insertPayment(Payment p) {

		int result;

		try(Connection conn = ConnectionProvider.getConnection()) {

			//서블릿에서 가져온 포인트 + dao 맨 끝에 있는 결제 내역
			p.setUserPoint(p.getPoint() + pDao.selectOne(conn, p));


			result = pDao.insert(conn,p);


			if(result >0) conn.commit();
			else conn.rollback();



		}catch(SQLException e) {
			throw new RuntimeException(e);


		}

		return result;

	}


	public ArrayList<Payment> select(String userId){

		ArrayList<Payment> list;
		try(Connection conn = ConnectionProvider.getConnection()) {

			list = pDao.selectList(conn, userId);
			System.out.println("PaymentService : "+list.toString());

			//close(conn);



		}catch(SQLException e) {
			throw new RuntimeException(e);


		}		

		return list;
	}

	public int selectUserPoint(String userId) {
		int point =  0;
		try(Connection conn = ConnectionProvider.getConnection()) {
			point = pDao.selectUserPoint(conn, userId);
			System.out.println("PaymentService : "+point);

		}catch(SQLException e) {
			throw new RuntimeException(e);
		}		

		return point;
	}



}