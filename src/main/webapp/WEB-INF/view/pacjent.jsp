<%-- 
    Document   : pacjent
    Created on : 2017-11-09, 13:49:44
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
                    <td>
                        <input type="submit" name="action" value="edit" />
                    </td>
                </tr>
            </table>
        </f:form> 
        <br />
        <f:form method="post" modelAttribute="selectedDoktor" action="pacjent.w">
            <f:select path="idDoktor">
                <f:options items="${doktorList}" itemValue="idDoktor" itemLabel="imie" />
            </f:select>
            <f:input  />
            <input type="submit" name="actionW" value="add" />
        </f:form>

    </body>
</html>
