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
import source.DBManager;
import source.PasswordControl;

/**
 *
 * @author jacobveal
 */
public class EditAccountServlet extends HttpServlet {
    
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

        String email = (String) request.getSession().getAttribute("userEmail");
        String oldPW = request.getParameter("oldPW");
        String newPW1 = request.getParameter("newPW1");
        String newPW2 = request.getParameter("newPW2");
        String phone = request.getParameter("phone");
        String month = request.getParameter("BirthMonth");
        String day = request.getParameter("BirthDay");
        String year = request.getParameter("BirthYear");
        String action = request.getParameter("submit");

        switch (action) {
            case "Confirm":
                DBManager.initializeConnection();
                String password = DBManager.selectEntryValue("user", "Email", email, "Password");

                if (BCrypt.checkpw(oldPW, password)) {

                    if (newPW1.equals(newPW2) && PasswordControl.validatePass(newPW1)) {
                        
                        newPW2  = BCrypt.hashpw(newPW2, BCrypt.gensalt(10));
                        DBManager.updateEntry("user", "Email", email, "Password", newPW2);
                        DBManager.updateEntry("user", "Email", email, "BirthMonth", month);
                        DBManager.updateEntry("user", "Email", email, "BirthDay", day);
                        DBManager.updateEntry("user", "Email", email, "BirthYear", year);
                        System.out.println("Use successfully updated");
                        DBManager.closeConnection();
                    }
                    else{
                        
                    }

                } else {
                    System.out.println("password did not match");
                    response.sendRedirect("Account.jsp");

                }

                break;
            case "Cancel":

                response.sendRedirect("Account.jsp");
                break;
            default:
                break;
        }
        response.sendRedirect("HomePage.jsp");

    }

}
