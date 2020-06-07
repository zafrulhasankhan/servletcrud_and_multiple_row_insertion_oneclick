<%-- 
    Document   : insertmultilplerows
    Created on : Jun 6, 2020, 8:49:06 PM
    Author     : Zafrul Hasan Nasim
--%>

<%@page import="InsertMultipleRows.printSQLException(SQLException)"%>
<%@page import="InsertMultipleRows.printBatchUpdateException(BatchUpdateException)"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.BatchUpdateException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="javaCode.User"%>
 import database.DBConnection;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
               

/**
 *
 * @author Zafrul Hasan Nasim
 */
public class mulrows {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // List<User> userList =new ArrayList< > ();
             ArrayList<User> userList = new ArrayList<User>();   
             PreparedStatement ps = DBConnection.getConnection().prepareStatement("select *from user");
                int i = 0;
                ResultSet rs =   ps.executeQuery();
            
            System.out.println("Resulset visited");
            while(rs.next()){
                
                User user = new User();
                int id = rs.getInt("id");
                user.setId(id);
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNo(rs.getString("mobileNo"));
                System.out.println("All user property set");
                System.out.println(user);
                userList.add(user);}
                
                /*for(User user : userList){
                    
                    i++;
                    String name =user.getName();
                    String email=user.getEmail();
                    String mobileNo=user.getMobileNo();
                    System.out.println(name);
                     //userList.add(new User( name,email,mobileNo));*/
                     //userList.add(new User( "jj","hhh","6533"));
    
                
                String INSERT_USERS_SQL = "INSERT INTO muluser" + "  ( name, email, mobile) VALUES " +
            " (?, ?, ?);";

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/appdb?useSSL=false", "root", "");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            connection.setAutoCommit(false);
            for (Iterator < User > iterator = userList.iterator(); iterator.hasNext();) {
                User user1 = (User) iterator.next();
               
                preparedStatement.setString(1, user1.getName());
                preparedStatement.setString(2, user1.getEmail());
                preparedStatement.setString(3, user1.getMobileNo());
               
                preparedStatement.addBatch();
            }
            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
            connection.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            printBatchUpdateException(batchUpdateException);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static void printBatchUpdateException(BatchUpdateException b) {

        System.err.println("----BatchUpdateException----");
        System.err.println("SQLState:  " + b.getSQLState());
        System.err.println("Message:  " + b.getMessage());
        System.err.println("Vendor:  " + b.getErrorCode());
        System.err.print("Update counts:  ");
        int[] updateCounts = b.getUpdateCounts();

        for (int i = 0; i < updateCounts.length; i++) {
            System.err.print(updateCounts[i] + "   ");
        }
    }

}

%>
       
      
      
     