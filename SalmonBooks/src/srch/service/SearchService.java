package srch.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;

public class SearchService {
	MemberDao memberDao = new MemberDao();
	Connection conn;
	
	public String idSearch(String name, String email) {
		String id = null;
		try {
			conn = ConnectionProvider.getConnection();
			id = memberDao.findId(conn, name, email);
			System.out.println("[IDSearchService] 회원 계정 조회");
			
			if(id==null) {
				System.out.println("[IDSearchService] 해당하는 계정 없음");
				throw new SearchFailException();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public String pwdSearch(String name, String email, String phone) {
		String result = null;
		try {
			conn = ConnectionProvider.getConnection();
			result = memberDao.findPwd(conn, name, email, phone);
			System.out.println("[PWDSearchService] 회원 계정 조회");
			
			if(result==null) {
				System.out.println("[PWDSearchService] 해당하는 계정 없음");
				throw new SearchFailException();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
