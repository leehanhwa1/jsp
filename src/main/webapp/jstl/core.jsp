<%@page import="kr.or.ddit.rangers.model.RangerVo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jstl�� ����ϱ� ���� �غ� : jsp ��Ƽ��(taglib)�� �̿��Ͽ� ����ϰ��� �ϴ� ���̺귯�� ����
						   prefix = "���Ƿ� �ۼ� �����ϳ� �Ϲ������� ����ϴ� �̸� ���� ex) core : c , format : fmt , function : fn" / uri = "�ڵ��ϼ����"
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
<%-- Ư�� scope(page, request, session, application)�� �Ӽ��� ����
	 �⺻ scope : page
 --%>
 
 <%-- pagecontext.setAttribute("userId", "brown"); 
 	  session.setAttribute("userId", "brown");
 --%>
 
 <%
 	RangerVo rangerVo = new RangerVo("brown", "����", 8);
 	session.setAttribute("ranger", rangerVo);
 %>
<c:set var="userId" value="brown" scope="session"/>

userId(ǥ����) : <%=pageContext.getAttribute("userId") %> <br>
userId(ǥ����-session) : <%=session.getAttribute("userId") %> <br>
userId(el) : ${userId } <br>
----------------------------<br>

<c:set target="${ranger }" property="age" value="10" />
ranger - ���� ���� : ${ranger } <br>

</body>
</html>