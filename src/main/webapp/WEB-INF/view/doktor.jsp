<%-- 
    Document   : doktor
    Created on : 2017-11-21, 16:11:21
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
            <div class="row">
                <div class="col-sm-3">
                    <ul id="tabs" class="nav nav-pills nav-stacked well well-sm" data-tabs="tabs">
                        <li class="active"><a href="#profil" data-toggle="tab">Wyświetl Profil</a></li>
                        <li><a href="#edytuj" data-toggle="tab">Edytuj Profil</a></li>
                        <li><a href="#lista" data-toggle="tab">Lista Wizyt</a></li>
                        <li><a href="#nowa" data-toggle="tab">Wyślij Wiadomość</a></li>
                        <li><a href="#skrzynka" data-toggle="tab">Skrzynka Odbiorcza</a></li>
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
                                        <th>Email</th>
                                        <th>Specjalosc</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${doktor.imie}</td>
                                        <td>${doktor.nazwisko}</td>
                                        <td>${doktor.login}</td>
                                        <td>${doktor.haslo}</td>
                                        <td>${doktor.email}</td>
                                        <td>${doktor.specjalnosc}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="edytuj" class="tab-pane fade ">
                            <f:form class="form-horizontal" role="form" action="doktor.e" method="POST"  commandName="doktor">
                                <f:hidden path="idDoktor" value="${doktor.idDoktor}" />
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
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Email :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="email" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Specjalnosc :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="specjalnosc" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input class="btn btn-default pull-right" type="submit" name="actionD" value="edit" />
                                    </div>
                                </div>
                            </f:form>
                        </div>
                        <div id="lista" class="tab-pane fade">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Imie Pacjenta</th>
                                        <th>Naziwsko Pacjenta</th>
                                        <th>Termin Wizyty</th>
                                        <th>Usługa</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${wizytaList}" var="wizyta">
                                        <tr>
                                            <td>${wizyta.pacjent.getImie()}</td>
                                            <td>${wizyta.pacjent.getNazwisko()}</td>
                                            <td>${wizyta.terminWizyty}</td>
                                            <td>${wizyta.uslugi.getOpis()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                                    <div id="nowa" class="tab-pane fade">
                            <form class="form-horizontal" role="form" method="POST" role="form" action="doktor.msg">
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
                                    <label class="col-sm-3 col-form-label">Wiadomość :</label>
                                    <div class="col-sm-6">
                                        <input type="text" name="msg" class="form-control" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input type="submit"  value="Wyślij wiadomość" class="btn btn-default pull-right"/>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div id="skrzynka" class="tab-pane fade">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Nadawca</th>
                                        <th>Odbiorca</th>
                                        <th>Treść</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${msgList}" var="m">
                                    <tr>
                                        <td>${m.doktor.imie}</td>
                                        <td>${m.pacjent.imie}</td>
                                        <td>${m.opis}</td>
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
