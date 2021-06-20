package test.com.cboard;

import java.util.List;

public interface CboardDAO {
	
	public int insert(CboardVO vo);
	
	public int update(CboardVO vo);
	
	public int delete(CboardVO vo);
	
	public CboardVO selectOne(CboardVO vo);
	
	public List<CboardVO> selectAll();

	public List<CboardVO> searchList(String searchKey, String searchWord);

	public int likeup(CboardVO vo);
}
