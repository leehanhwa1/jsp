package kr.or.ddit.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* handlerInvoker.java
*
* @author PC09
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC09 최초 생성
* controller를 실행, 실행 결과로 리턴된 view 정보를 리턴
* </pre>
*/
public class HandlerInvoker {

	public String invoke(HttpServletRequest req, HttpServletResponse resp, CommonController controller) {
		
		String viewInfo = controller.process(req, resp);
		
		return viewInfo;
	}
	
}