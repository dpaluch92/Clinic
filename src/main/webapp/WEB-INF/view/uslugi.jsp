<%-- 
    Document   : uslugi
    Created on : 2017-11-14, 12:49:35
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div class="row">
                <div class="col-md-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th><h3 class="title">Opis Usługi</h3></th>
                                <th><h3 class="title">Cena Badania</h3></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${uslugiList}" var="uslugi">
                                <tr>
                                    <td>${uslugi.opis}</td>
                                    <td>${uslugi.cena}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
