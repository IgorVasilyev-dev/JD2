<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
</head>
<body>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/airports?page=1';" value="Просмотреть список аэропортов" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/flight';" value="Просмотреть список полетов" /></p>
</body>

</html>