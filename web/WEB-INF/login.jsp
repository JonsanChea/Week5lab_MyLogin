<%-- 
    Document   : login
    Created on : 8-Oct-2022, 3:19:30 PM
    Author     : Jonat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method = "post" value="login">
            Username: <input type="text" name="username"/>
            <br>
            Password: <input type="text" name="password"/>
            <br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
