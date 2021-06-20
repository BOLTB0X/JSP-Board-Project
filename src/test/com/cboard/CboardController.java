package test.com.cboard;

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
@WebServlet({"/cb_selectAll.do", "/cb_insert.do", 
	"/cb_insertOK.do", "/cb_update.do", "/cb_updateOK.do",
    "/cb_deleteOK.do", "/cb_selectOne.do", "/cb_searchList.do", 
    "/cb_idCheck.do", "/cb_loginOK.do", "/cb_logout.do","/cb_likeupOK.do"})
public class CboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CboardController() {
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
	
		if(sPath.equals("/cb_insertOK.do")) {
			
			System.out.println(request.getParameter("title"));
			System.out.println(request.getParameter("content"));
			System.out.println(request.getParameter("writer"));
			
			CboardVO vo = new CboardVO();
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			vo.setWriter(request.getParameter("writer"));

			CboardDAO dao = new CboardDAOimpl();
			int result = dao.insert(vo);
			System.out.println("insert result:"+result);
			
			if(result==1)response.sendRedirect("cb_selectAll.do");
			else response.sendRedirect("cb_insert.do");
			
		}else if(sPath.equals("/cb_insert.do")) {
			System.out.println("cboard/insert.jsp");
			RequestDispatcher rd = 
					request.getRequestDispatcher("cboard/insert.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/cb_selectOne.do")) {
			System.out.println("cboard/selectOne.jsp");
			System.out.println("num:"+request.getParameter("num"));
			
			CboardVO vo = new CboardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			CboardDAO dao = new CboardDAOimpl();
			CboardVO vo2 = dao.selectOne(vo);
			System.out.println(vo2);
			
			request.setAttribute("vo2", vo2);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("cboard/selectOne.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/cb_selectAll.do")) {
			System.out.println("cboard/selectAll.jsp");
			
			CboardDAO dao = new CboardDAOimpl();
			List<CboardVO> list = dao.selectAll();
			
			for (CboardVO x : list) {
				System.out.println(x);
			}
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("cboard/selectAll.jsp");
			rd.forward(request, response);
		}else if(sPath.equals("/cb_searchList.do")) {
			System.out.println("cboard/selectAll.jsp");
			System.out.println("searchWord:" + request.getParameter("searchKey"));			
			System.out.println("searchWord:" + request.getParameter("searchWord"));			
			
			CboardDAO dao = new CboardDAOimpl();
			
			List<CboardVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
			for (CboardVO x : list) {
				System.out.println(x);
			}
			
			request.setAttribute("list", list);
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("cboard/selectAll.jsp");
			rd.forward(request, response);
		}else if (sPath.equals("/cb_update.do")) {
	         System.out.println("cboard/update.jsp");

	         System.out.println("num:" + request.getParameter("num"));

	         CboardVO vo = new CboardVO();
	         vo.setNum(Integer.parseInt(request.getParameter("num")));
	         CboardDAO dao = new CboardDAOimpl();

	         CboardVO vo2 = dao.selectOne(vo);
	         System.out.println(vo2);

	         request.setAttribute("vo2", vo2);

	         RequestDispatcher rd = request.getRequestDispatcher("cboard/update.jsp");
	         rd.forward(request, response);
	      }else if (sPath.equals("/cb_updateOK.do")) {
	         System.out.println(request.getParameter("num"));
	         System.out.println(request.getParameter("title"));
	         System.out.println(request.getParameter("content"));
	         System.out.println(request.getParameter("writer"));

	         CboardVO vo = new CboardVO();
	         vo.setNum(Integer.parseInt(request.getParameter("num")));
	         vo.setTitle(request.getParameter("title"));
	         vo.setContent(request.getParameter("content"));
	         vo.setWriter(request.getParameter("writer"));

	         CboardDAO dao = new CboardDAOimpl();
	         int result = dao.update(vo);
	         System.out.println("update result:" + result);

	         if (result == 1)
	            response.sendRedirect("cb_selectAll.do");
	         else
	            response.sendRedirect("cb_selectOne.do?num="+request.getParameter("num"));

	      
		}else if(sPath.equals("/cb_deleteOK.do")) {
			System.out.println("num:"+request.getParameter("num"));
			
			CboardVO vo = new CboardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			CboardDAO dao = new CboardDAOimpl();
			int result = dao.delete(vo);
			System.out.println("delete result:"+result);
					
			if(result>0) {
				System.out.println("delete successed..");
				response.sendRedirect("cb_selectAll.do");
			}else {
				System.out.println("delete failed..");
				response.sendRedirect("cb_selectAll.do");
			}
		}else if (sPath.equals("/cb_likeupOK.do")){
			System.out.println("num:"+request.getParameter("num"));
			
			CboardVO vo = new CboardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			
			CboardDAO dao = new CboardDAOimpl();
			int result = dao.likeup(vo);
			System.out.println("likeupOK result:"+result);
			if(result==1) {
				System.out.println("likeupOK successed..");
				response.sendRedirect("cb_selectAll.do");
			}else {
				System.out.println("likeupOK failed..");
				response.sendRedirect("cb_selectAll.do");
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
