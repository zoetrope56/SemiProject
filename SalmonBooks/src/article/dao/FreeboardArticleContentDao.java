package article.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import article.model.FreeboardArticle;
import article.model.FreeboardArticleContent;
import article.model.FreeboardWriter;
import jdbc.JdbcUtil;

public class FreeboardArticleContentDao {
	Properties prop;
	
	public FreeboardArticleContentDao() {
		prop = new Properties();
		
		String filePath = FreeboardArticleContentDao.class.getResource("/config/freeboard-article-content-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public FreeboardArticleContent insert(Connection conn, FreeboardArticleContent content)throws SQLException{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insert");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if(insertedCount > 0) {
				return content;
			}else {
				return null;
			}
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	public FreeboardArticleContent selectById(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeboardArticleContent content = null;
		String sql = prop.getProperty("selectById");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				content = new FreeboardArticleContent(rs.getInt("article_no"), rs.getString("content"));
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return content;
	}
}
