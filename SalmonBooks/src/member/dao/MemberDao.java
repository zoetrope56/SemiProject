package member.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	private Properties prop;

	public MemberDao() {
		prop = new Properties();

		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public Member selectById(Connection conn, String id)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectById");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			Member member = null;
			if(rs.next()) {
				member = new Member(rs.getString("user_id"), rs.getString("username"), rs.getString("password"), rs.getString("email"),	rs.getString("tel"),rs.getDate("birth"));
			}
			return member;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public String findId(Connection conn, String name, String email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findId");
		String id= null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);

			rset = pstmt.executeQuery();
			while(rset.next()) {
				id = rset.getString("user_id");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return id;
	}

	public String findPwd(Connection conn, String name, String email, String phone) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findPwd");
		String password = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);

			rset = pstmt.executeQuery();
			System.out.println("[MemberDao] : "+rset);
			while(rset.next()) {
				password = rset.getString("password");
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return password;
	}


	public void insert(Connection conn, Member mem)throws SQLException{
		String sql = prop.getProperty("insert");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getTel());
			pstmt.setDate(6, new java.sql.Date(mem.getBirth().getTime()));
			pstmt.executeUpdate();
		}
	}

	public void updatePwd(Connection conn, Member mem)throws SQLException{

		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("changePwd"))){
			pstmt.setString(1, mem.getPassword());
			pstmt.setString(2, mem.getUserId());
			pstmt.setString(3, mem.getName());
			pstmt.executeUpdate();

		}
	}

	public void updateEmail(Connection conn, Member mem) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("changeEmail"))){
			pstmt.setString(1, mem.getEmail());
			pstmt.setString(2, mem.getUserId());
			pstmt.setString(3, mem.getName());
			pstmt.executeUpdate();

		}
	}
	
	public void updateTel(Connection conn, Member mem) throws SQLException {
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("changeTel"))){
			pstmt.setString(1, mem.getTel());
			pstmt.setString(2, mem.getUserId());
			pstmt.setString(3, mem.getName());
			pstmt.executeUpdate();

		}
	}
}
