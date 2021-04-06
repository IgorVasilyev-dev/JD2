<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signUp';" value="Зарегистрироваться" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signIn';" value="Войти" /></p>
    </c:when>
    <c:otherwise>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/chatServlet';" value="Просмотреть чат" /></p>
    </c:otherwise>
</c:choose>
</body>
</html>