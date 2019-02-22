<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>현재 접속자 : ${currentLoginUserList.size() }</h3>
	<!-- currentLoginUserList -->
		<table>
			<tr>
				<th>사용자 아이디</th>
				<th>사용자 이름</th>
				<th>별명</th>
			</tr>
			
			<c:forEach items="${currentLoginUserList }" var="user">
				<tr>
					<td>${user.userId }</td>
					<td>${user.userNm }</td>
					<td>${user.alias }</td>
				</tr>
			</c:forEach>			
		</table>
</body>
</html>