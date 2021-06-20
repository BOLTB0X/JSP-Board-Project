package test.com.sboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SboardDAOimpl implements SboardDAO {
	
	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "mini01";
	private final String PASSWORD = "hi123456";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SboardDAOimpl() {
		System.out.println("SboardDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("find successed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(SboardVO vo) {
		System.out.println("insert()...");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			String sql = "insert into sboard(num,title,content,writer) values(seq_sboard.nextval,?,?,?)";
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
	public int update(SboardVO vo) {
		System.out.println("update()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "update sboard set title=?,content=?,writer=? where num=?";
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
	public int delete(SboardVO vo) {
		System.out.println("delete()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "delete from sboard where num=?";
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
	public SboardVO selectOne(SboardVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);
		
		SboardVO vo2 = new SboardVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql="update sboard set cnt=cnt+1 where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			sql = "select * from sboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("Title"));
				vo2.setContent(rs.getString("Content"));
				vo2.setWriter(rs.getString("Writer"));
				vo2.setCnt(rs.getInt("cnt"));
				
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
	public List<SboardVO> selectAll() {
		System.out.println("selectAll()...");
		List<SboardVO> list = new ArrayList<SboardVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from sboard order by num asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SboardVO vo2 = new SboardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("Title"));
				vo2.setContent(rs.getString("Content"));
				vo2.setWriter(rs.getString("Writer"));
				vo2.setWdate(rs.getDate("wdate"));
				vo2.setStr_wdate(rs.getString("wdate"));
				vo2.setCnt(rs.getInt("cnt"));
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
	public List<SboardVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println("searchKey:" + searchKey);
		System.out.println("searchWord:" + searchWord);
		List<SboardVO> list = new ArrayList<SboardVO>();

	
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from sboard where "+searchKey+" like ? order by num asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SboardVO vo2 = new SboardVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setTitle(rs.getString("Title"));
				vo2.setContent(rs.getString("Content"));
				vo2.setWriter(rs.getString("Writer"));
				vo2.setWdate(rs.getDate("wdate"));
				vo2.setStr_wdate(rs.getString("wdate"));
				vo2.setCnt(rs.getInt("cnt"));
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
}//
