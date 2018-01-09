<%-- 
    Document   : terminy
    Created on : 2017-12-06, 11:34:14
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <%@include file="style.jsp" %>
        <script src="//code.jquery.com/jquery.min.js"></script>
        <%@include file="calendar7js.jsp" %>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2 style="font-weight: bold;">Posiadasz konto? Zaloguj się</h2>
                </div>

                <div class="col-md-6 well well-lg">
                    <form class="form-horizontal" action="terminy.do" method="POST">

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Imie :</label>
                            <div class="col-sm-6">
                                <input type="text" name="imie" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Nazwisko :</label>
                            <div class="col-sm-6">
                                <input type="text" name="nazwisko" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Login :</label>
                            <div class="col-sm-6">
                                <input type="text" name="login" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Hasło :</label>
                            <div class="col-sm-6">
                                <input type="password" name="haslo" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Email :</label>
                            <div class="col-sm-6">
                                <input type="text" name="email" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Adres :</label>
                            <div class="col-sm-6">
                                <input type="text" name="adres" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Pesel :</label>
                            <div class="col-sm-6">
                                <input type="text" name="pesel" class="form-control" />
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Doktor :</label>
                            <div class="col-sm-6">
                                <select class="form-control" name="doktorForm" >
                                    <c:forEach items="${doktorList}" var="Doktor">
                                        <option value="${Doktor.idDoktor}"> ${Doktor.specjalnosc} ${Doktor.imie} ${Doktor.nazwisko} </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div> 

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Usługi :</label>
                            <div class="col-sm-6">
                                <select class="form-control" name="uslugiForm" >
                                    <c:forEach items="${uslugiList}" var="uslugi">
                                        <option value="${uslugi.idUslugi}"> ${uslugi.opis} , ${uslugi.cena} zł</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>    

                        <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Termin Wizyty :</label>
                            <div class="col-sm-6">
                                <input name="terminWizyty" class="calendar7 form-control" />
                            </div>
                            <script>
                                jQuery('.calendar7').Calendar7({
                                    allowTimeStart: '1:00',
                                    allowTimeEnd: '22:00'
                                });
                            </script>
                        </div>

                        <div class="row">
                            <div class="col-sm-9">
                                <input type="submit"  value="Zamów wizytę" class="btn btn-default pull-right"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
