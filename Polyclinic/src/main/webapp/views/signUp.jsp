<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--    <script src="static/js/sessvars.js"></script>--%>
    <script src="static/bs5/js/bootstrap.js"></script>
    <link href="static/bs5/css/bootstrap.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;"> ${requestScope.message} </p>
    </c:when>
</c:choose>
<div class="container">
    <div class="row-col">
        1 of 1
    </div>
    <div class="row">
        <div class="col">
            Hell Street 666
        </div>
        <div class="col-9">

        </div>
        <div class="col">
            Tel: 666-666-666
        </div>
    </div>
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <div class="col">
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                        <h4>IPolyclinic</h4>
                        <h6>Exams & Diagnostics</h6>
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>

                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">HOME</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">ABOUT US</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/departments.jsp">DEPARTMENTS</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/disease.jsp">DISEASE</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/contact.jsp">CONTACT</a>
                        </li>
                        <c:choose>
                            <c:when test="${sessionScope.login != null}">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="${pageContext.request.contextPath}/profile" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            ${sessionScope.login}
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">My account</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logOut">Log Out</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/signIn">Log In</a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<div class="row" style="height: 4rem"></div>
<div class="row">
    <div class = "col-4"></div>
    <div class="col-md-4">
        <form method="POST" action="${pageContext.request.contextPath}/signUp">
            <div class="mb-3">
                <label for="login" class="form-label">Login</label>
                <input type="text" class="form-control" name="login" id="login">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="password">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" aria-describedby="emailHelp">
                <div id="emailHelp" class="form-text"> Мы никогда никому не передадим вашу электронную почту :)</div>
            </div>

            <div class="mb-3">
                <label for="tel" class="form-label">Tel</label>
                <input type="tel" class="form-control" name="tel" id="tel">
            </div>
            <input type="submit" class="btn btn-primary" value="Отправить"/>
        </form>
    </div>
    <div class = "col"></div>
</div>
</body>
</html>