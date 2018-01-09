<%-- 
    Document   : login
    Created on : 2017-11-21, 15:20:40
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>


        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <div class="col-md-6 well well-lg">
                            <h1>Formularz logowania</h1>
                            <br />

                            <form class="form-horizontal" action="login" method="post">
                                <div class="form-group">
                                    <label class="cols-sm-2 control-label">Wpisz login :</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                        <input class="form-control" type="text" id="login" name="login" placeholder="login" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="cols-sm-2 control-label">Wpisz hasło :</label>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                        <input class="form-control" type="password" id="haslo" name="haslo" placeholder="haslo" />
                                    </div>
                                </div>
                                <p>${loginError}</p>
                                <div class="form-group ">
                                    <input type="submit" value="Zaloguj" class="btn btn-primary btn-lg btn-block" id="loginButton" />
                                </div>
                            </form>
                        </div>
                        <div class="col-md-6">
                            <h1 style="margin-left: 15%;">Nie masz konta?</h1>
                            <br />
                            <h4 style="font-weight: bold; margin-left: 15%;">Zarejestruj się w naszej poradni kardiologicznej <a href="register" style="text-decoration: none">tutaj.</a></h4>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
