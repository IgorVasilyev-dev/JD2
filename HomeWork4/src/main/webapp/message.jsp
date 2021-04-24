<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        label {
            display: inline-block;
        }
    </style>
    <title>Чат</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;"> ${requestScope.message} </p>
    </c:when>
    <c:when test="${requestScope.success}">
        <p style="color:blue;">Сообщение успешно отправлено</p>
    </c:when>
    <c:otherwise>
        <h3>Страница отправки сообщений</h3>
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
                <td> Сообщение: <label > <input type="text" name="msg"> </label> </td>
                <td> <input type="submit" value="Отправить"> </td>
            </tr>
        </table>
    </div>
</form>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/index.jsp';" value="HomePage" /></p>
</body>
</html>
