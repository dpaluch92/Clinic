<%-- 
    Document   : adminTabManagment
    Created on : 2017-12-22, 18:30:16
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    function myFunction() {
        if (window.location.href === "http://localhost:8084/inz/admin") {
            var profiltab = document.getElementById("prof");
            profiltab.setAttribute("class", "active");

            var profil = document.getElementById("profil");
            profil.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/admin.p") {
            var pacjenttab = document.getElementById("pacj");
            pacjenttab.setAttribute("class", "active");

            var pacjent = document.getElementById("pacjent");
            pacjent.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/admin.d") {
            var doktortab = document.getElementById("dokt");
            doktortab.setAttribute("class", "active");

            var doktor = document.getElementById("doktor");
            doktor.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/admin.r") {
            var rejestracjatab = document.getElementById("rej");
            rejestracjatab.setAttribute("class", "active");

            var rejestracja = document.getElementById("rejestracja");
            rejestracja.setAttribute("class", "tab-pane fade in active");
        }
    }
</script>
