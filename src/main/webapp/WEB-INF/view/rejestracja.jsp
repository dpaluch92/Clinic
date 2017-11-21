<%-- 
    Document   : rejestracja
    Created on : 2017-11-13, 15:42:52
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="includes.jsp" %>
<%@include file="style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="containter">
            <nav class="navbar navbar-inverse navbar-static-top">
                <div class="container">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Aktualności</a></li>
                        <li><a href="#">Wizyta</a></li>
                        <li><a href="lekarze">Lekarze</a></li>
                        <li><a href="uslugi">Cennik</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="rejestracja"><span class="glyphicon glyphicon-user"></span> Rejestracja</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logowanie</a></li>
                    </ul>
                </div>
            </nav>

            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <h1 class="title">Pacjencie zarejestruj sie!</h1>
                        <hr />
                    </div>
                </div> 
                <div class="main-login main-center">
                    <f:form class="form-horizontal" action="rejestracja.s" method="POST"  commandName="pacjent">
                        <f:hidden path="role" id="role" value="PACJENT" />
                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">Twoje Imię</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <f:input type="text" class="form-control" path="imie"  placeholder="Wprowadź imie"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">Twoje Nazwisko</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <f:input type="text" class="form-control" path="nazwisko"  placeholder="Wprowadź nazwisko"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="username" class="cols-sm-2 control-label">Twoja Nazwa Użytkownika</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                                        <f:input type="text" class="form-control" path="login"  placeholder="Wprowadź nazwę użytkownika"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="password" class="cols-sm-2 control-label">Twoje Hasło</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                        <f:input type="password" class="form-control" path="haslo" placeholder="Wprowadź hasło"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Twój Email</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <f:input type="text" class="form-control" path="email"  placeholder="Wprowadź email"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Twój Adres</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <f:input type="text" class="form-control" path="adres"  placeholder="Wprowadź adres"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">Twój Pesel</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                        <f:input type="text" class="form-control" path="pesel"  placeholder="Wprowadź pesel"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group ">
                            <input type="submit" name="akcja" value="Zarejestruj" class="btn btn-primary btn-lg btn-block login-register"></input>
                        </div>
                    </f:form>
                </div>
            </div>
            <br />
        </div>
    </body>
</html>
