<%-- 
    Document   : index
    Created on : 2017-11-13, 20:48:41
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="style.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>     
        <%@include file="navbar.jsp" %>

        <br />
        <div class="container">
            <c:forEach items="${artList}" var="artykul">
                <p style="font-size: medium;">Data : ${artykul.dataDodania}</p>
                <h1>Tytuł : ${artykul.tytul}</h1>
                <p><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${artykul.opis}</p>
                <br />
                <p class="pull-right" style="font-size: small;">Autor : ${artykul.doktor.imie} ${artykul.doktor.nazwisko}</p>
                <br />
                <br />
            </c:forEach> 
        </div>
    </body>
</html>
