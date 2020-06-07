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
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        System.out.println("User id id : "+id);
        
        
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("Delete from user where id = ?");
            ps.setInt(1,userId);
            ps.executeUpdate();
            System.out.println("Deleted successfully");
            
        } catch (SQLException ex) {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

   

}
