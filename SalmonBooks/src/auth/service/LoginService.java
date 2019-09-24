package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class LoginService {
	MemberDao memberDao = new MemberDao();
	public User login(String id, String password) {
		try(Connection conn = ConnectionProvider.getConnection()){
			Member member = memberDao.selectById(conn, id);
			System.out.println("[LoginService] 회원 아이디 조회");
			if(member == null) {
				System.out.println("[LoginService] 아이디없음");
				throw new LoginFailException();
			}
			if(!member.matchPassword(password)) {
				System.out.println("[LoginService] 비밀번호 틀림");
				throw new LoginFailException();
			}
			return new User(member.getUserId(), member.getName());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
