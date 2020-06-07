<%-- 
    Document   : alluser
    Created on : Jun 7, 2020, 8:14:54 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="javaCode.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="multiple_row_insert_servlet" method="post">
       <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>E-mail</th>
        <th>Mobile No</th>
        
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
    
          <td><input type="text"  value="<%= user.getName()%>" name="name"/></td>
        <td><input type="text"  value="<%= user.getEmail()%>" name="email"/></td>>
       <td><input type="text"  value="<%= user.getMobileNo()%>" name="mobile"/></td>
   
      <%
      }
      %>
      
    </tbody>
  </table>
      <input type="submit"  value="save"/>
        </form>
    </body>
</html>
