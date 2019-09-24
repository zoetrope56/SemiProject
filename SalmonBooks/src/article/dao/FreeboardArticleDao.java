package article.dao;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import article.model.FreeboardArticle;
import article.model.FreeboardWriter;
import jdbc.JdbcUtil;

public class FreeboardArticleDao {
	private Properties prop;
	
	
	public FreeboardArticleDao() {
		prop = new Properties();
		
		String filePath = FreeboardArticleDao.class
				.getResource("/config/freeboard-article-query.properties").getPath();
		try{
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public FreeboardArticle insert(Connection conn, FreeboardArticle article) throws SQLException{
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("insert");
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			pstmt.setString(6, article.getCategory());
			int insertedCount = pstmt.executeUpdate();
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(prop.getProperty("lastInserted"));
				if(rs.next()) {
					Integer newNum = rs.getInt(1);
					return new FreeboardArticle(
							newNum,
							article.getWriter(),
							article.getTitle(),
							article.getRegDate(),
							article.getModifiedDate(),
							article.getCategory(),
							0,
							0
							);
				}
			}
			return null;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	public int selectCount(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCount");
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	public List<FreeboardArticle> select(Connection conn, int startRow, int size) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("select");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(2, startRow);
			pstmt.setInt(1, size);
//			pstmt.setInt(2, startRow);
//			pstmt.setInt(1, size);
			rs = pstmt.executeQuery();
			List<FreeboardArticle> result = new ArrayList<FreeboardArticle>();
			while(rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public FreeboardArticle selectById(Connection conn, int no)throws SQLException{
		FreeboardArticle article = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectById");
		System.out.println("sql : " + sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				article = convertArticle(rs);
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return article;
	}
	public void increaseReadCount(Connection conn, int no)throws SQLException{
		String sql = prop.getProperty("increaseReadCount");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			pstmt.execute();
		}
	}
	public void increaseRecommendCount(Connection conn, int no) throws SQLException{
		String sql = prop.getProperty("increaseRecommentCount");
		System.out.println("sql : " + sql);
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, no);
			pstmt.execute();
		}
	}
	private FreeboardArticle convertArticle(ResultSet rs) throws SQLException{
		return new FreeboardArticle(
				rs.getInt("article_no"),
				new FreeboardWriter(rs.getString("writer_id"), 
						rs.getString("writer_name")),
				rs.getString("title"),
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")),
				rs.getString("category"),
				rs.getInt("read_cnt"),
				rs.getInt("recommend")
				);
	}
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
}
