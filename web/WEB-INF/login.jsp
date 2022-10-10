<%-- 
    Document   : login
    Created on : 9-Oct-2022, 3:18:39 PM
    Author     : odohd
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
        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="password" name="password" value="${password}"><br>
            <p>${message}</p>
            <input type="submit" value="Log in">
        </form>
        
    </body>
</html>
