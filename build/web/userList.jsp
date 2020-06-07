 <%@page import="java.util.ArrayList"%>
<%@page import="javaCode.User"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="new.css" rel="stylesheet">
  
</head>
<body>

<div class="container">
  <h2>All User List</h2>
  
  <a href="addUser.jsp" class="btn btn-primary pull-right btn-md">Add New User</a>
           
  <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>E-mail</th>
        <th>Mobile No</th>
        <th>Update</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
        <%
                ArrayList<User> userList =(ArrayList) request.getAttribute("userList");
                
                int i = 0;
                for(User user : userList){
                    i++;
                
        %>
      <tr>
        <td><%= user.getName()%></td>
        <td><%= user.getEmail()%></td>
        <td><%= user.getMobileNo()%></td>
        <td><%out.print("<a href='UpdateServlet?id="+user.getId()+"'</a>");%>Update</td>
        <td><%out.print("<a href='DeleteServlet?id="+user.getId()+"'</a>");%>Delete</td>
      </tr>  
      <%
      }
      %>
      
    </tbody>
  </table>
</div>

</body>
</html>
