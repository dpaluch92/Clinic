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


        <div class="container">
            <c:forEach items="${artList}" var="artykul">
                <p>Data : ${artykul.dataDodania}</p>
                <p>Tytul : ${artykul.tytul}</p>
                <p>Opis : ${artykul.opis}</p>
                <p>Autor : ${artykul.doktor.imie} ${artykul.doktor.nazwisko}</p>
            </c:forEach> 
        </div>
    </body>
</html>
