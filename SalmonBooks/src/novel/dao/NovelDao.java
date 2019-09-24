package novel.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import jdbc.JdbcUtil;
import novel.vo.DetailNovel;
import novel.vo.NovelInfo;

public class NovelDao {

	private Properties prop;

	public NovelDao() {
		prop = new Properties();

		String filePath = NovelDao.class.getResource("/config/novel-article-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn, String free, String complate) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCount");

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, free);
			pstmt.setString(2, complate);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return listCount;

	}

	public int getDetailListCount(Connection con, int nno) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("DetaillistCount");
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return listCount;

	}

	public ArrayList<NovelInfo> selectNovelList(Connection conn, int currentPage, int limit, String free,
			String complate) {
		ArrayList<NovelInfo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1) * limit + 1; // 1, 11
			int endRow = startRow + limit - 1;
			pstmt.setString(1, free);
			pstmt.setString(2, complate);
			pstmt.setInt(3, endRow);
			pstmt.setInt(4, startRow);
			rset = pstmt.executeQuery();
			list = new ArrayList<NovelInfo>();

			while (rset.next()) {
				NovelInfo sn = new NovelInfo();
				sn.setNno(rset.getInt("NNO"));
				sn.setGenre(rset.getString("NGENRE"));
				sn.setNtitle(rset.getString("NTITLE"));
				sn.setnWriter(rset.getString("NWRITER"));
				sn.setTotal(rset.getInt("TOTAL"));
				sn.setImg(rset.getString("IMG"));
				sn.setPay(rset.getInt("PAY"));
				list.add(sn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return list;
	}

	public int updateReadCount(Connection con, int nno) {

		int result = 0;

		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateReadCount");

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, nno);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	public NovelInfo selectOne(Connection conn, int nno) {

		NovelInfo ni = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectOne");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				ni = new NovelInfo();
				ni.setNno(rset.getInt("NNO"));
				ni.setFree(rset.getString("FREE"));
				ni.setGenre(rset.getString("NGENRE"));
				ni.setNtitle(rset.getString("NTITLE"));
				ni.setnWriter(rset.getString("NWRITER"));
				ni.setnSimpContent(rset.getString("NSIMPCONTENT"));
				ni.setTotal(rset.getInt("TOTAL"));
				ni.setnView(rset.getInt("NVIEW"));
				ni.setImg(rset.getString("IMG"));
				ni.setPay(rset.getInt("PAY"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return ni;
	}

	public ArrayList<DetailNovel> selectDetailList(Connection conn, int nno, int currentPage, int limit) {
		ArrayList<DetailNovel> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectDetailList");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1) * limit + 1; // 1, 11
			int endRow = startRow + limit - 1;
			pstmt.setInt(1, nno);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			rset = pstmt.executeQuery();
			list = new ArrayList<DetailNovel>();
			while (rset.next()) {
				DetailNovel dn = new DetailNovel();
				dn.setNno(rset.getInt("NNO"));
				dn.setDno(rset.getInt("DNO"));
				dn.setImg(rset.getString("IMG"));
				dn.setdTitle(rset.getString("DTITLE"));
				dn.setRate(rset.getDouble("RATE"));
				dn.setnDate(rset.getDate("NDATE"));
				dn.setContent(rset.getString("CONTENT"));

				list.add(dn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return list;
	}

	public ArrayList<NovelInfo> selectTop3List(Connection conn, String free, String complate) {
		NovelInfo ni = null;
		ArrayList<NovelInfo> top3list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTop3List");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, free);
			pstmt.setString(2, complate);
			rset = pstmt.executeQuery();
			top3list = new ArrayList<NovelInfo>();
			while (rset.next()) {
				ni = new NovelInfo();
				ni.setNno(rset.getInt("NNO"));
				ni.setNtitle(rset.getString("NTITLE"));
				ni.setnWriter(rset.getString("NWRITER"));
				ni.setnView(rset.getInt("NVIEW"));
				ni.setImg(rset.getString("IMG"));
				ni.setTotal(rset.getInt("TOTAL"));
				ni.setPay(rset.getInt("PAY"));
				top3list.add(ni);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return top3list;
	}

	public int insertNovel(Connection conn, NovelInfo novel) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("enrollNovel");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, novel.getGenre());
			pstmt.setString(2, novel.getNtitle());
			pstmt.setString(3, novel.getFree());
			pstmt.setString(4, novel.getnWriter());
			pstmt.setString(5, novel.getnSimpContent());
			pstmt.setString(6, novel.getImg());
			pstmt.setInt(7, novel.getPay());

			//

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	public DetailNovel selectOne(Connection conn, int nno, int dno) {
		DetailNovel dn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectViewOne");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			pstmt.setInt(2, dno);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				dn = new DetailNovel();
				dn.setNno(rset.getInt("NNO"));
				dn.setDno(rset.getInt("DNO"));
				dn.setnTitle(rset.getNString("NTITLE"));
				dn.setImg(rset.getString("IMG"));
				dn.setdTitle(rset.getString("DTITLE"));
				dn.setnDate(rset.getDate("NDATE"));
				dn.setRate(rset.getDouble("RATE"));
				dn.setContent(rset.getString("CONTENT"));


			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return dn;
	}

	public int uploadNovel(Connection conn, DetailNovel uplnovel) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("uploadNovel");


		try {
			pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, uplnovel.getNno());
	         pstmt.setInt(2, uplnovel.getNno());
	         pstmt.setString(3, uplnovel.getImg());
	         pstmt.setString(4, uplnovel.getdTitle());
	         pstmt.setString(5, uplnovel.getContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

		return result;
	}

	public int getListCount(Connection conn, String free, String complate, String genre) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("genrelistCount");

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, free);
			pstmt.setString(2, complate);
			pstmt.setString(3, genre);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCount = rset.getInt("LISTCOUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return listCount;
	}

	public ArrayList<NovelInfo> selectNovelList(Connection conn, int currentPage, int limit, String free,
			String complate, String genre) {
		ArrayList<NovelInfo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("genreSelectList");
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (currentPage - 1) * limit + 1; // 1, 11
			int endRow = startRow + limit - 1;
			pstmt.setString(1, free);
			pstmt.setString(2, complate);
			pstmt.setString(3, genre);
			pstmt.setInt(4, endRow);
			pstmt.setInt(5, startRow);
			rset = pstmt.executeQuery();
			list = new ArrayList<NovelInfo>();

			while (rset.next()) {
				NovelInfo sn = new NovelInfo();
				sn.setNno(rset.getInt("NNO"));
				sn.setGenre(rset.getString("NGENRE"));
				sn.setNtitle(rset.getString("NTITLE"));
				sn.setnWriter(rset.getString("NWRITER"));
				sn.setTotal(rset.getInt("TOTAL"));
				sn.setImg(rset.getString("IMG"));
				sn.setPay(rset.getInt("PAY"));
				list.add(sn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return list;
	}

	public ArrayList<NovelInfo> selectTop3List(Connection conn, String free, String complate, String genre) {
		NovelInfo ni = null;
		ArrayList<NovelInfo> top3list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("genreSelectTop3List");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, free);
			pstmt.setString(2, complate);
			pstmt.setString(3, genre);
			rset = pstmt.executeQuery();
			top3list = new ArrayList<NovelInfo>();
			while (rset.next()) {
				ni = new NovelInfo();
				ni.setNno(rset.getInt("NNO"));
				ni.setNtitle(rset.getString("NTITLE"));
				ni.setnWriter(rset.getString("NWRITER"));
				ni.setnView(rset.getInt("NVIEW"));
				ni.setImg(rset.getString("IMG"));
				ni.setTotal(rset.getInt("TOTAL"));
				ni.setPay(rset.getInt("PAY"));
				top3list.add(ni);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return top3list;
	}

	public ArrayList<NovelInfo> searchNovel(Connection conn, String keyword) {
		NovelInfo ni = null;
		ArrayList<NovelInfo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("searchList");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			pstmt.setString(2, keyword);
			rset = pstmt.executeQuery();
			list = new ArrayList<NovelInfo>();
			while (rset.next()) {
				ni = new NovelInfo();
				ni.setNno(rset.getInt("NNO"));
				ni.setNtitle(rset.getString("NTITLE"));
				ni.setnWriter(rset.getString("NWRITER"));
				ni.setnView(rset.getInt("NVIEW"));
				ni.setImg(rset.getString("IMG"));
				ni.setTotal(rset.getInt("TOTAL"));
				ni.setPay(rset.getInt("PAY"));
				list.add(ni);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return list;
	}

	public ArrayList<NovelInfo> selectUserNovel(Connection conn, String userId) {
		NovelInfo ni = null;
		ArrayList<NovelInfo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectUserNovel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			list = new ArrayList<NovelInfo>();
			while(rset.next()) {
				ni = new NovelInfo();
				ni.setNno(rset.getInt("NNO"));
				ni.setFree(rset.getString("FREE"));
				ni.setGenre(rset.getString("NGENRE"));
				ni.setNtitle(rset.getString("NTITLE"));
				ni.setnWriter(rset.getString("NWRITER"));
				ni.setnSimpContent(rset.getString("NSIMPCONTENT"));
				ni.setTotal(rset.getInt("TOTAL"));
				ni.setnView(rset.getInt("NVIEW"));
				ni.setImg(rset.getString("IMG"));
				ni.setPay(rset.getInt("PAY"));
				list.add(ni);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}

		return list;
	}
	
	public NovelInfo selectLastinsertedNovel(Connection conn, String userId) {
		NovelInfo ni = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectLastInsertedNovel");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ni = new NovelInfo();
				ni.setNno(rset.getInt("NNO"));
				ni.setFree(rset.getString("FREE"));
				ni.setGenre(rset.getString("NGENRE"));
				ni.setNtitle(rset.getString("NTITLE"));
				ni.setnWriter(rset.getString("NWRITER"));
				ni.setnSimpContent(rset.getString("NSIMPCONTENT"));
				ni.setTotal(rset.getInt("TOTAL"));
				ni.setnView(rset.getInt("NVIEW"));
				ni.setImg(rset.getString("IMG"));
				ni.setPay(rset.getInt("PAY"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rset);
			JdbcUtil.close(pstmt);
		}
		return ni;
	}
}
