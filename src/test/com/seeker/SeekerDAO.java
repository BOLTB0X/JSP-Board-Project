package test.com.seeker;

import java.util.List;

public interface SeekerDAO {

	public int insert(SeekerVO vo);

	public int update(SeekerVO vo);

	public int delete(SeekerVO vo);

	public SeekerVO selectOne(SeekerVO vo);

	public List<SeekerVO> selectAll();

	public List<SeekerVO> searchList(String searchKey, String searchWord);

	public SeekerVO loginOK(SeekerVO vo);

	public String idCheck(SeekerVO vo);

}
