
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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Update page visited");
        
         String id = request.getParameter("id");
        int userId = Integer.parseInt(id);
        System.out.println("User id id : "+id);
        
        PreparedStatement ps;
        try {
            ps = DBConnection.getConnection().prepareStatement("Select *from user  where id = ?");
            ps.setInt(1,userId);
            ResultSet rs =   ps.executeQuery();
            if(rs.next()){
                
                int dbId = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String mobile = rs.getString("mobileNo");
                System.out.println(name+email+mobile);
                
                request.setAttribute("name",name);
                request.setAttribute("email",email);
                request.setAttribute("mobileNo",mobile);
                //request.setAttribute("id",dbId);
                
            }
            request.setAttribute("id", userId);
            request.getRequestDispatcher("userUpdate.jsp").forward(request,response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }

    

}
