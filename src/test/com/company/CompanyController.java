package test.com.company;

import java.io.IOException;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


/**
 * Servlet implementation class MemberController
 */
@WebServlet({ "/c_start.do","/c_selectAll.do", "/c_insert.do", "/c_insertOK.do", 
	"/c_update.do", "/c_updateOK.do","/c_deleteOK.do", 
	"/c_selectOne.do", "/c_searchList.do", "/c_idCheck.do", 
	"/c_loginOK.do", "/c_logout.do","/c_mypage.do"})
public class CompanyController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private CompanyDAO dao = new CompanyDAOimpl();

   /**
    * @see HttpServlet#HttpServlet()
    */
   public CompanyController() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());

      String sPath = request.getServletPath();
      System.out.println("sPath:" + sPath);

      if (sPath.equals("/c_start.do")) {

          RequestDispatcher rd = request.getRequestDispatcher("company/start.jsp");
          rd.forward(request, response);

       } else if (sPath.equals("/c_insert.do")) {
         System.out.println("company/insert.jsp");
         RequestDispatcher rd = request.getRequestDispatcher("company/insert.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/c_insertOK.do")) {
    	  String uploadPath = request.getServletContext().getRealPath("upload");
  		System.out.println("uploadPath:" + uploadPath);
      	  
  		int size = 10 * 1024 * 1024;

  		try {
  			MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
  					new DefaultFileRenamePolicy());

  			Enumeration files = multi.getFileNames();

  			String pusa1 = (String) files.nextElement();
  			System.out.println("pusa1:"+pusa1);
  			String filename = multi.getFilesystemName(pusa1);
  			System.out.println("filename:"+filename);

         CompanyVO vo = new CompanyVO();
			vo.setId(multi.getParameter("id"));
			vo.setPw(multi.getParameter("pw"));
			vo.setName(multi.getParameter("name"));
			vo.setWork(multi.getParameter("work"));
			vo.setTel(multi.getParameter("tel"));
			vo.setLoca(multi.getParameter("loca"));
			vo.setSalary(multi.getParameter("salary"));
			vo.setDivi(multi.getParameter("divi"));
			vo.setFilename(filename);
			int result = dao.insert(vo);

			if (result == 1)
				response.sendRedirect("c_selectAll.do");
			else
				response.sendRedirect("c_insert.do");
		} catch (Exception e) {
			e.printStackTrace();
		}
      } else if (sPath.equals("/c_selectAll.do")) {
         System.out.println("company/selectAll.jsp");
         
         String loginSession = (String)request.getSession().getAttribute("login");

         System.out.println(loginSession);
         if(loginSession==null || loginSession.equals("failed")) {
            response.sendRedirect("index.do");
         }else {
            List<CompanyVO> list = dao.selectAll();
            for (CompanyVO x : list) {
               System.out.println(x);
            }

            request.setAttribute("list", list);

            RequestDispatcher rd = request.getRequestDispatcher("company/selectAll.jsp");
            rd.forward(request, response);
         }
         

         
      } else if (sPath.equals("/c_searchList.do")) {
         System.out.println("company/selectAll.jsp");
         System.out.println("searchKey:" + request.getParameter("searchKey"));
         System.out.println("searchWord:" + request.getParameter("searchWord"));

         List<CompanyVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
         for (CompanyVO x : list) {
            System.out.println(x);
         }

         request.setAttribute("list", list);

         RequestDispatcher rd = request.getRequestDispatcher("company/selectAll.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/c_selectOne.do")) {
         System.out.println("company/selectOne.jsp");
         System.out.println("num:" + request.getParameter("num"));

         CompanyVO vo = new CompanyVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));

         CompanyVO vo2 = dao.selectOne(vo);
         System.out.println("dddddddd"+vo2);

         request.setAttribute("vo2", vo2);

         RequestDispatcher rd = request.getRequestDispatcher("company/selectOne.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/c_update.do")) {
         System.out.println("company/update.jsp");

         System.out.println("num:" + request.getParameter("num"));

         CompanyVO vo = new CompanyVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));

         CompanyVO vo2 = dao.selectOne(vo);
         System.out.println(vo2);

         request.setAttribute("vo2", vo2);

         RequestDispatcher rd = request.getRequestDispatcher("company/update.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/c_updateOK.do")) {
         System.out.println(request.getParameter("num"));
         System.out.println(request.getParameter("id"));
         System.out.println(request.getParameter("pw"));
         System.out.println(request.getParameter("name"));
         System.out.println(request.getParameter("work"));
         System.out.println(request.getParameter("tel"));
         System.out.println(request.getParameter("loca"));
         System.out.println(request.getParameter("salary"));
         System.out.println(request.getParameter("divi"));
         System.out.println(request.getParameter("filename"));

         CompanyVO vo = new CompanyVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));
         vo.setId(request.getParameter("id"));
         vo.setPw(request.getParameter("pw"));
         vo.setName(request.getParameter("name"));
         vo.setWork(request.getParameter("work"));
         vo.setTel(request.getParameter("tel"));
         vo.setLoca(request.getParameter("loca"));
         vo.setSalary(request.getParameter("salary"));
         vo.setDivi(request.getParameter("Divi"));
         vo.setFilename(request.getParameter("filename"));

         int result = dao.update(vo);
         System.out.println("update result:" + result);

         if (result == 1)
            response.sendRedirect("c_selectAll.do");
         else
            response.sendRedirect("c_selectOne.do?num=" + request.getParameter("num"));

      } else if (sPath.equals("/c_deleteOK.do")) {
         System.out.println(request.getParameter("num"));

         CompanyVO vo = new CompanyVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));

         int result = dao.delete(vo);
         System.out.println("delete result:" + result);

         if (result == 1)
            response.sendRedirect("c_selectAll.do");
         else
            response.sendRedirect("c_selectOne.do?num=" + request.getParameter("num"));

      } else if (sPath.equals("/c_idCheck.do")) {
         System.out.println(request.getParameter("id"));

         CompanyVO vo = new CompanyVO();
         vo.setId(request.getParameter("id"));

         String result = dao.idCheck(vo);

         response.sendRedirect("c_insert.do?id=" + vo.getId() + "&msg=" + result);

      } else if (sPath.equals("/c_loginOK.do")) {
    	  
         System.out.println(request.getParameter("id"));
         System.out.println(request.getParameter("pw"));

         CompanyVO vo = new CompanyVO();
         vo.setId(request.getParameter("id"));
         vo.setPw(request.getParameter("pw"));

         CompanyVO vo2 = dao.loginOK(vo);
         System.out.println(vo2);
         
         if(vo2 != null) {
            request.getSession().setAttribute("login", "successed");
            request.getSession().setAttribute("filename", vo2.getFilename());
            request.getSession().setAttribute("userID", vo.getId());
            request.getSession().setAttribute("userDIVI", vo2.getDivi());
            request.getSession().setMaxInactiveInterval(300); //5분
         }

         response.sendRedirect("c_start.do");

      } else if (sPath.equals("/c_logout.do")) {

    	  request.getSession().invalidate();
    	  response.sendRedirect("c_start.do");

      }else if(sPath.equals("/c_mypage.do")) {
      	   System.out.println(request.getSession().getAttribute("userID"));
       	   CompanyVO vo = new CompanyVO();
       	   vo.setId((String)request.getSession().getAttribute("userID"));
       	   
       	   
       	   CompanyVO vo2 = dao.selectOne(vo);
       	   System.out.println(vo2);
       	   request.setAttribute("vo2", vo2);

              RequestDispatcher rd = request.getRequestDispatcher("company/selectOne.jsp");
              rd.forward(request, response);
          }

   }// end doGet()

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      doGet(request, response);
   }

}