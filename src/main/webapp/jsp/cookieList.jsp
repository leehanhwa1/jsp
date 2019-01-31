<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	Cookie[] cookies = request.getCookies();

	for(Cookie cookie : cookies) {
		out.write("cookieName : " + cookie.getName() + " / cookieValue = " + cookie.getValue() + "<br>");
	}
	
	// 1. ������������ �ּ��ٿ� : localhost/cookieList
	// 2. /cookieList url�� ó���ϴ� CookieServlet
	// 3. �� �������� �ּ��ٷ� ��û�� ���±� ������ get ��û�� �ǰ�
	// 4. cookieservlet�� doGet()�� ����
	// 5. request.getRequestDispather("/jsp/cookieList.jsp").forward(request, response);
%>

<h3>session</h3>
session.getId() : <%= session.getId() %>

<h3>���� ���̵� cookie ����</h3>
<%
	Cookie newCookie = new Cookie("serverSideCookie", "serversideValue");
	// setMaxAge�� �ʴ��� ���� ���ڷ� �޴´�.
	// ex) 5�� : 5*24(hour)*60(minute)*60(second)
	newCookie.setMaxAge(5*24*60*60);
	response.addCookie(newCookie);
%>

</body>
</html>