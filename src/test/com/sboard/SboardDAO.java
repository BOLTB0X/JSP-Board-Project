package test.com.sboard;

import java.util.List;

public interface SboardDAO {
	
	public int insert(SboardVO vo);
	
	public int update(SboardVO vo);
	
	public int delete(SboardVO vo);
	
	public SboardVO selectOne(SboardVO vo);
	
	public List<SboardVO> selectAll();

	public List<SboardVO> searchList(String searchKey, String searchWord);

}
