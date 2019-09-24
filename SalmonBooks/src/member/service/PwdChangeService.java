package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class PwdChangeService {
	private MemberDao memberDao = new MemberDao();
	
	public void changePwd(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			member = memberDao.selectById(conn, userId);

			if(member.equals(null)) {
				throw new MemberNotFoundException();
			}
			if(!member.matchPassword(curPwd)) {
				throw new InvalidPasswordException();
			}

			member.setPassword(newPwd);
			memberDao.updatePwd(conn, member);
			conn.commit();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
	}

}
