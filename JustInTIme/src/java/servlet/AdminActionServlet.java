/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.DBManager;

/**
 *
 * @author jacobveal
 */
public class AdminActionServlet extends HttpServlet {

   
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
        String email = request.getParameter("user");
        String action = request.getParameter("action");
        String role = request.getParameter("role");
        System.out.println("Admin action: "+role);

        DBManager.initializeConnection();
        

        if (action.equals("promote")) {

            DBManager.updateEntry("auth", "email", email, "isApproved", "1");
            ArrayList<String> user = DBManager.selectEntry("user", "Email", email);
            DBManager.updateEntry("user_code", "Code", user.get(9), "isUsed", "1");
            DBManager.updateEntry("user", "Email", email, "Role", role);
        }

        DBManager.closeConnection();
        //request.getRequestDispatcher("AdminServlet").forward(request, response);
        response.sendRedirect("AdminServlet");
    }

}
