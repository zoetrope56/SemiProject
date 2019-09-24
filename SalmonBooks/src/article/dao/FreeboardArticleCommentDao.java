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

import article.model.FreeboardArticleComment;
import jdbc.JdbcUtil;

public class FreeboardArticleCommentDao {
	Properties prop;
	
	public FreeboardArticleCommentDao() {
		prop = new Properties();
		String filePath = FreeboardArticleCommentDao.class.getResource("/config/freeboard-article-comment-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public FreeboardArticleComment insert(Connection conn, FreeboardArticleComment comment) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement stmt = null;
		int insertedCount;
		FreeboardArticleComment newComment = null;
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
							newComment = new FreeboardArticleComment(rs.getInt(1), comment.getArticleNo(), comment.getWriterId(), comment.getRegDate(), comment.getModDate(), comment.getContent());
						}	
					}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return newComment;
	}
	public List<FreeboardArticleComment> selectByArticleNo(Connection conn, int no)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeboardArticleComment> list = null;
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
	public int selectCount(Connection conn, int no) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	public List<FreeboardArticleComment> select(Connection conn, int no, int start, int end)throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("select");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, end-start);
			rs = pstmt.executeQuery();
			List<FreeboardArticleComment> list = new ArrayList<>();
			while(rs.next()) {
				list.add(
						new FreeboardArticleComment(
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
	private FreeboardArticleComment convertComment(ResultSet rs) throws SQLException{
		return new FreeboardArticleComment(rs.getInt("comment_id"), rs.getInt("article_no"), rs.getString("writer_id"), rs.getTimestamp("regdate"), rs.getTimestamp("moddate"), rs.getString("comment_content"));
	}
}
//create table freeboard_article_comment(
//		comment_id varchar(20) not null primary key,
//		article_no int,
//	    writer_id varchar(50) not null,
//	    regdate datetime not null,
//	    moddate datetime not null,
//	    comment_content varchar(100) not null,
//	    foreign key  (article_no) references freeboard_article(article_no) on delete cascade
//	);