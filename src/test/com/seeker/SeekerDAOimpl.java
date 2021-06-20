package test.com.seeker;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SeekerDAOimpl implements SeekerDAO {

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "mini01";
	private final String PASSWORD = "hi123456";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SeekerDAOimpl() {
		System.out.println("SeekerDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("find successed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public int insert(SeekerVO vo) {
		System.out.println("Seeker insert()...");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			String sql = "insert into seeker(num,id,pw,name,gen,lang,home,career,divi,filename) values(seq_seeker.nextval,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGen());
			pstmt.setString(5, vo.getLang());
			pstmt.setString(6, vo.getHome());
			pstmt.setString(7, vo.getCareer());
			pstmt.setString(8, vo.getDivi());
			pstmt.setString(9, vo.getFilename());
			
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
	public int update(SeekerVO vo) {
		System.out.println("Seeker update()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "update seeker set id=?,pw=?,name=?,gen=?,lang=?,home=?,career=?,divi=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getGen());
			pstmt.setString(5, vo.getLang());
			pstmt.setString(6, vo.getHome());
			pstmt.setString(7, vo.getCareer());
			pstmt.setString(8, vo.getDivi());
			pstmt.setInt(9, vo.getNum());
			
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
	public int delete(SeekerVO vo) {
		System.out.println("Seeker delete()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "delete from seeker where num=?";
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
	public SeekerVO selectOne(SeekerVO vo) {
		System.out.println("Seeker selectOne()...");
		System.out.println(vo);
		
		SeekerVO vo2 = new SeekerVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			if(vo.getNum()!=0) {
				String sql = "select * from seeker where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getNum());
			}else{
				String sql = "select * from seeker where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setGen(rs.getString("gen"));
				vo2.setLang(rs.getString("lang"));
				vo2.setHome(rs.getString("home"));
				vo2.setCareer(rs.getString("career"));
				vo2.setDivi(rs.getString("divi"));
				vo2.setFilename(rs.getString("filename"));
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
		return vo2;
	}

	@Override
	public List<SeekerVO> selectAll() {
		System.out.println("Seeker selectAll()...");
		List<SeekerVO> list = new ArrayList<SeekerVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from seeker  order by num asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SeekerVO vo2 = new SeekerVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setGen(rs.getString("gen"));
				vo2.setLang(rs.getString("lang"));
				vo2.setHome(rs.getString("home"));
				vo2.setCareer(rs.getString("career"));
				vo2.setDivi(rs.getString("Divi"));
				vo2.setFilename(rs.getString("filename"));
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
	public List<SeekerVO> searchList(String searchKey, String searchWord) {
		System.out.println("Seeker searchList()...");
		System.out.println("Seeker searchKey:" + searchKey);
		System.out.println("Seeker searchWord:" + searchWord);
		List<SeekerVO> list = new ArrayList<SeekerVO>();

	
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from seeker where "+searchKey+" like ? order by num asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SeekerVO vo2 = new SeekerVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setGen(rs.getString("gen"));
				vo2.setLang(rs.getString("lang"));
				vo2.setHome(rs.getString("home"));
				vo2.setCareer(rs.getString("career"));
				vo2.setDivi(rs.getString("Divi"));
				vo2.setFilename(rs.getString("filename"));
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
	public SeekerVO loginOK(SeekerVO vo) {
		System.out.println("Seeker loginOK()....");
		System.out.println(vo);
		SeekerVO vo2 = null;

		if (vo.getId().trim().length() == 0 || vo.getPw().trim().length() == 0)
			return vo2;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");

			String sql = "select * from seeker where id =? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new SeekerVO();
				vo2.setFilename(rs.getString("filename"));
				vo2.setDivi(rs.getString("divi"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public String idCheck(SeekerVO vo) {
		System.out.println("Seeker idCheck()...");
		System.out.println(vo);
		String result = "OK";
		
		if(vo.getId().trim().length()==0) return "NotOK";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from seeker where id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result="NotOK";

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
		return result;	
	}
	
}
