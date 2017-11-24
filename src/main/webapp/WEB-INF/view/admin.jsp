<%-- 
    Document   : admin
    Created on : 2017-11-21, 16:33:55
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="style.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="row">
            <div class="col-sm-3">
                <ul id="tabs" class="nav nav-pills nav-stacked well well-sm" data-tabs="tabs">
                    <li class="active"><a href="#pacjent" data-toggle="tab">Zarządzaj Pacjentem</a></li>
                    <li><a href="#doktor" data-toggle="tab">Zarządzaj Lekarzami</a></li>
                    <li><a href="#rejestracja" data-toggle="tab">Zarządzaj Rejestracją</a></li>
                </ul>
            </div>
            <div class="col-sm-9">
                <div id="my-tab-content" class="tab-content">
                    <div id="pacjent" class="tab-pane fade in active">
                        <f:form class="navbar-form form-inline ui form" role="form" action="admin.p" method="POST"  commandName="pacjent">
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
                                    <td><input type="submit" name="actionP" value="add" />
                                        <input type="submit" name="actionP" value="edit" />
                                        <input type="submit" name="actionP" value="delete" />
                                        <input type="submit" name="actionP" value="search" />
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
                        </form>
                    </div>
                    <div id="doktor" class="tab-pane fade">
                        <f:form class="navbar-form form-inline ui form" role="form" action="admin.d" method="POST" commandName="doktor">
                            <table>
                                <tr>
                                    <th>ID doktora</th>
                                    <td><f:input path="idDoktor" /></td>
                                </tr>
                                <tr>
                                    <th>Imie doktora</th>
                                    <td><f:input path="imie" /></td>
                                </tr>
                                <tr>
                                    <th>Nazwisko doktora</th>
                                    <td><f:input path="nazwisko" /></td>
                                </tr>
                                <tr>
                                    <th>Specjalnosc doktora</th>
                                    <td><f:input path="specjalnosc" /></td>
                                </tr>
                                <tr>
                                    <th>username doktora</th>
                                    <td><f:input path="login" /></td>
                                </tr>
                                <tr>
                                    <th>haslo doktora</th>
                                    <td><f:input path="haslo" /></td>
                                </tr>
                                <tr>
                                    <th>email doktora</th>
                                    <td><f:input path="email" /></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" name="actionD" value="add" />
                                        <input type="submit" name="actionD" value="edit" />
                                        <input type="submit" name="actionD" value="delete" />
                                        <input type="submit" name="actionD" value="search" />
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
                            <th>Specjalnosc</th>
                            <th>Password</th>
                            <th>Email</th>
                                <c:forEach items="${doktorList}" var="doktor">
                                <tr>
                                    <td>${doktor.idDoktor}</td>
                                    <td>${doktor.imie}</td>
                                    <td>${doktor.nazwisko}</td>
                                    <td>${doktor.login}</td>
                                    <td>${doktor.specjalnosc}</td>
                                    <td>${doktor.haslo}</td>
                                    <td>${doktor.email}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    <div id="rejestracja" class="tab-pane fade"> 
                        <f:form class="navbar-form form-inline ui form" role="form" action="admin.r" method="POST" commandName="rejestracja">
                            <f:hidden path="wizyta" value="null" />
                            <table>
                                <tr>
                                    <th>ID doktora</th>
                                    <td><f:input path="idRejestracji" /></td>
                                </tr>
                                <tr>
                                    <th>Imie doktora</th>
                                    <td><f:input path="imie" /></td>
                                </tr>
                                <tr>
                                    <th>Nazwisko doktora</th>
                                    <td><f:input path="nazwisko" /></td>
                                </tr>
                                <tr>
                                    <th>username doktora</th>
                                    <td><f:input path="login" /></td>
                                </tr>
                                <tr>
                                    <th>haslo doktora</th>
                                    <td><f:input path="haslo" /></td>
                                </tr>
                                <tr>
                                    <td><input type="submit" name="actionR" value="add" />
                                        <input type="submit" name="actionR" value="edit" />
                                        <input type="submit" name="actionR" value="delete" />
                                        <input type="submit" name="actionR" value="search" />
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
                                <c:forEach items="${rejestracjaList}" var="rejestracja">
                                <tr>
                                    <td>${rejestracja.idRejestracji}</td>
                                    <td>${rejestracja.imie}</td>
                                    <td>${rejestracja.nazwisko}</td>
                                    <td>${rejestracja.login}</td>
                                    <td>${rejestracja.haslo}</td>
                                </tr>
                            </c:forEach>
                        </table>

                    </div>
                </div>
            </div>
            <div class="col-sm-3">

            </div>
        </div>
    </body>
</html>
