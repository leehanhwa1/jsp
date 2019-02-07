<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- localhost/customTag/logging.jsp -->

<h2>loggings.tag</h2>
loggin.jsp 출력<br>
<tags:loggins></tags:loggins>

loggin.jsp 출력<br>
<tags:loggins />

<h2>colorLoggins.tag</h2>
<tags:colorLogging color="blue" size="20" />
<tags:colorLogging color="yellow" size="50" />

</body>
</html>