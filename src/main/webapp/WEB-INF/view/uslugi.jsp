<%-- 
    Document   : uslugi
    Created on : 2017-11-14, 12:49:35
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cennik</title>
        <%@include file="style.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

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
