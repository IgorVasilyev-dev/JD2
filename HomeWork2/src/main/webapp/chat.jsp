<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
            td:nth-child(1){color: silver }
            td:nth-child(3){color: blue}
    </style>
    <title>Chat</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;"> ${requestScope.message} </p>
    </c:when>
    <c:otherwise>
        <h3>Страница чата</h3>
    </c:otherwise>
</c:choose>
<table>
    <c:forEach var="list" items="${requestScope.allMessage}" >
        <tr>
            <td>(${list.sendDate})</td>
            <td>Сообщение от: </td>
            <td>${list.sentFrom}</td>
            <td> --> ${list.sendText}</td>
        </tr>
    </c:forEach>
</table>
<p><input type="button" onclick="location.href='${pageContext.request.contextPath}/index.jsp';" value="HomePage" /></p>
</body>
</html>
