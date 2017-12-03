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
        <br />
        
        <form method="POST" role="form" action="pacjent.w">
          Doktor:  <select name="doktorForm" >
            <c:forEach items="${doktorList}" var="Doktor">
                <option value="${Doktor.idDoktor}"> ${Doktor.imie} </option>
                </c:forEach>
            </select>
             <br />
            <br />
         Uwagi: <input name="uwagi" value="brak" />
          <br />
          <input name="terminWizyty" />
            <input type="submit"  value="add" />
        </form>

    </body>
</html>