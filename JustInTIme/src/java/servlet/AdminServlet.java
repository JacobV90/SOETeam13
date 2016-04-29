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
public class AdminServlet extends HttpServlet {

   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager.initializeConnection();
        ArrayList<ArrayList<String>> users = DBManager.selectEntries("user", "Role", "User");
        ArrayList<ArrayList<String>> managers = DBManager.selectEntries("user", "Role", "Manager");
        ArrayList<ArrayList<String>> admins = DBManager.selectEntries("user", "Role", "Administrator");
        ArrayList<ArrayList<String>> pending = DBManager.selectEntries("auth", "auth", "n/a");
        DBManager.closeConnection();

        request.getSession().setAttribute("users", users);
        request.getSession().setAttribute("managers", managers);
        request.getSession().setAttribute("admins", admins);
        request.getSession().setAttribute("pending", pending);

        request.getRequestDispatcher("Admin.jsp").forward(request, response);
    }

}
