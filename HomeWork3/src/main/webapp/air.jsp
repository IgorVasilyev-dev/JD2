<%@ page import="java.util.*,by.it_academy.jd2.core.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>air</title>
    </head>
    <table>
    <table border='1' cellpadding='5' width='60%'>
    <thead>
    <h1>Page No: ${page} </h1>
      <tr>
        <th>Airport_code</th>
        <th>Airport_name</th>
        <th>City</th>
        <th>Coordinates</th>
        <th>Timezone</th>
      </tr>
    </thead>
                <tbody>
                <c:forEach var="list" items="${requestScope.airList}" >
                    <tr>
                        <td> ${list.getAirport_code()}</td>
                        <td> ${list.getAirport_name()}</td>
                        <td> ${list.getCity()}</td>
                        <td> ${list.getCoordinates()}</td>
                        <td> ${list.getTimezone()}</td>
                    </tr>
                </c:forEach>
                </tbody>
    </table>
        <table border="1" cellpadding="5" cellspacing="5">
                <tr>
                    <c:forEach begin="1" end="${pageN}" var="i">
                        <c:choose>
                            <c:when test="${page eq i}">
                                <td>${i}</td>
                            </c:when>
                            <c:otherwise>
                                <td><a href="${pageContext.request.contextPath}/airports?page=${i}">${i}</a></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </table>
</html>