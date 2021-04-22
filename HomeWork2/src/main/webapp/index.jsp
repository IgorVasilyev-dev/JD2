<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HomePage</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signUp';" value="Зарегистрироваться" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signIn';" value="Войти" /></p>
    </c:when>
    <c:otherwise>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/message';" value="Оправить сообщение" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/chat';" value="Просмотреть сообщения" /></p>
    </c:otherwise>
</c:choose>
</body>
</html>