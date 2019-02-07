<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>coreUrl</title>
</head>
<body>

<%-- https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=html
<c:import url="https://search.naver.com/search.naver">
	<c:param name="query" value="html"></c:param>
</c:import> --%>

<c:import url="/userPagingList">
	<c:param name="page" value="5" />
</c:import>

</body>
</html>