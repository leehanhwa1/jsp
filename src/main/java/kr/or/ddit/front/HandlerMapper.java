package kr.or.ddit.front;

import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.ForNode;

/**
* HandleMapper.java
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
* 	uri 정보를 바탕으로 해당 요청을 처리해 줄 컨트롤러를 생성, 반환 해주는 객체
* </pre>
*/
public class HandlerMapper {
	
	// Map<url 문자열, url 요청을 처리할 컨트롤러 클래스명
	private Map<String, String> urlControllerMap;
	
	public HandlerMapper() {
		// db, properties에서 데이터를 조회해야하나 테스트 목적으로 직접 넣어준다.
		urlControllerMap = new HashMap<String, String>();
		
		urlControllerMap.put("/userList.do", "kr.or.ddit.front.UserListController");
		urlControllerMap.put("/rangersList.do", "kr.or.ddit.front.RangersListController");
	}
	
	/**
	* Method : getController
	* 작성자 : PC09
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : uri 요청을 처리해 줄 pojo controller 리턴
	*/
	public CommonController getController(String uri) {
		
		String classInfo = urlControllerMap.get(uri);
		
		// 인스턴스를 생성하는 방법
		// 1. Integer i = new Integer(); -> 객체를 생성하기 위해서 new 연산자를 사용
		// 	  String msg = "msg"; -> 예외적인 케이스
		// -------------------------
		// 2. class 정보를 이용하여 객체를 생성 : 문자열 -> 클래스를 생성
		// that(변수) = this;
		
		CommonController controller = null;
		
		try {
			Class clazz = Class.forName(classInfo);
			
			//------------->>>>>
			/*if(uri.equals("/userList.do")) {
				
				UserListController controller = (UserListController) clazz.newInstance(); // -> 객체 생성
			} else {
				RangersListController controller = (RangersListController) clazz.newInstance();
			}*/
			
			controller = (CommonController)clazz.newInstance();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (InstantiationException e) {
			
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
			
		}
		
		return controller;
	}
	
	

}