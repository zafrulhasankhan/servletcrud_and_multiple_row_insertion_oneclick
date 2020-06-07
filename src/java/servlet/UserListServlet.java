/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaCode.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(name = "UserListServlet", urlPatterns = {"/UserListServlet"})
public class UserListServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("User list method visited");
        ArrayList<User> userList = new ArrayList<User>();
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select *from user");
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
                //System.out.println(user);
                userList.add(user);
                
                request.setAttribute("userList",userList);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UserListServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserListServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        request.getRequestDispatcher("multiple_row_list.jsp").forward(request,response);
    }

   
    

}
