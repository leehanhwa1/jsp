package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
   private IUserService userService;
   
   @Override
   public void init() throws ServletException {
      userService = new UserServiceImpl();
   }
   
   /**
    * Method : doGet
    * 작성자 : PC07
    * 변경이력 :
    * @param req
    * @param resp
    * @throws ServletException
    * @throws IOException
    * Method 설명 : 사용자 등록 폼
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/user/userForm.jsp").forward(req, resp);
   }

   /**
    * Method : doPost
    * 작성자 : PC07
    * 변경이력 :
    * @param req
    * @param resp
    * @throws ServletException
    * @throws IOException
    * Method 설명 : 사용자 정보 등록
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.setCharacterEncoding("utf-8");
      
      // 1. 사용자 아이디 중복 체크
      String userId = req.getParameter("userId");
      UserVo checkUserVo = userService.selectUser(userId);

      // 2-1. 중복 체크 통과 : 사용자 정보를 db에 입력
      if (checkUserVo == null) {
         String userNm = req.getParameter("userNm");
         String alias = req.getParameter("alias");
         String addr1 = req.getParameter("addr1");
         String addr2 = req.getParameter("addr2");
         String zipcode = req.getParameter("zipcode");
         String pass = req.getParameter("pass");
         
         
         UserVo userVo = new UserVo(userId, userNm, alias, addr1, addr2, zipcode, pass);
         int cnt = userService.insertUser(userVo);

         // 2-1-1. 사용자 페이징 리스트 1 페이지로 이동
         // 정상입력(성공)
         if (cnt == 1) {
            //req.getRequestDispatcher("/userPagingList").forward(req, resp);
        	 req.getSession().setAttribute("msg", "정상 들록되었습니다.");
        	 resp.sendRedirect("/userPagingList");
         }
         // 정사입력(실패)
         else {
        	 doGet(req, resp);
         }
      }
      // 2-2. 중복 체크 통과 실패 : 사용자 등록 페이지로 이동
      else {
         // forward 시에는 최초 요청한 method를 변경불가
         // post --> post
    	  //req.getRequsetDispatcher("/userForm").forward(req, resp);
    	  //req.getRequsetDispatcher("/user/userForm.jsp").forward(req, resp);
    	  req.setAttribute("msg", "중복 체크에 실패했습니다.");
         doGet(req, resp);
      }
   }
}