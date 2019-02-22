package kr.or.ddit.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonController {
	
	/**
	* Method : process
	* 작성자 : PC09
	* 변경이력 :
	* @param req
	* @param resp
	* @return view 정보
	* Method 설명 : 컨트롤러 실행
	*/
	public String process(HttpServletRequest req, HttpServletResponse resp);

}
