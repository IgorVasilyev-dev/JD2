<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="static/js/sessvars.js"></script>
    <script src="static/bs5/js/bootstrap.js"></script>
    <link href="static/bs5/css/bootstrap.css" rel="stylesheet">
    <title>ProfilePa ge</title>
</head>
<body>
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
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Log In
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">My account</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logOut">Log Out</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>

<div class="container">

    <div class="row">

        <div class="col-2" style="width: 13rem">
            <div class="card" style="width: 12rem;height:12rem"> <img src="" class="card-img-top" alt=""> </div>
            <div class="list-group" style="width: 12rem" id="list-tab" role="tablist">
                <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-medCard" role="tab" aria-controls="list-medCard">My medCard</a>
                <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="list-profile">Profile</a>
                <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="list-messages">Messages</a>
                <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list" href="#list-settings" role="tab" aria-controls="list-settings">Settings</a>
            </div>
        </div>
        <div class="col">
            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade show active" id="list-medCard" role="tabpanel" aria-labelledby="list-medCard-list"></div>
                <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list"></div>
                <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">33333333333333333333333333333333333333333333333333333</div>
                <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">44444444444444444444444444444444444444444444444444444</div>
            </div>
        </div>
    </div>


</div>
<script src="static/js/profile.js"></script>
</body>
</html>
