<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="color" type="java.lang.String" required="false" %>
<%@ attribute name="size" type="java.lang.Integer" %>
<!-- 사이즈만큼 =을 출력한다. -->

${color }

<font color="${color }">

<c:forEach begin="1" end="${size }">=</c:forEach><br>

</font>