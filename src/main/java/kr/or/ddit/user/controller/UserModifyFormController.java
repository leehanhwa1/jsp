package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

@WebServlet("/userModifyForm")
@MultipartConfig(maxFileSize=5*1024*1024 , maxRequestSize=5*5*1024*1024)
public class UserModifyFormController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private IUserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl(); 
	}

	/**
	* Method : doGet
	* 작성자 : PC09
	* 변경이력 :
	* @param req
	* @param resp
	* @throws ServletException
	* @throws IOException
	* Method 설명 :
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		//userId parameter 확인
		String userId = req.getParameter("userId");
		
		//해당 파라미터로 userService.selectUser(userId);
		UserVo userVo = userService.selectUser(userId);
		
		//조회된 user객체를 request객체에 속성으로 저장
		req.setAttribute("userVo", userVo);
		
		//사용자 상세 화면을 담당하는 view로 forward
		req.getRequestDispatcher("/user/userModify.jsp").forward(req, resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userId = req.getParameter("userId");
		String userNm = req.getParameter("userNm");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		String pass = req.getParameter("pass");
		String alias = req.getParameter("alias");
		UserVo uservo = new UserVo(userId, userNm, alias, addr1, addr2, zipcode, pass);
		
		// 사용자 사진
        Part profilepart = req.getPart("profile");
        
        
        // 사용자가 사진을 올린 경우
        String filename 	 = "";
   	 	String realFilename  = "";
   	 	
   	 if(profilepart.getSize() > 0) {
    	 // 사용자 테이블의 파일명을 저장(실제 업로드한 파일명 - filename, 파일 충돌을 방지하기 위해 사용한 uuid값 - realfilename)
    	 String contentDisposition = profilepart.getHeader("Content-Disposition");
    	 
    	 filename 	  = PartUtil.getFileNameFromPart(contentDisposition);
    	 realFilename = "d:\\picture\\" + UUID.randomUUID().toString();
    	 
    	 // 디스크에 기록 (d:\picture\ + realFilename)
    	 profilepart.write(realFilename);
    	 
    	 
    	 
     } else {
    	 UserVo temp = userService.selectUser(userId);
    	 
    	 temp.getFilename();
    	 temp.getRealfilename();
     }
    	 
    	 // 사용자가 사진을 추가하지 않은 경우
    	 uservo.setFilename(filename);
    	 uservo.setRealfilename(realFilename);
   	 
		
     
		
		int cnt = userService.updateUser(uservo);
		
		if(cnt == 1) {
			resp.sendRedirect("/user?userId=" + userId);
		} else {
			doGet(req, resp);
		}
		
		
	}
	
}