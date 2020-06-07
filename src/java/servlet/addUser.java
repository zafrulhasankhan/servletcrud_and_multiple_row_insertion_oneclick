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
@WebServlet(name = "addUser", urlPatterns = {"/addUser"})
public class addUser extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNO = request.getParameter("mobileNo");

            
            System.out.println(name+email+mobileNO);
            
        try {
            PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into user values (id,?,?,?)");
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,mobileNO);
            int i = ps.executeUpdate();
            if(i>0){
                String msg="Data inserted successfully";
                request.setAttribute("msg", msg);
                
            }
            else{
                
                String error = "Data not inserted successfully.<a href=index.jsp> Plese try agin </a>";
                request.setAttribute("error", error);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    request.getRequestDispatcher("home.jsp").forward(request,response);
        
    }

    

}
