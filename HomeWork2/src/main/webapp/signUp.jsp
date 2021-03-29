<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<form action="signUp" method="POST">
    Login: <input name="login"/>
    <br><br>
    Password: <input name="password"/>
    FIO: <input name="fio"/>
    <br><br>
    Birth Day: <input name="birthDay"/>
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>