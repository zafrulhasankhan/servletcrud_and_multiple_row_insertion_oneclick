<%-- 
    Document   : home
    Created on : Nov 7, 2019, 11:34:27 AM
    Author     : Zafrul Hasan Nasim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
          <h1>${msg}</h1>
           <h1>${errorMsg}</h1>
           
            <form action="loginServlet" method="POST">
            
            E-mail:
            <input type="text" name="email">
            Mobile No:
            <input type="text" name="mobileNo">
            <input type="submit" value="Login">
        </form>
           <a href="index.jsp"> open account </a>
           
    </body>
</html>
