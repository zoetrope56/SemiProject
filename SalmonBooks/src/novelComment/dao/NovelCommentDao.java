package novelComment.dao;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import jdbc.JdbcUtil;
import novel.vo.NovelInfo;
import novelComment.vo.NovelComment;

public class NovelCommentDao {

	private Properties prop = new Properties();

	public NovelCommentDao() {
		String filePath = NovelCommentDao.class.getResource("/config/comment-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<NovelComment> selectList(Connection conn, int nno, int dno) {
		ArrayList<NovelComment> clist = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		System.out.println(sql);
			try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, nno);
			pstmt.setInt(2, dno);
			rset = pstmt.executeQuery();			
			clist = new ArrayList<NovelComment>();
			
			while(rset.next()) {
				NovelComment nc = new NovelComment();
				
				nc.setCno(rset.getInt("CNO"));
				nc.setNno(rset.getInt("NNO"));
				nc.setDno(rset.getInt("DNO"));
				nc.setCcontent(rset.getString("CCONTENT"));
				nc.setCwriter(rset.getString("CWRITER"));
				nc.setCdate(rset.getDate("CDATE"));
				nc.setRefcno(rset.getInt("REFCNO"));
				nc.setClevel(rset.getInt("CLEVEL"));
				clist.add(nc);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(rset);
				JdbcUtil.close(pstmt);
			}
			return clist;
	}

	public int insertComment(Connection conn, NovelComment nco) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nco.getNno());
			pstmt.setInt(2, nco.getDno());
			pstmt.setString(3, nco.getCcontent());
			pstmt.setString(4, nco.getCwriter());
			if(nco.getRefcno() > 0) {
				pstmt.setInt(5, nco.getRefcno());
			}else {
				pstmt.setNull(5, java.sql.Types.NULL);
			}
			pstmt.setInt(6, nco.getClevel());
			System.out.println("댓글 수정 찍기 다오 : "+ nco.getCcontent() + nco.getClevel() + nco.getRefcno());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		return result;
	}
}
