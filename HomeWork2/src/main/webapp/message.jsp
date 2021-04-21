<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Отправте сообщение</title>
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
<form method="POST" action="${pageContext.request.contextPath}/message">
    <div style="text-align: left;">
        <table>
            <tr>
                <td> <label> Кому:
                    <select name="recipient">
                        <option> Всем </option>
                        <c:forEach var="list" items="${requestScope.allUsers}">
                            <option> ${list}</option>
                        </c:forEach>
                    </select>
                </label></td>
                <td> Сообщение: <label> <input type="text" name="msg"> </label> </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Отправить сообщение">
    </div>
</form>
</body>
</html>
