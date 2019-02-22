<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
selectLangWS.jsp

<%--
	select 변경 (ko -> ja) --> 서버요청(selectLang.jsp) -->
	1. select로 변경한 로케일이 설정된 selectLang.jsp가 화면에 출력되도록
	2. select box option 태그가 요청한 로케일로 선택이 되도록 설정
	3. 만약 로케일 파라미터가 없을 경우 기본값은 ko
--%>



<form id="frm" action="${cp }/selectLang">
<select id="langSelect" name="lang">
	<%-- <option value="ko" <c:if test="${lang == 'ko' }">selected</c:if> >한국어</option> --%>
	<option value="ko" >한국어</option>
	<option value="ja" >日本言</option>
	<option value="en" >english</option>
</select> <br>
<!-- <input type="submit" value="전송"> -->
</form>

<fmt:setLocale value="${lang }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="hello" />
	<fmt:message key="visitor" >
		<fmt:param value="brown" />
	</fmt:message>
</fmt:bundle>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
		// select box selected 적용
		$("#langSelect > option").attr("selected", false);
		$("#langSelect > option[value=${lang }]").attr("selected", true);
		
		$("#langSelect").on("change", function() {
			$("#frm").submit();
		});
	});
</script>

</body>
</html>