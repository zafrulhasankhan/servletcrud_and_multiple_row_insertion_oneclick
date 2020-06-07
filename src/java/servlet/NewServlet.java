/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javaCode.User;
import javaCode.muluser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         List<User> userList =new ArrayList< > ();
                
                int i = 0;
                /*for(User user : userList){
                    
                    i++;
                    String name =user.getName();
                    String email=user.getEmail();
                    String mobileNo=user.getMobileNo();
                    System.out.println(name);
                     //userList.add(new User( name,email,mobileNo));*/
                     userList.add(new User( "jj","hhh","6533"));
    
                
                String INSERT_USERS_SQL = "INSERT INTO muluser" + "  ( name, email, mobile) VALUES " +
            " (?, ?, ?);";

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/appdb?useSSL=false", "root", "");
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            connection.setAutoCommit(false);
            for (Iterator < User > iterator = userList.iterator(); iterator.hasNext();) {
                User user = (User) iterator.next();
               
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getMobileNo());
               
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


