package test.com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAOimpl implements CompanyDAO {

	private final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "mini01";
	private final String PASSWORD = "hi123456";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public CompanyDAOimpl() {
		System.out.println("CompanyDAOimpl()...");
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("find successed");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public int insert(CompanyVO vo) {
		System.out.println("insert()...");
		System.out.println(vo);
		int flag = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			String sql = "insert into company(num,id,pw,name,work,tel,loca,salary,divi,filename) values(seq_company.nextval,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getWork());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getLoca());
			pstmt.setString(7, vo.getSalary());
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
	public int update(CompanyVO vo) {
		System.out.println("update()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "update company set id=?,pw=?,name=?,work=?,tel=?,loca=?,salary=?,divi=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getWork());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getLoca());
			pstmt.setString(7, vo.getSalary());
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
	public int delete(CompanyVO vo) {
		System.out.println("delete()...");
		System.out.println(vo);
		int flag = 0;
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "delete from company where num=?";
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
	public CompanyVO selectOne(CompanyVO vo) {
		System.out.println("selectOne()...");
		System.out.println(vo);
		
		
		CompanyVO vo2 = new CompanyVO();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			if(vo.getNum()!=0) {
				String sql = "select * from company where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, vo.getNum());
			}else{
				String sql = "select * from company where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getId());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setWork(rs.getString("work"));
				vo2.setTel(rs.getString("tel"));
				vo2.setLoca(rs.getString("loca"));
				vo2.setSalary(rs.getString("salary"));
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
	public List<CompanyVO> selectAll() {
		System.out.println("selectAll()...");
		List<CompanyVO> list = new ArrayList<CompanyVO>();
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from company order by num asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CompanyVO vo2 = new CompanyVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setWork(rs.getString("work"));
				vo2.setTel(rs.getString("tel"));
				vo2.setLoca(rs.getString("loca"));
				vo2.setSalary(rs.getString("salary"));
				vo2.setDivi(rs.getString("divi"));
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
	public List<CompanyVO> searchList(String searchKey, String searchWord) {
		System.out.println("searchList()...");
		System.out.println("searchKey:" + searchKey);
		System.out.println("searchWord:" + searchWord);
		List<CompanyVO> list = new ArrayList<CompanyVO>();

	
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from company where "+searchKey+" like ? order by num asc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CompanyVO vo2 = new CompanyVO();
				vo2.setNum(rs.getInt("num"));
				vo2.setId(rs.getString("id"));
				vo2.setPw(rs.getString("pw"));
				vo2.setName(rs.getString("name"));
				vo2.setWork(rs.getString("work"));
				vo2.setTel(rs.getString("tel"));
				vo2.setLoca(rs.getString("loca"));
				vo2.setSalary(rs.getString("salary"));
				vo2.setDivi(rs.getString("divi"));
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
	public CompanyVO loginOK(CompanyVO vo) {
		System.out.println("loginOK()....");
		System.out.println(vo);
		CompanyVO vo2 = null;

		if (vo.getId().trim().length() == 0 || vo.getPw().trim().length() == 0)
			return vo2;

		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");

			String sql = "select * from company where id =? and pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new CompanyVO();
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
	public String idCheck(CompanyVO vo) {
		System.out.println("idCheck()...");
		System.out.println(vo);
		String result = "OK";
		
		if(vo.getId().trim().length()==0) return "NotOK";
		
		try {
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println("conn successed....");
			
			String sql = "select * from company where id =?";
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
