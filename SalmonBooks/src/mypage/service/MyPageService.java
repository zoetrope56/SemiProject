package mypage.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.service.MemberNotFoundException;
import novel.dao.NovelDao;
import novel.vo.NovelInfo;

public class MyPageService {
	private Member member = null;
	private MemberDao memberDao = new MemberDao();
	private NovelDao nDao = new NovelDao();
	
	public Member searchMember(String userId) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			member = memberDao.selectById(conn, userId);
			
			if(member.equals(null)) {
				throw new MemberNotFoundException();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
		return member;
	}

	public void changeEmail(String userId, String userEmail) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			member = searchMember(userId);
			member.setEmail(userEmail);
			memberDao.updateEmail(conn, member);
			conn.commit();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
	}

	public void changePhone(String userId, String userPhone) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			member = searchMember(userId);
			member.setTel(userPhone);
			memberDao.updateTel(conn, member);
			conn.commit();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
	}
	
	public ArrayList<NovelInfo> searchNovel(String userId) {
		Connection conn = null;
		ArrayList<NovelInfo> novel =null;
		try {
			conn = ConnectionProvider.getConnection();
			novel = nDao.selectUserNovel(conn, userId);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
		return novel;
	}


}
