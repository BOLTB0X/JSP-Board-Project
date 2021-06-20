package test.com.company;

import java.util.List;

public interface CompanyDAO {

	public int insert(CompanyVO vo);

	public int update(CompanyVO vo);

	public int delete(CompanyVO vo);

	public CompanyVO selectOne(CompanyVO vo);

	public List<CompanyVO> selectAll();

	public List<CompanyVO> searchList(String searchKey, String searchWord);

	public CompanyVO loginOK(CompanyVO vo);

	public String idCheck(CompanyVO vo);

}
