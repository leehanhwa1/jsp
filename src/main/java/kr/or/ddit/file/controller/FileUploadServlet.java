package kr.or.ddit.file.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId 	  = request.getParameter("userId");
		String uploadFile = request.getParameter("uploadFile");
		
		/*System.out.println("userId : " + userId);
		System.out.println("uploadFile : " + uploadFile);*/
		
		// low level		--> 	high lever
		// trace < debug < info < warn < error
		// 하위 레벨은 상위 레벨을 포함하는 개념
		// ex) 로깅 레벨이 info : logger.info(...), logger.warn(...), logger.error(...)   --> info부터 상위 레벨이 나타남.
		// ex) 로깅 레벨이 error : logger.error(...)
		logger.debug("userId : " + userId);
		logger.debug("uploadFile : " + uploadFile);
		
		doGet(request, response);
	}

}