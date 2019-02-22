package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.front.CommonController;
import kr.or.ddit.front.HandlerInvoker;
import kr.or.ddit.front.HandlerMapper;
import kr.or.ddit.front.ViewResolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	private Logger logger = LoggerFactory
			.getLogger(FrontController.class);
	
	private HandlerMapper handleMapper;
	private HandlerInvoker handlerInvoker; // 특정 컨트롤러를 실행하는 역할
	private ViewResolver viewResolver; 
	
	
	@Override
	public void init() throws ServletException {
		handleMapper = new HandlerMapper();
		handlerInvoker = new HandlerInvoker();
		viewResolver = new ViewResolver();
		
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("frontcontroller doGet {}", req.getRequestURI());
		
		// uri 요청을 처리해 줄 컨트롤러 확인
		CommonController controller = handleMapper.getController(req.getRequestURI());
		
		// 컨트롤러 실행
		String viewInfo = handlerInvoker.invoke(req, resp, controller);
		
		// viewResolver를 통한 응답생성
		viewResolver.viewResolve(req, resp, viewInfo);
	}

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}