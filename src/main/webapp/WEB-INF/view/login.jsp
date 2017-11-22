<%-- 
    Document   : login
    Created on : 2017-11-21, 15:20:40
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
        
        <h1>Hello World!</h1>
        ${loginError}
        <form action="login" method="post">
            <input type="text" id="login" name="login" placeholder="user name" />
            <input type="password" id="haslo" name="haslo" placeholder="haslo" />

            <button id="loginButton">Login</button>
        </form>
    </body>
</html>
