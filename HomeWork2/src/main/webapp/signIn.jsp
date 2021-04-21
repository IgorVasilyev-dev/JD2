<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SingIn</title>
</head>
<body>
<c:choose>
<c:when test="${requestScope.error}">
    <p style="color:red;"> ${requestScope.message} </p>
</c:when>
<c:otherwise>
<h3>Страница авторизации</h3>
    </c:otherwise>
</c:choose>
    <form method="POST" action="${pageContext.request.contextPath}/signIn">
        <div style="text-align: left;">
            <table>
                <tr>
                    <td> Логин: </td>
                    <td> <label> <input type="text" name="login"> </label> </td>
                </tr>
                <tr>
                    <td> Пароль: </td>
                    <td> <label> <input type="password" name="pass"> </label> </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Войти">
        </div>
    </form>
</body>
</html>
