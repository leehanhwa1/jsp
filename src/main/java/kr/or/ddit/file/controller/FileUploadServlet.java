package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 5MB = 5 * 1024 * 1024
// 5MB = 5 * 1MB
// 1MB = 1024KB
// 1KB = 1024BYTE
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=5 * 1024 * 1024, maxRequestSize=5 * 5 * 1024 * 1024)
public class FileUploadServlet extends HttpServlet {
	private static final String UPLOAD_PATH = "d:\\picture\\";
	//오른쪽버튼 - refactor - Extrant contrant(?) : 상수

	private static final long serialVersionUID = 1L;
       
    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String contentType = request.getContentType();
		String userId 	   = request.getParameter("userId");
		String uploadFile  = request.getParameter("uploadFile");
		
		/*System.out.println("userId : " + userId);
		System.out.println("uploadFile : " + uploadFile);*/
		
		// low level		--> 	high lever
		// trace < debug < info < warn < error
		// 하위 레벨은 상위 레벨을 포함하는 개념
		// ex) 로깅 레벨이 info : logger.info(...), logger.warn(...), logger.error(...)   --> info부터 상위 레벨이 나타남.
		// ex) 로깅 레벨이 error : logger.error(...)
		logger.debug("contentType : " + contentType);
		logger.debug("userId : " + userId);
		logger.debug("uploadFile : " + uploadFile);
		
		Collection<Part> parts = request.getParts();
		
		// part 정보 확인
		//request.gePart(name);
		//request.getParts();
//		for(Part part : parts) {
//			logger.debug("PartName : {}" , part.getName());
//			logger.debug("Content-Disposition : {}" , part.getHeader("Content-Disposition"));
//		}
		
		Part uploadFilePart = request.getPart("uploadFile");
		String contentdisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentdisposition : {}" , contentdisposition);
		
		// application
		// localhost/upload --> 물리적 경로를 확인
		ServletContext application = getServletContext();
		String path = application.getRealPath("/upload");
		logger.debug("path : {}" , path);
		
		if(uploadFilePart.getSize() > 0) {
		// 첨부파일 파일명
		String filename = PartUtil.getFileNameFromPart(contentdisposition);
		String uuidFilename = UUID.randomUUID().toString();
		//uploadFilePart.write(UPLOAD_PATH + uuidFilename);
		
		
		uploadFilePart.write(path + File.separator + uuidFilename);
		uploadFilePart.delete();
		
		}
		
		doGet(request, response);
	}

}