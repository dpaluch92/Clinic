<%-- 
    Document   : kontakt
    Created on : 2017-12-07, 13:19:26
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="style.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="container">
            <div class="col-md-4">
                <legend><span class="glyphicon glyphicon-globe"></span> Nasze Biuro</legend>
                <address>
                    <strong>Poradnia Medic, SA.</strong><br>
                    Dobczyce, 32-410<br>
                    Telefon Kontaktowy: (123) 456-7890
                </address>
                <address>
                    <strong>Email Kontaktowy</strong><br>
                    <a href="mailto:#">poradnia@gmail.com</a>
                </address>
            </div>
        </div>
    </body>
</html>
