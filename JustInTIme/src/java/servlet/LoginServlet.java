/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.BCrypt;
import source.DBManager;
import source.Product;
import source.ProductContainer;

/**
 *
 * @author jacobveal
 */
public class LoginServlet extends HttpServlet {

    Connection connection = null;
    Statement stmt = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
    }

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

        System.out.println("    Login Servlet:");

        String email = request.getParameter("Email");
        System.out.println(email);

        String password = request.getParameter("Password");

        if (DBManager.initializeConnection()) {

            ArrayList<String> user = DBManager.selectEntry("user", "Email", email);

            if (BCrypt.checkpw(password, user.get(3))) {
                System.out.println("Found user");

                String firstName = user.get(1);
                String role = user.get(10);

                request.setAttribute("name", firstName);
                request.setAttribute("role", role);

                switch (role) {
                    case "User":
                        System.out.println("Made it to homepage");
                        ///ProductContainer cart = new Product
                        request.getSession().setAttribute("userEmail", email);
                        request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
                        break;
                    case "Manager":

                        ProductContainer products = new ProductContainer(email);
                        ArrayList<String> array = new ArrayList<>();
                        array.add("Email");

                        // Fetch products from database based on inputted keyword
                        DBManager.initializeConnection();
                        HashMap<String, ArrayList<String>> productItemNumMap = DBManager.searchTable("itemaddedby", array, email);
                        for (Map.Entry<String, ArrayList<String>> entry : productItemNumMap.entrySet()) {
                            ArrayList<String> plist = entry.getValue();
                            Product product = new Product();
                            product.createProduct(DBManager.selectEntry("item", "Item_No", plist.get(1)));
                            products.addProduct(product);
                        }

                        request.getSession().setAttribute("userEmail", email);
                        request.getSession().setAttribute("productList", products);
                        request.getRequestDispatcher("/ManagerProductPage.jsp").forward(request, response);
                        break;
                }

            } else {

            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
