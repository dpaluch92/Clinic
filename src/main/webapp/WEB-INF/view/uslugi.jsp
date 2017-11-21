<%-- 
    Document   : uslugi
    Created on : 2017-11-14, 12:49:35
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="style.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cennik</title>
    </head>
    <body>
        <div class="containter-fluid">
            <nav class="navbar navbar-inverse navbar-static-top">
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Aktualności</a></li>
                        <li><a href="#">Wizyta</a></li>
                        <li><a href="lekarze">Lekarze</a></li>
                        <li><a href="cennik">Cennik</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="rejestracja"><span class="glyphicon glyphicon-user"></span> Rejestracja</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logowanie</a></li>
                    </ul>
                </div>
            </nav>

        </div>
        <div class="container">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th><h3 class="title">Id</h3></th>
                        <th><h3 class="title">Doktor</h3></th>
                        <th><h3 class="title">Opis</h3></th>
                        <th><h3 class="title">Cena</h3></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${uslugiList}" var="uslugi">
                        <tr>
                            <td>${uslugi.idUslugi}</td>
                            <td>${uslugi.doktor}</td>
                            <td>${uslugi.opis}</td>
                            <td>${uslugi.cena}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
