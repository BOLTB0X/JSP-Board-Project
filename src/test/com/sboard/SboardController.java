package test.com.sboard;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class TestController
 */
@WebServlet({"/sb_selectAll.do", "/sb_insert.do", 
	"/sb_insertOK.do", "/sb_update.do", "/sb_updateOK.do",
    "/sb_deleteOK.do", "/sb_selectOne.do", "/sb_searchList.do", 
    "/sb_idCheck.do", "/sb_loginOK.do", "/sb_logout.do"})
public class SboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SboardController() {
        super();
        System.out.println("BoardController()");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String sPath = request.getServletPath();
		System.out.println("sPath:"+sPath);
	
		if(sPath.equals("/sb_insertOK.do")) {
			
			System.out.println(request.getParameter("num"));
			System.out.println(request.getParameter("title"));
			System.out.println(request.getParameter("content"));
			System.out.println(request.getParameter("writer"));
			
			SboardVO vo = new SboardVO();
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));

			SboardDAO dao = new SboardDAOimpl();
			int result = dao.insert(vo);
			System.out.println("insert result:"+result);
			
			if(result==1)response.sendRedirect("sb_selectAll.do");
			else response.sendRedirect("sb_insert.do");
			
		}else if(sPath.equals("/sb_insert.do")) {
			System.out.println("sboard/insert.jsp");
			RequestDispatcher rd = 
					request.getRequestDispatcher("sboard/insert.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/sb_selectOne.do")) {
			System.out.println("sboard/selectOne.jsp");
			System.out.println("num:"+request.getParameter("num"));
			
			SboardVO vo = new SboardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			SboardDAO dao = new SboardDAOimpl();
			SboardVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);
			
			request.setAttribute("vo2", vo2);
			
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("sboard/selectOne.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/sb_selectAll.do")) {
			System.out.println("sboard/selectAll.jsp");
			SboardDAO dao = new SboardDAOimpl();
			List<SboardVO> list = dao.selectAll();
			
			for (SboardVO x : list) {
				System.out.println(x);
			}
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("sboard/selectAll.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/sb_searchList.do")) {
			System.out.println("sboard/selectAll.jsp");
			System.out.println("searchWord:" + request.getParameter("searchKey"));			
			System.out.println("searchWord:" + request.getParameter("searchWord"));			
			
			SboardDAO dao = new SboardDAOimpl();
			
			List<SboardVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
			for (SboardVO x : list) {
				System.out.println(x);
			}
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("sboard/selectAll.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/sb_update.do")) {
	         System.out.println("sboard/update.jsp");

	         System.out.println("num:" + request.getParameter("num"));

	         SboardVO vo = new SboardVO();
	         vo.setNum(Integer.parseInt(request.getParameter("num")));
	         SboardDAO dao = new SboardDAOimpl();

	         SboardVO vo2 = dao.selectOne(vo);
	         System.out.println(vo2);

	         request.setAttribute("vo2", vo2);

	         RequestDispatcher rd = request.getRequestDispatcher("sboard/update.jsp");
	         rd.forward(request, response);
	      }else if (sPath.equals("/sb_updateOK.do")) {
	         System.out.println(request.getParameter("num"));
	         System.out.println(request.getParameter("title"));
	         System.out.println(request.getParameter("content"));
	         System.out.println(request.getParameter("writer"));

	         SboardVO vo = new SboardVO();
	         vo.setNum(Integer.parseInt(request.getParameter("num")));
	         vo.setTitle(request.getParameter("title"));
	         vo.setContent(request.getParameter("content"));
	         vo.setWriter(request.getParameter("writer"));

	         SboardDAO dao = new SboardDAOimpl();
	         int result = dao.update(vo);
	         System.out.println("update result:" + result);

	         if (result == 1)
	            response.sendRedirect("sb_selectAll.do");
	         else
	            response.sendRedirect("sb_selectOne.do?num="+request.getParameter("num"));

	      
		}else if(sPath.equals("/sb_deleteOK.do")) {
			System.out.println("num:"+request.getParameter("num"));
			
			SboardVO vo = new SboardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			SboardDAO dao = new SboardDAOimpl();
			int result = dao.delete(vo);
			System.out.println("delete result:"+result);
					
			if(result>0) {
				System.out.println("delete successed..");
				response.sendRedirect("sb_selectAll.do");
			}else {
				System.out.println("delete failed..");
				response.sendRedirect("sb_selectAll.do");
			}
		} 
		
		//  sPath:  /selectOne.do >> selectOne() >> override >>web/selectOne.jsp
		//  sPath:  /selectAll.do >> selectAll() >> override >>web/selectAll.jsp
		//  sPath:  /update.do >> web/update.jsp
		//  sPath:  /updateOK.do >> update() >> override 
		//  sPath:  /deleteOK.do >> delete() >> override 
		//  sPath:  /searchList.do >> searchList() >> override  >>web/selectAll.jsp
	
	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
