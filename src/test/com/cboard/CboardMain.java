package test.com.cboard;

import java.util.List;

public class CboardMain {

	public static void main(String[] args) {
		System.out.println("이력서 프로그램");
		
		//1.MemberVO-num,id,pw,name,tel: 은닉,게터세터,toString(),hashcode&equals메소드 오버라이딩
		//2.MemberDAO-interface:insert,update,delete,selectOne,selectAll,searchList 추상메소드들
		//3.MemberDAOimpl-MemberDAO를 상속받은 클래스
			//3-1.생성자:드라이버 연결(jdbc라이브러리 추가할것lib폴더만들어서 
						//넣고Add to build path)
		CboardDAO dao = new CboardDAOimpl();
		/*
			//3-2.각 오버라이딩된 메소드에서 디비커넥팅 및 예외처리
				//3-2-1:insert
		BoardVO vo = new BoardVO();
		vo.setTitle("aaaa");
		vo.setContent("bbb");
		vo.setWriter("kim");
		vo.setWdate("0309");
		int result = dao.insert(vo);
		System.out.println("insert result:"+result);
		
		
		//3-2-2:update
		BoardVO vo1 = new BoardVO();
		vo1.setNum(1);
		vo1.setTitle("aaaa");
		vo1.setContent("bbb");
		vo1.setWriter("kim");
		vo1.setWdate("0309");
		result = dao.update(vo);
		System.out.println("update result:"+result);
		
		
		//3-2-3:delete
		vo = new BoardVO();
		vo.setNum(11);
		result = dao.delete(vo);
		System.out.println("delete result:"+result);
		
		//3-2-4:selectOne
		vo = new BoardVO();
		vo.setNum(6);
		BoardVO vo2 = dao.selectOne(vo);
		System.out.println("selectOne vo2:"+vo2);
		
		//3-2-5:selectAll
		vo = new BoardVO();
		vo.setNum(10);
		
		vo2 = dao.selectOne(vo);
		List<BoardVO> list = dao.selectAll();
		for (BoardVO x : list) {
			System.out.print(x.getNum()+" ");
			System.out.print(x.getTitle()+" ");
			System.out.print(x.getContent()+" ");
			System.out.println(x.getWriter()+" ");
		}
		
		
		//3-2-6:searchList
		list = dao.searchList("aaa", "k");
		for (BoardVO x : list) {
			System.out.print(x.getNum()+" ");
			System.out.print(x.getTitle()+" ");
			System.out.print(x.getContent()+" ");
			System.out.println(x.getWriter()+" ");
		}
		
			//3-3.각 오버라이딩된 메소드에서 쿼리를 실행 로직작성 및 반환처리
				//쿼리실행을 위해서 테이블 및 시퀀스를 미리생성해둘것.
				//예: 테이블명:member,컬럼명:VO속성을 참고해서 생성,시퀀스명:seq_테이블명
				//3-3-1:insert
				//3-3-2:update
				//,,,,
			
		
		//4.메인메소드에서 각 입력,수정,삭제,단일검색,모두검색,조건검색 테스팅 및 출력
		
		*/
		
	}//end main

}//end class
