package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class SignInService {
	private MemberDao memberDao = new MemberDao();
	public void SignIn(SignInRequest inReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, inReq.getId());
			if(member != null) {
				JdbcUtil.close(conn);
				throw new DuplicateIdException();
			}
			Member newMember = new Member(
					inReq.getId(),
					inReq.getName(),
					inReq.getPassword(),
					inReq.getEmail(),
					inReq.getTel(),
					inReq.getBirth()
			);
			memberDao.insert(conn, newMember);
			conn.commit();
			System.out.println("[SignInService] 회원가입 완료");
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}
	public boolean duplicateCheckId(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			Member member = memberDao.selectById(conn, id);
			return member == null ? false : true;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
