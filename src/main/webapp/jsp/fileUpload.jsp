<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${cp }/fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="userId" value="brown" /> <br>
		<input type="file" name="uploadFile" /> <br>
		<input type="submit" value="전송하기" /> <br>
	</form>
</body>
</html>