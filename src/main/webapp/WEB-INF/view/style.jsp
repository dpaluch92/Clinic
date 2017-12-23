<%-- 
    Document   : regstyle
    Created on : 2017-11-13, 16:41:18
    Author     : depek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

        <!-- Google Fonts -->
        <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body, html{
                height: 100%;
                background-repeat: no-repeat !important;
                background-color: #d3d3d3 !important;
                font-family: 'Oxygen', sans-serif;
            }

            h1 { 
                font-size: 50px;
                font-family: 'Passion One', cursive; 
                font-weight: 400; 
            }

            .calendar-7{position:absolute;width:376px;background-color:#72b8ff;padding:8px}
            .calendar-7 .days{color:white;font:14px normal;width:100%;text-align:center}
            .calendar-7 .days .calendar-7-day{display:inline-block;cursor:pointer;width:13%;height:55px;padding-top:8px;margin-bottom:8px}
            .calendar-7 .days .calendar-7-day:hover,.calendar-7 .days .calendar-7-day.active{background-color:#2874c6}
            .calendar-7 .hours,.calendar-7 .minutes{background-color:white;width:360px;height:162px;margin:0 auto;border-radius:4px}
            .calendar-7 .minutes{display:none;height:81px}
            .calendar-7 .calendar-7-hour,.calendar-7 .calendar-7-minute{float:left;display:inline-block;box-sizing:border-box;width:25%;font:14px normal;padding:4px;color:#4a4a4a;text-align:center;cursor:pointer}
            .calendar-7 .calendar-7-hour:hover,.calendar-7 .calendar-7-minute:hover,.calendar-7 .calendar-7-hour.active,.calendar-7 .active.calendar-7-minute{background-color:#53a2f6;color:white;border-radius:3px}
            .calendar-7 .calendar-7-hour.disabled,.calendar-7 .disabled.calendar-7-minute{color:#333;background-color:#eee;cursor:not-allowed}
        </style>
    </head>
    <body>

    </body>
</html>
