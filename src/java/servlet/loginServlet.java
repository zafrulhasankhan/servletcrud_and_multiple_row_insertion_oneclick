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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Zafrul Hasan Nasim
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");
        
        System.out.println(email+mobileNo);
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("select * from user where email = ? and mobileNo = ?");
            ps.setString(1, email);
            ps.setString(2, mobileNo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String userEmail = rs.getString("email");
                String userName = rs.getString("name");
                String userMobile = rs.getString("mobileNo");
                request.setAttribute("email",userEmail);
                request.setAttribute("name",userName);
                request.setAttribute("mobileNo ",userMobile);
               
                
                String msg = "Login Successfull";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("home.jsp").forward(request,response);
            }
            
            
        } catch (SQLException ex) {
            System.out.println("jfjdf");
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
            
           
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
       String error = "Loginin Failed.Please try again.";
            request.setAttribute("errorMsg",error);
            request.getRequestDispatcher("login.jsp").forward(request,response);
    }


}
