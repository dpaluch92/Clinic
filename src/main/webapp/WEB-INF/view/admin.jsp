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
        <title>Administrator</title>
        <%@include file="style.jsp" %>
        <%@include file="adminTabManagment.jsp" %>
    </head>
    <body onload="myFunction()">

        <%@include file="navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <ul id="tabs" class="nav nav-pills nav-stacked well well-sm" data-tabs="tabs">
                        <li id="prof"><a href="#profil" data-toggle="tab">Wyświetl Profil</a></li>
                        <li id="pacj"><a href="#pacjent" data-toggle="tab">Zarządzaj Pacjentem</a></li>
                        <li id="dokt"><a href="#doktor" data-toggle="tab">Zarządzaj Lekarzami</a></li>
                        <li id="rej"><a href="#rejestracja" data-toggle="tab">Zarządzaj Rejestracją</a></li>
                    </ul>
                </div>
                <div class="col-sm-9">
                    <div id="my-tab-content" class="tab-content">
                        <div id="profil" class="tab-pane fade">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Username</th>
                                        <th>Password</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${admin.idAdmina}</td>
                                        <td>${admin.login}</td>
                                        <td>${admin.haslo}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="pacjent" class="tab-pane fade">
                            <f:form class="form-horizontal" role="form" action="admin.p" method="POST"  commandName="pacjent">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Id Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="idPacjenta" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Imie Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="imie" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Nazwisko Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="nazwisko" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Login Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="login" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Hasło Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="haslo" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Email Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="email" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Adres Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="adres" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Pesel Pacjenta :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="pesel" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input class="btn btn-default pull-right" type="submit" name="actionP" value="add" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionP" value="edit" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionP" value="delete" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionP" value="search" />
                                    </div>
                                </div>
                            </f:form>

                            <br />

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Imie</th>
                                        <th>Nazwisko</th>
                                        <th>Username</th>
                                        <th>Password</th>
                                        <th>Email</th>
                                        <th>Adres</th>
                                    </tr>
                                </thead>
                                <tbody>
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
                                </tbody>
                            </table>
                            </form>
                        </div>
                        <div id="doktor" class="tab-pane fade">
                            <f:form class="form-horizontal" role="form" action="admin.d" method="POST" commandName="doktor">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Id Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="idDoktor" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Imie Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="imie" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Nazwisko Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="nazwisko" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Specjalnosc Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="specjalnosc" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Username Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="login" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Hasło Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="haslo" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Email Doktora :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="email" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input class="btn btn-default pull-right" type="submit" name="actionD" value="add" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionD" value="edit" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionD" value="delete" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionD" value="search" />
                                    </div>
                                </div>
                            </f:form>

                            <br />
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Imie</th>
                                        <th>Nazwisko</th>
                                        <th>Username</th>
                                        <th>Specjalnosc</th>
                                        <th>Password</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
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
                                </tbody>
                            </table>
                        </div>
                        <div id="rejestracja" class="tab-pane fade"> 
                            <f:form class="form-horizontal" role="form" action="admin.r" method="POST" commandName="rejestracja">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Id Rejestracji :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="idRejestracji" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Imie Rejestracji :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="imie" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Nazwisko Rejestracji :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="nazwisko" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Username Rejestracji :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="login" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Hasło Rejestracji :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="haslo" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input class="btn btn-default pull-right" type="submit" name="actionR" value="add" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionR" value="edit" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionR" value="delete" />
                                        <input class="btn btn-default pull-right" type="submit" name="actionR" value="search" />
                                    </div>
                                </div>
                            </f:form> 

                            <br />
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Imie</th>
                                        <th>Nazwisko</th>
                                        <th>Username</th>
                                        <th>Password</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${rejestracjaList}" var="rejestracja">
                                        <tr>
                                            <td>${rejestracja.idRejestracji}</td>
                                            <td>${rejestracja.imie}</td>
                                            <td>${rejestracja.nazwisko}</td>
                                            <td>${rejestracja.login}</td>
                                            <td>${rejestracja.haslo}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
