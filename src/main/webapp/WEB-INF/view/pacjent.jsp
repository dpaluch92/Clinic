<%-- 
    Document   : pacjent
    Created on : 2017-11-09, 13:49:44
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pacjent</title>
        <%@include file="style.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        
        <f:form action="pacjent.do" method="POST"  commandName="pacjent">
            <table>
                <tr>
                    <th>ID pacjenta</th>
                    <td><f:input path="idPacjenta" /></td>
                </tr>
                <tr>
                    <th>Imie pacjenta</th>
                    <td><f:input path="imie" /></td>
                </tr>
                <tr>
                    <th>Nazwisko Pacjenta</th>
                    <td><f:input path="nazwisko" /></td>
                </tr>
                <tr>
                    <th>username Pacjenta</th>
                    <td><f:input path="login" /></td>
                </tr>
                <tr>
                    <th>haslo Pacjenta</th>
                    <td><f:input path="haslo" /></td>
                </tr>
                <tr>
                    <th>email Pacjenta</th>
                    <td><f:input path="email" /></td>
                </tr>
                <tr>
                    <th>adres Pacjenta</th>
                    <td><f:input path="adres" /></td>
                </tr>
                <tr>
                    <th>pesel Pacjenta</th>
                    <td><f:input path="pesel" /></td>
                </tr>
                <tr>
                    <td><input type="submit" name="action" value="add" />
                        <input type="submit" name="action" value="edit" />
                        <input type="submit" name="action" value="delete" />
                        <input type="submit" name="action" value="search" />
                    </td>
                </tr>
            </table>
        </f:form>

        <br />

        <table>
            <th>ID</th>
            <th>Imie</th>
            <th>Nazwisko</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Adres</th>
                <c:forEach items="${pacjentList}" var="pacjent">
                <tr>
                    <td>${pacjent.idPacjenta}</td>
                    <td>${pacjent.imie}</td>
                    <td>${pacjent.nazwisko}</td>
                    <td>${pacjent.login}</td>
                    <td>${pacjent.haslo}</td>
                    <td>${pacjent.email}</td>
                    <td>${pacjent.adres}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
