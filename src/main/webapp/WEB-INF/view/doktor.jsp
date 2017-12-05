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

        <div class="row">
            <div class="col-sm-3">
            </div>
            <div class="col-sm-6">
                <div class="row">
                    <div class="col-sm-3">
                        <ul id="tabs" class="nav nav-pills nav-stacked well well-sm" data-tabs="tabs">
                            <li class="active"><a href="#profil" data-toggle="tab">Wyświetl Profil</a></li>
                            <li><a href="#edytuj" data-toggle="tab">Edytuj Profil</a></li>
                            <li><a href="#wizyta" data-toggle="tab">Zamów Wizytę</a></li>
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
