<%-- 
    Document   : rejestracja
    Created on : 2017-11-13, 15:42:52
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
            <div class="col-md-8" style="margin-left: 400px;">
                <div class="row"> 
                    <div class="col-sm-4 well well-lg">
                        <h1>Witaj pacjencie</h1>
                        <br />
                        <f:form class="form-horizontal" action="register.do" method="POST"  commandName="pacjent">
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
                                <input type="submit" name="akcja" value="Zarejestruj" class="btn btn-primary btn-lg btn-block"></input>
                            </div>
                        </f:form>
                    </div>
                    <div class="col-sm-6">
                        <h1 style="margin-left: 100px;">Zadbaj o swoje serce pacjencie.</h1>
                        <br />
                        <img style="margin-left: 100px;" src="http://portalzdrowiadziecka.pl/wp-content/uploads/2016/08/serce-dziecka-.jpg" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
