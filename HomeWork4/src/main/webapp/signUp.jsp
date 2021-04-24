<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();} );
    </script>
    <title>SignUp</title>
</head>
<body>

<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;"> ${requestScope.message} </p>
    </c:when>
    <c:otherwise>
        <h3> Форма для регистрации пользователя </h3>
    </c:otherwise>
</c:choose>
<form method="POST" action="${pageContext.request.contextPath}/signUp">
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
            <tr>
                <td> ФИО: </td>
                <td> <label> <input type="text" name="fio"> </label> </td>
            </tr>
            <tr>
                <td> Дата рождения:</td>
                <td> <label for="datepicker"> </label> <input type="text" id="datepicker" name="birthDay"> </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Зарегистрироваться">
    </div>
</form>
</body>
</html>
