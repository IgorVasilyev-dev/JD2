<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;">${requestScope.errorMessage}</p>
    </c:when>
    <c:otherwise>
        <p>Пройдите регистрацию</p>
    </c:otherwise>
</c:choose>

<form action="signUp" method="POST">
    Login: <input name="login"/>
    <br><br>
    Password: <input name="password"/>
    FIO: <input name="fio"/>
    <br><br>
    Birth Day: <input name="birthDay"/>
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>