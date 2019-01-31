<%@page import="kr.or.ddit.rangers.model.RangerVo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jstl을 사용하기 위한 준비 : jsp 디렉티브(taglib)를 이용하여 사용하고자 하는 라이브러리 선언
						   prefix = "임의로 작성 가능하나 일반적으로 사용하는 이름 권장 ex) core : c , format : fmt , function : fn" / uri = "자동완성기능"
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- url : localhost/jstl/core.jsp --%>
<h2>core : set</h2>
<%-- 특정 scope(page, request, session, application)에 속성을 생성
	 기본 scope : page
 --%>
 
 <%-- pagecontext.setAttribute("userId", "brown"); 
 	  session.setAttribute("userId", "brown");
 --%>
 
 <%
 	RangerVo rangerVo = new RangerVo("brown", "브라운", 8);
 	session.setAttribute("ranger", rangerVo);
 %>
<c:set var="userId" value="brown" scope="session"/>

userId(표현식) : <%=pageContext.getAttribute("userId") %> <br>
userId(표현식-session) : <%=session.getAttribute("userId") %> <br>
userId(el) : ${userId } <br>
----------------------------<br>

<c:set target="${ranger }" property="age" value="10" />
ranger - 나이 변경 : ${ranger } <br>

</body>
</html>