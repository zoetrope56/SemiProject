package reviewboard.article.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import article.model.FreeboardArticleContent;
import jdbc.JdbcUtil;
import reviewboard.article.model.ReviewBoardArticleContent;



public class ReviewBoardArticleContentDao {
	Properties prop;
	
	public ReviewBoardArticleContentDao() {
		prop = new Properties();
		
		String filePath = ReviewBoardArticleContentDao.class.getResource("/config/reviewboard-article-content-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ReviewBoardArticleContent insert(Connection conn,ReviewBoardArticleContent content) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insert");
		System.out.println("홍은영은 바보다 찝알");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if(insertedCount >0 ) {
				return content;
			}else {
				return null;
			}
			
		}finally {
			JdbcUtil.close(pstmt);
		}
	}
	public ReviewBoardArticleContent selectById(Connection conn,int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewBoardArticleContent content = null;
		String sql = prop.getProperty("selectById");
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				content = new ReviewBoardArticleContent(rs.getInt("article_no"), rs.getString("content"));
				
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return content;
	}

}
