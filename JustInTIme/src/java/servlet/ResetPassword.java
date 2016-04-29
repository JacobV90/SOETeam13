/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.BCrypt;
import source.PasswordControl;
import source.DBManager;

/**
 *
 * @author jacobveal
 */
public class ResetPassword extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("ResetPassword Servlet:");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (PasswordControl.validatePass(password)) {

            //hash password
            password = BCrypt.hashpw(password, BCrypt.gensalt(10));
            
            DBManager.initializeConnection();

            if (DBManager.updateEntry("user", "Email", email, "Password", password)) {

                System.out.println("Password successfully changed");
                
                DBManager.closeConnection();
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } else {
                System.out.println("Password change unsuccessfull");
                request.getRequestDispatcher("/ResetPassword.jsp").forward(request, response);

            }
        }

    }

}
