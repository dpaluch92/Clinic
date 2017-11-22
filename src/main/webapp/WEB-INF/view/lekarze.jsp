<%-- 
    Document   : lekarze
    Created on : 2017-11-14, 15:23:22
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="style.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="container">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th><h3 class="title">Imię</h3></th>
                        <th><h3 class="title">Naziwsko</h3></th>
                        <th><h3 class="title">Specjalność</h3></th>
                        <th><h3 class="title">Email</h3></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${doktorList}" var="doktor">
                        <tr>
                            <td>${doktor.imie}</td>
                            <td>${doktor.nazwisko}</td>
                            <td>${doktor.specjalnosc}</td>
                            <td>${doktor.email}</td>
                            <td><button>Zamów wizytę</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
