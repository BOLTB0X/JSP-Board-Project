package test.com.cboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CboardDAOimpl implements CboardDAO {
	
	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "mini01";
	private final String PASSWORD = "hi123456";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CboardDAOimpl() {
		System.out.println("CboardDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("find successed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(CboardVO vo) {
		System.out.println("insert()...");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			String sql = "insert into cboard(num,title,content,writer) values(seq_cboard.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setString(3,vo.getWriter());
		
			flag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		

		return flag;
	}

	@Override
	public int update(CboardVO vo) {
		System.out.println("update()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "update cboard set title=?,content=?,writer=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getNum());
			
			flag = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	@Override
	public int delete(CboardVO vo) {
		System.out.println("delete()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "delete from cboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			flag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	@Override
	public CboardVO selectOne(CboardVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);
		
		
		CboardVO vo2 = new CboardVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql="update cboard set cnt=cnt+1 where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			sql = "select * from cboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("Title"));
				vo2.setContent(rs.getString("Content"));
				vo2.setWriter(rs.getString("Writer"));
				vo2.setWdate(rs.getDate("wdate"));
				vo2.setStr_wdate(rs.getString("wdate"));
				vo2.setCnt(rs.getInt("cnt"));
				vo2.setLik(rs.getInt("lik"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vo2;
	}

	@Override
	public List<CboardVO> selectAll() {
		System.out.println("selectAll()...");
		List<CboardVO> list = new ArrayList<CboardVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from cboard order by num asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CboardVO vo2 = new CboardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("Title"));
				vo2.setContent(rs.getString("Content"));
				vo2.setWriter(rs.getString("Writer"));
				vo2.setWdate(rs.getDate("wdate"));
				vo2.setStr_wdate(rs.getString("wdate"));
				vo2.setCnt(rs.getInt("cnt"));
				vo2.setLik(rs.getInt("lik"));
				list.add(vo2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	@Override
	public List<CboardVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println("searchKey:" + searchKey);
		System.out.println("searchWord:" + searchWord);
		List<CboardVO> list = new ArrayList<CboardVO>();

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from cboard where "+searchKey+" like ? order by num asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CboardVO vo2 = new CboardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("Title"));
				vo2.setContent(rs.getString("Content"));
				vo2.setWriter(rs.getString("Writer"));
				vo2.setWdate(rs.getDate("wdate"));
				vo2.setStr_wdate(rs.getString("wdate"));
				vo2.setCnt(rs.getInt("cnt"));
				vo2.setLik(rs.getInt("lik"));
				list.add(vo2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	@Override
	public int likeup(CboardVO vo) {
		System.out.println("likeup()....");
		System.out.println(vo);
		int flag=0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql="update cboard set lik=lik+1 where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			flag = pstmt.executeUpdate();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}//
