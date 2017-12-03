<%-- 
    Document   : index
    Created on : 2017-11-13, 20:48:41
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
        <div class="containter">            
            <%@include file="navbar.jsp" %>
        </div>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3">
                </div>
                <div class="col-sm-6">
                    <h3>Aktualności</h3>
                    <br />
                    <div class="well">
                        <iframe width="560" height="315" src="//www.youtube.com/embed/aPLL45KpoSE" allowfullscreen=""></iframe>
                    </div>
                </div>
                <div class="col-sm-3">
                </div>
            </div>
        </div>
    </body>
</html>
