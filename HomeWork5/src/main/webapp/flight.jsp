<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="ru">
<head>
    <title>Flight Selection</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $( function() {
                $( "#datepicker1" ).datepicker();
                $( "#datepicker2" ).datepicker();
            } );
        </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/flight" method="POST">
<td>Дата отправления: <label for="datepicker1"></label><input type="text" id="datepicker1" name="departureDate"></td>
<label>Аэропорт отправления
    <select name="departureAirport">
        <c:forEach var="list" items="${sessionScope.airList}">
            <option> ${list.airport_name}</option>
        </c:forEach>
    </select>
</label>
<td>Дата прибытия: <label for="datepicker2"></label><input type="text" id="datepicker2" name="arrivalDate"></td>
<label>Аэропорт прибытия
    <select name="arrivalAirport">
        <c:forEach var="list" items="${sessionScope.airList}">
            <option> ${list.airport_name}</option>
        </c:forEach>
    </select>
</label>
    <p><input type="submit" value="Search"/></p>
</form>
</body>
</html>
