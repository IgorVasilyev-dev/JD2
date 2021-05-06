<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список Аэропортов</title>
    <style>
        table {
            width: 100%; /* Ширина таблицы */
            border: 4px double black; /* Рамка вокруг таблицы */
            border-collapse: collapse; /* Отображать только одинарные линии */
        }
        th {
            text-align: left; /* Выравнивание по левому краю */
            background: #ccc; /* Цвет фона ячеек */
            padding: 5px; /* Поля вокруг содержимого ячеек */
            border: 1px solid black; /* Граница вокруг ячеек */
        }
        td {
            padding: 5px; /* Поля вокруг содержимого ячеек */
            border: 1px solid black; /* Граница вокруг ячеек */
        }
    </style>
</head>

<body>
<table>
    <thead>
    <h1>Page No: ${requestScope.page} </h1>
    <tr>
        <th>Код Аэропорта</th>
        <th>Аэропорт</th>
        <th>Город</th>
        <th>Координаты</th>
        <th>Часовой пояс</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="list" items="${requestScope.airList}" >
        <tr>
            <td> ${list.airport_code}</td>
            <td> ${list.airport_name}</td>
            <td> ${list.city}</td>
            <td> ${list.coordinates}</td>
            <td> ${list.timezone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<c:forEach begin="1" end="${sessionScope.pageN}" var="i">
    <c:choose>
        <c:when test="${requestScope.page eq i}">
            ${i}
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/airports?page=${i}">${i}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>

</body>

</html>