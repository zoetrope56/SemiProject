package reviewboard.article.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Date;

import jdbc.JdbcUtil;
import reviewboard.article.model.ReviewBoardArticleComment;

public class ReviewBoardAricleCommentDao {

	Properties prop;

	public ReviewBoardAricleCommentDao() {
		prop = new Properties();
		String filePath = ReviewBoardAricleCommentDao.class.getResource("/config/freeboard-article-comment-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ReviewBoardArticleComment insert(Connection conn, ReviewBoardArticleComment comment) throws SQLException{
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		Statement stmt =null;
		int insertedCount;
		ReviewBoardArticleComment newComment =null;
		String sql = prop.getProperty("insert");
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getArticleNo());
			pstmt.setString(2,comment.getWriterId());
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
	public List<ReviewBoardArticleComment> selectByArticleNo(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt =null;
		ResultSet rs =null;
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
		private Timestamp toTimestamp(Date date) {
			return new Timestamp(date.getTime());

		}
		private ReviewBoardArticleComment convertComment(ResultSet rs) throws SQLException{
			return new ReviewBoardArticleComment(
					rs.getInt("commnet_id"),
					rs.getInt("article_no"),
							rs.getString("writer_id"),rs.getTimestamp("redate"), rs.getTimestamp("moddate"), rs.getString("comment_content"));
		}

	}
