<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>pacjent</title>
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
                                        <th>Adres</th>
                                        <th>Pesel</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>${pacjent.imie}</td>
                                        <td>${pacjent.nazwisko}</td>
                                        <td>${pacjent.login}</td>
                                        <td>${pacjent.haslo}</td>
                                        <td>${pacjent.email}</td>
                                        <td>${pacjent.adres}</td>
                                        <td>${pacjent.pesel}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div id="edytuj" class="tab-pane fade ">
                            <f:form class="form-horizontal" role="form" action="pacjent.e" method="POST"  commandName="pacjent">
                                <f:hidden path="idPacjenta" value="${pacjent.idPacjenta}" />
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
                                    <label class="col-sm-3 col-form-label">Adres :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="adres" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Pesel :</label>
                                    <div class="col-sm-6">
                                        <f:input class="form-control" path="pesel" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-9">
                                        <input class="btn btn-default pull-right" type="submit" name="actionP" value="edit" />
                                    </div>
                                </div>
                            </f:form>
                        </div>
                        <div id="wizyta" class="tab-pane fade">
                            <form class="form-horizontal" role="form" method="POST" role="form" action="pacjent.w">
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
                        <div id="nowa" class="tab-pane fade">
                            <form class="form-horizontal" role="form" method="POST" role="form" action="pacjent.msg">
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
                                        <td>${m.pacjent.imie}</td>
                                        <td>${m.doktor.imie}</td>
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