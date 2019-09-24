package reviewboard.article.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import jdbc.JdbcUtil;

import reviewboard.article.model.ReviewBoardArticleComment;


public class ReviewBoardArticleCommentDao {
	Properties prop;
	public ReviewBoardArticleCommentDao() {
		prop = new Properties();
		String filePath = ReviewBoardArticleCommentDao.class.getResource("/config/reviewboard-article-comment-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ReviewBoardArticleComment insert(Connection conn, ReviewBoardArticleComment comment) throws SQLException{

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement stmt = null;
		int insertedCount;
		ReviewBoardArticleComment newComment = null;
		String sql = prop.getProperty("insert");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getArticleNo());
			pstmt.setString(2, comment.getWriterId());
			pstmt.setTimestamp(3, toTimestamp(comment.getRegDate()));
			pstmt.setTimestamp(4, toTimestamp(comment.getModDate()));
			pstmt.setString(5, comment.getContent());
			insertedCount = pstmt.executeUpdate();
			if(insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(prop.getProperty("lastInserted"));
				if(rs.next()) {
					newComment = new ReviewBoardArticleComment(rs.getInt(1), comment.getArticleNo(), comment.getWriterId(), comment.getRegDate(), comment.getModDate(), comment.getContent());
				}
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return newComment;
	}


	public List<ReviewBoardArticleComment> selectByArticleNo(Connection conn, int no)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewBoardArticleComment> list = null;
		String sql = prop.getProperty("selectByArticleNo");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(convertComment(rs));
			}
			return list;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int selectCount(Connection conn,int no) throws SQLException{
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		String sql = prop.getProperty("selectCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	

	public List<ReviewBoardArticleComment> select(Connection conn, int no, int start, int end)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("select");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, end-start);
			rs = pstmt.executeQuery();
			List<ReviewBoardArticleComment> list = new ArrayList<>();
			while(rs.next()) {
				list.add(
						new ReviewBoardArticleComment(
								rs.getInt("comment_id"),
								rs.getInt("article_no"),
								rs.getString("writer_id"),
								rs.getTimestamp("regdate"),
								rs.getTimestamp("moddate"),
								rs.getString("comment_content")
						)
					);
			}
			return list;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
	private ReviewBoardArticleComment convertComment(ResultSet rs) throws SQLException{
		return new ReviewBoardArticleComment(rs.getInt("comment_id"), rs.getInt("article_no"), rs.getString("writer_id"), rs.getTimestamp("regdate"), rs.getTimestamp("moddate"), rs.getString("comment_content"));
	}


}