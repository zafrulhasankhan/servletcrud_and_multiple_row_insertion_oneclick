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
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        System.out.println("edit servelet");
        
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        String name = request.getParameter("name");
        String dept= request.getParameter("dept");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String mobileNO = request.getParameter("mobileNo");

            
            System.out.println(userId+name+email+mobileNO);
            
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Update  user set Name = ? ,Department_no=?, Age=?,Email = ?, Mobile_no = ?,Age=? where id = ? ");
        ps.setString(1,name);
        ps.setString(1,dept);
        ps.setString(1,age);
            ps.setString(2,email);
            ps.setString(3,mobileNO);
            ps.setInt(4, userId);
            ps.executeUpdate();
            System.out.println("User updated successfully");
        request.getRequestDispatcher("index.jsp").forward(request,response);
        
        } catch (SQLException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

   

}
