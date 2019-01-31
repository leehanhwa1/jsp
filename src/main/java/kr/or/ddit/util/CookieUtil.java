package kr.or.ddit.util;

public class CookieUtil {
	private String cookieString;

	public CookieUtil(String cookieString) {
		this.cookieString = cookieString;
	}

	/**
	 * Method : getCookieValue
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param string
	 * @return
	 * Method 설명 : 쿠키이름에 해당하는 쿠키 값을 조회
	 */
	public String getCookieValue(String cookieName) {
		String[] cookieArray = cookieString.split("; ");
		String cookieValue = "";
		
		for(String cookie : cookieArray){
			if(cookieName.equals(cookie.split("=")[0])){
				cookieValue = cookie.split("=")[1];
				break;
			}
		}
		return cookieValue;
	}

}





