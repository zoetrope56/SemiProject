package novel.service;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import novel.dao.NovelDao;
import novel.vo.DetailNovel;
import novel.vo.NovelInfo;

public class NovelService {

	private NovelDao nDao = new NovelDao();
	
	public int getListCount(String free, String complate) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int listCount = nDao.getListCount(conn, free, complate);
		
		JdbcUtil.close(conn);
		
		return listCount;
	}
	
	public int getDetailListCount(int nno) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int listCount = nDao.getDetailListCount(conn , nno);
		
		JdbcUtil.close(conn);
		
		return listCount;
	}
	
	public ArrayList<NovelInfo> selectNovelList(int currentPage, int limit, String free, String complate){
		
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			ArrayList<NovelInfo> nList= nDao.selectNovelList(conn,currentPage,limit,free,complate);
			
			JdbcUtil.close(conn);
			
			return nList;
	}

	public NovelInfo selectOne(int nno) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		NovelInfo ni = nDao.selectOne(conn, nno);
		
		if(ni != null) {
			int result = nDao.updateReadCount(conn, nno);
			if(result > 0) JdbcUtil.commit(conn);
			else JdbcUtil.rollback(conn);
			
		}
		
		JdbcUtil.close(conn);
		
		return ni;
	}


	public ArrayList<DetailNovel> selectDetailList(int nno, int currentPage, int limit) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<DetailNovel> dList = nDao.selectDetailList(conn, nno ,currentPage, limit);
		
		JdbcUtil.close(conn);
		
		return dList;
	}

	public ArrayList<NovelInfo> selectTop3List(String free, String complate) {
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<NovelInfo> top3list = nDao.selectTop3List(conn, free, complate);
		
		JdbcUtil.close(conn);
		
		return top3list;
	}

	public int insertNovel(NovelInfo novel) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		int insertNovel = nDao.insertNovel(conn, novel);
		if(insertNovel > 0) JdbcUtil.commit(conn);
		else JdbcUtil.rollback(conn);
		
		JdbcUtil.close(conn);
		
		return insertNovel;
	}

	public DetailNovel selectViewOne(int nno, int dno) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DetailNovel dn = nDao.selectOne(conn, nno, dno);
		
		
		JdbcUtil.close(conn);
		
		return dn;
	}

	public int uploadNovel(DetailNovel uplnovel) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		int uploadNovel = nDao.uploadNovel(conn, uplnovel);
		if(uploadNovel > 0) JdbcUtil.commit(conn);
		else JdbcUtil.rollback(conn);
		JdbcUtil.close(conn);
		
		return uploadNovel;
	}

	public int getListCount(String free, String complate, String genre) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int listCount = nDao.getListCount(conn, free, complate, genre);
		
		JdbcUtil.close(conn);
		
		return listCount;
	}

	public ArrayList<NovelInfo> selectNovelList(int currentPage, int limit, String free, String complate,
			String genre) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<NovelInfo> nList= nDao.selectNovelList(conn,currentPage,limit,free,complate,genre);
		
		JdbcUtil.close(conn);
		
		return nList;
	}

	public ArrayList<NovelInfo> selectTop3List(String free, String complate, String genre) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<NovelInfo> top3list = nDao.selectTop3List(conn, free, complate, genre);
		
		JdbcUtil.close(conn);
		
		return top3list;
	}

	public ArrayList<NovelInfo> searchNovel(String keyword) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		ArrayList<NovelInfo> list = nDao.searchNovel(conn, keyword);
		
		JdbcUtil.close(conn);
		
		return list;
	}
	public NovelInfo selectLastInsertedNovel(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		NovelInfo ni = nDao.selectLastinsertedNovel(conn, id);
		
		JdbcUtil.close(conn);
		return ni;
	}
	
}
