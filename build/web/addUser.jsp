
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
        <h1>Add new user</h1>
        <div>
        <form action="addUser" method="POST">
           
            Name :
            <input class="form-control" type="text" name="name" required="">
           
            E-mail:
            <input class="form-control" type="email" name="email" required="">
            Mobile No:
            <input class="form-control" type="text" name="mobileNo" required="">
            <input type="submit" value="Save">

        </form>
        </div>
        <a href="login.jsp"> Login</a>
        </div>
    </body>
</html>

