<%-- 
    Document   : rejestracja
    Created on : 2017-11-22, 14:21:12
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="style.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-sm-3">
                    <ul id="tabs" class="nav nav-pills nav-stacked well well-sm" data-tabs="tabs">
                        <li class="active"><a href="#profil" data-toggle="tab">Wyświetl Profil</a></li>
                        <li><a href="#edytuj" data-toggle="tab">Edytuj Profil</a></li>
                        <li><a href="#wizyta" data-toggle="tab">Zamów Wizytę</a></li>
                        <li><a href="#wyswietl" data-toggle="tab">Wyświetl Wizyty</a></li>
                    </ul>
                </div>
                <div class="col-sm-9">
                    <div id="my-tab-content" class="tab-content">
                        <div id="profil" class="tab-pane fade in active">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Imie</th>
                                        <th>Nazwisko</th>
                                        <th>Username</th>
                                        <th>Password</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${rejestracja.imie}</td>
                                        <td>${rejestracja.nazwisko}</td>
                                        <td>${rejestracja.login}</td>
                                        <td>${rejestracja.haslo}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="edytuj" class="tab-pane fade ">
                            <f:form class="form-horizontal" role="form" action="rejestracja.e" method="POST"  commandName="rejestracja">
                                <f:hidden path="idRejestracji" value="${rejestracja.idRejestracji}" />
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Imie :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="imie" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Nazwisko :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="nazwisko" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Login :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="login" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Hasło :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="haslo" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input class="btn btn-default pull-right" type="submit" name="actionR" value="edit" />
                                    </div>
                                </div>
                            </f:form>
                        </div>
                        <div id="wizyta" class="tab-pane fade ">
                            <form class="form-horizontal" role="form" method="POST" role="form" action="rejestracja.w">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Doktor :</label>
                                    <div class="col-sm-6">
                                        <select class="form-control" name="doktorForm" >
                                            <c:forEach items="${doktorList}" var="Doktor">
                                                <option value="${Doktor.idDoktor}"> ${Doktor.imie} </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>    
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Pacjent :</label>
                                    <div class="col-sm-6">
                                        <select class="form-control" name="pacjentForm" >
                                            <c:forEach items="${pacjentList}" var="pacjent">
                                                <option value="${pacjent.idPacjenta}"> ${pacjent.imie} </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>  
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Usługi :</label>
                                    <div class="col-sm-6">
                                        <select class="form-control" name="uslugiForm" >
                                            <c:forEach items="${uslugiList}" var="uslugi">
                                                <option value="${uslugi.idUslugi}"> ${uslugi.opis} , ${uslugi.cena} </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>    
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Termin Wizyty :</label>
                                    <div class="col-sm-6">
                                        <input type="date" name="terminWizyty" class="form-control" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input type="submit"  value="Zarejestruj Wizytę" class="btn btn-default pull-right"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div id="wyswietl" class="tab-pane fade ">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Id Wizyty</th>
                                        <th>Imie Pacjenta</th>
                                        <th>Naziwsko Pacjenta</th>
                                        <th>Imie Doktora</th>
                                        <th>Nazwisko Doktora</th>
                                        <th>Termin Wizyty</th>
                                        <th>Usługa</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${wizytaList}" var="wizyta">
                                        <tr>
                                            <td>${wizyta.idWizyty}</td>
                                            <td>${wizyta.pacjent.getImie()}</td>
                                            <td>${wizyta.pacjent.getNazwisko()}</td>
                                            <td>${wizyta.doktor.getImie()}</td>
                                            <td>${wizyta.doktor.getNazwisko()}</td>
                                            <td>${wizyta.terminWizyty}</td>
                                            <td>${wizyta.uslugi.getOpis()}</td>
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
