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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "multiple_row_insert_servlet", urlPatterns = {"/multiple_row_insert_servlet"})
public class multiple_row_insert_servlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
               /* ArrayList<User> userList =new ArrayList <> ();
                
                int i = 0;
                for(User user : userList){
                    i++;
                */
               muluser m = new muluser();
       String names="";
       String emails="";
String name[]=request.getParameterValues("name");
String email[]=request.getParameterValues("email");
for(int i=0;i<name.length;i++){
    names=name[i];
    emails=email[i];
                   try {
                       //m.setName(names);
                       //System.out.println(names);
                       // System.out.println(m.getName());
                       PreparedStatement ps = DBConnection.getConnection().prepareStatement("insert into mulrow values('"+names+"','"+emails+"')");
                       ps.executeUpdate();
                   } catch (SQLException ex) {
                       Logger.getLogger(multiple_row_insert_servlet.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(multiple_row_insert_servlet.class.getName()).log(Level.SEVERE, null, ex);
                   }
}
//m.setName(names);
//System.out.println(m.getName());
/*System.out.println(names);
        //String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobileNO = request.getParameter("mobile");
        System.out.println("sjs");
        System.out.println(name);*/
        }
        
        
}

