<%-- 
    Document   : agecalculator
    Created on : 8 Apr, 2022, 6:48:47 PM
    Author     : viny kaur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            <label>Enter your age:</label>
            <input type="text" name="user" value="" >
            <br>
            <input type="submit" value="Age next Birthday">
        </form>
        <p>${message}</p>
        <a href="http://localhost:8084/Calculators/arithmetic">Arithmetic Calculator</a>
    </body>
</html>
