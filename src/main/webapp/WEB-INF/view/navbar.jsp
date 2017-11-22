<%-- 
    Document   : navbar
    Created on : 2017-11-22, 12:26:36
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li><a href="index">Aktualności</a></li>
                    <li><a href="terminy">Wizyta</a></li>
                    <li><a href="lekarze">Lekarze</a></li>
                    <li><a href="cennik">Cennik</a></li>
                </ul>
                <c:choose>
                    <c:when test="${sessionScope.loggedInPacjent != null || sessionScope.loggedInAdmin !=null || 
                                    sessionScope.loggedInDoktor !=null || sessionScope.loggedInRejestracja !=null}">
                            <ul class="nav navbar-nav navbar-right">
                                <c:choose>
                                    <c:when test="${sessionScope.loggedInPacjent != null}">
                                        <li><a>Witaj ${loggedInPacjent.imie}</a></li>
                                        </c:when>
                                        <c:when test="${sessionScope.loggedInAdmin != null}">
                                        <li><a>Witaj ${loggedInAdmin.login}</a></li>
                                        </c:when>
                                        <c:when test="${sessionScope.loggedInDoktor != null}">
                                        <li><a>Witaj ${loggedInDoktor.imie}</a></li>
                                        </c:when>
                                        <c:when test="${sessionScope.loggedInRejestracja != null}">
                                        <li><a>Witaj ${loggedInRejestracja.imie}</a></li>
                                        </c:when>
                                    </c:choose>
                                <li><a href="logout">Logout</a></li>
                            </ul>
                    </c:when>
                    <c:otherwise>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="register"><span class="glyphicon glyphicon-user"></span> Rejestracja</a></li>
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Logowanie</a></li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav> 
    </body>
</html>
