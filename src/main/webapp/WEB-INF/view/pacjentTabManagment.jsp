<%-- 
    Document   : pacjentTabManagment
    Created on : 2018-01-07, 13:00:15
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
            var pacjtab = document.getElementById("pacj");
            pacjtab.setAttribute("class", "active");

            var pacjent = document.getElementById("pacjent");
            pacjent.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/admin.d") {
            var dokttab = document.getElementById("dokt");
            dokttab.setAttribute("class", "active");

            var doktor = document.getElementById("doktor");
            doktor.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/admin.r") {
            var rejtab = document.getElementById("rej");
            rejtab.setAttribute("class", "active");

            var rejestracja = document.getElementById("rejestracja");
            rejestracja.setAttribute("class", "tab-pane fade in active");
        }
    }
</script>