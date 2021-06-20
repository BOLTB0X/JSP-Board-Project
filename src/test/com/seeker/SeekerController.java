package test.com.seeker;

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
@WebServlet({"/start.do","/index.do", "/s_selectAll.do", "/s_insert.do", 
	"/s_insertOK.do", "/s_update.do", "/s_updateOK.do",
      "/s_deleteOK.do", "/s_selectOne.do", "/s_searchList.do", 
      "/s_idCheck.do", "/s_loginOK.do", "/s_logout.do",
      "/s_upload.do","/s_mypage.do"
      })

public class SeekerController extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private SeekerDAO dao = new SeekerDAOimpl();

   /**
    * @see HttpServlet#HttpServlet()
    */
   public SeekerController() {
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

      if (sPath.equals("/start.do")) {

          RequestDispatcher rd = request.getRequestDispatcher("seeker/start.jsp");
          rd.forward(request, response);

       } else if (sPath.equals("/index.do")) {
         System.out.println("index.jsp");

         RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
         rd.forward(request, response);

      } else if (sPath.equals("/s_insert.do")) {
         System.out.println("seeker/insert.jsp");
         RequestDispatcher rd = request.getRequestDispatcher("seeker/insert.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/s_insertOK.do")) {
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
			
			SeekerVO vo = new SeekerVO();
			vo.setId(multi.getParameter("id"));
			vo.setPw(multi.getParameter("pw"));
			vo.setName(multi.getParameter("name"));
			vo.setGen(multi.getParameter("gen"));
			vo.setLang(multi.getParameter("lang"));
			vo.setHome(multi.getParameter("home"));
			vo.setCareer(multi.getParameter("career"));
			vo.setDivi(multi.getParameter("divi"));
			vo.setFilename(filename);
			int result = dao.insert(vo);
			if (result == 1)
				response.sendRedirect("s_selectAll.do");
			else
				response.sendRedirect("s_insert.do");
				
		} catch (Exception e) {
			e.printStackTrace();
		}


      } else if (sPath.equals("/s_selectAll.do")) {
         System.out.println("seeker/selectAll.jsp");
         
         String loginSession = (String)request.getSession().getAttribute("login");

         System.out.println(loginSession);
         if(loginSession==null || loginSession.equals("failed")) {
            response.sendRedirect("index.do");
         }else {
            List<SeekerVO> list = dao.selectAll();
            for (SeekerVO x : list) {
               System.out.println(x);
            }

            request.setAttribute("list", list);

            RequestDispatcher rd = request.getRequestDispatcher("seeker/selectAll.jsp");
            rd.forward(request, response);
         }
         
      } else if (sPath.equals("/s_searchList.do")) {
         System.out.println("seeker/selectAll.jsp");
         System.out.println("searchKey:" + request.getParameter("searchKey"));
         System.out.println("searchWord:" + request.getParameter("searchWord"));

         List<SeekerVO> list = dao.searchList(request.getParameter("searchKey"), request.getParameter("searchWord"));
         for (SeekerVO x : list) {
            System.out.println(x);
         }

         request.setAttribute("list", list);

         RequestDispatcher rd = request.getRequestDispatcher("seeker/selectAll.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/s_selectOne.do")) {
         System.out.println("seeker/selectOne.jsp");
         System.out.println("num:" + request.getParameter("num"));

         SeekerVO vo = new SeekerVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));

         SeekerVO vo2 = dao.selectOne(vo);
         System.out.println(vo2);

         request.setAttribute("vo2", vo2);

         RequestDispatcher rd = request.getRequestDispatcher("seeker/selectOne.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/s_update.do")) {
         System.out.println("seeker/update.jsp");

         System.out.println("num:" + request.getParameter("num"));

         SeekerVO vo = new SeekerVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));

         SeekerVO vo2 = dao.selectOne(vo);
         System.out.println(vo2);

         request.setAttribute("vo2", vo2);

         RequestDispatcher rd = request.getRequestDispatcher("seeker/update.jsp");
         rd.forward(request, response);
      } else if (sPath.equals("/s_updateOK.do")) {
         System.out.println(request.getParameter("num"));
         System.out.println(request.getParameter("id"));
         System.out.println(request.getParameter("pw"));
         System.out.println(request.getParameter("name"));
         System.out.println(request.getParameter("gen"));
         System.out.println(request.getParameter("lang"));
         System.out.println(request.getParameter("home"));
         System.out.println(request.getParameter("career"));         
         System.out.println(request.getParameter("divi"));         

         SeekerVO vo = new SeekerVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));
         vo.setId(request.getParameter("id"));
         vo.setPw(request.getParameter("pw"));
         vo.setName(request.getParameter("name"));
         vo.setGen(request.getParameter("gen"));
         vo.setLang(request.getParameter("lang"));
         vo.setHome(request.getParameter("home"));
         vo.setCareer(request.getParameter("career"));
         vo.setDivi(request.getParameter("divi"));

         int result = dao.update(vo);
         System.out.println("update result:" + result);

         if (result == 1)
            response.sendRedirect("s_selectAll.do");
         else
            response.sendRedirect("s_selectOne.do?num=" + request.getParameter("num"));

      } else if (sPath.equals("/s_deleteOK.do")) {
         System.out.println(request.getParameter("num"));

         SeekerVO vo = new SeekerVO();
         vo.setNum(Integer.parseInt(request.getParameter("num")));

         int result = dao.delete(vo);
         System.out.println("delete result:" + result);

         if (result == 1)
            response.sendRedirect("s_selectAll.do");
         else
            response.sendRedirect("s_selectOne.do?num=" + request.getParameter("num"));

      } else if (sPath.equals("/s_idCheck.do")) {
         System.out.println(request.getParameter("id"));

         SeekerVO vo = new SeekerVO();
         vo.setId(request.getParameter("id"));

         String result = dao.idCheck(vo);

         response.sendRedirect("s_insert.do?id=" + vo.getId() + "&msg=" + result);

      } else if (sPath.equals("/s_loginOK.do")) {
         System.out.println(request.getParameter("id"));
         System.out.println(request.getParameter("pw"));

         SeekerVO vo = new SeekerVO();
         vo.setId(request.getParameter("id"));
         vo.setPw(request.getParameter("pw"));

         SeekerVO vo2 = dao.loginOK(vo);
         System.out.println(vo2);
         
         if(vo2 != null ) {
            request.getSession().setAttribute("login", "successed");
            request.getSession().setAttribute("filename", vo2.getFilename());
            request.getSession().setAttribute("userID", vo.getId());
            request.getSession().setAttribute("userDIVI", vo2.getDivi());
            
            request.getSession().setMaxInactiveInterval(300); //5분
         }

         response.sendRedirect("start.do");

      } else if (sPath.equals("/s_logout.do")) {

    	  request.getSession().invalidate();
    	  response.sendRedirect("start.do");

      } else if(sPath.equals("/s_mypage.do")) {
   	   System.out.println(request.getSession().getAttribute("userID"));
   	   SeekerVO vo = new SeekerVO();
   	   vo.setId((String)request.getSession().getAttribute("userID"));
   	   
   	   
   	   SeekerVO vo2 = dao.selectOne(vo);
   	   System.out.println(vo2);
   	   request.setAttribute("vo2", vo2);

          RequestDispatcher rd = request.getRequestDispatcher("seeker/selectOne.jsp");
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