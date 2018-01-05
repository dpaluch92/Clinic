<%-- 
    Document   : doktorTabManagment
    Created on : 2017-12-23, 19:20:37
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    function myFunction() {
        if (window.location.href === "http://localhost:8084/inz/doktor") {
            var profiltab = document.getElementById("prof");
            profiltab.setAttribute("class", "active");

            var profil = document.getElementById("profil");
            profil.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/doktor.e") {
            var edittab = document.getElementById("edit");
            edittab.setAttribute("class", "active");

            var edytuj = document.getElementById("edytuj");
            edytuj.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/doktor.karta") {
            var cardtab = document.getElementById("card");
            cardtab.setAttribute("class", "active");

            var karta = document.getElementById("karta");
            karta.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/doktor.msg") {
            var boxtab = document.getElementById("box");
            boxtab.setAttribute("class", "active");

            var skrzynka = document.getElementById("skrzynka");
            skrzynka.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/doktor.recepta") {
            var recepttab = document.getElementById("recept");
            recepttab.setAttribute("class", "active");

            var recepta = document.getElementById("recepta");
            recepta.setAttribute("class", "tab-pane fade in active");
        } else if (window.location.href === "http://localhost:8084/inz/doktor.art") {
            var arttab = document.getElementById("arty");
            arttab.setAttribute("class", "active");

            var artykul = document.getElementById("artykul");
            artykul.setAttribute("class", "tab-pane fade in active");
        }
    }

</script>