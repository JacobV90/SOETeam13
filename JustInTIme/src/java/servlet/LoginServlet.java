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
        String password = request.getParameter("Password");

        if (DBManager.initializeConnection()) {

            ArrayList<String> user = DBManager.selectEntry("user", "Email", email);

            if (BCrypt.checkpw(password, user.get(3))) {
                System.out.println("Found user");

                String firstName = user.get(1);
                String role = user.get(10);

                request.getSession().setAttribute("userEmail", email);
                request.getSession().setAttribute("firstName", firstName);
                request.getSession().setAttribute("role", role);

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

                        // Fetch products from database based on inputted keyword and user email
                        //DBManager.initializeConnection();
                        HashMap<String, ArrayList<String>> productItemNumMap = DBManager.searchTable("itemaddedby", array, email);

                        // Iterate through each product and add it to the product cart
                        for (Map.Entry<String, ArrayList<String>> entry : productItemNumMap.entrySet()) {
                            ArrayList<String> plist = entry.getValue();
                            Product product = new Product();
                            product.createProduct(DBManager.selectEntry("item", "Item_No", plist.get(1)));
                            products.addProduct(product);
                        }

                        ArrayList<ArrayList<String>> returns = new ArrayList<>();
                        array.remove(0);
                        array.add("seller_email");

                        HashMap<String, ArrayList<String>> returnedItemNumMap = DBManager.searchTable("returned_items", array, email);
                        for (Map.Entry<String, ArrayList<String>> entry : returnedItemNumMap.entrySet()) {
                            System.out.println("Returned items: " + entry.getValue().get(0));
                            returns.add(entry.getValue());
                        }

                        request.getSession().setAttribute("returns", returns);
                        request.getSession().setAttribute("productList", products);
                        request.getRequestDispatcher("/ManagerProductPage.jsp").forward(request, response);
                        break;
                    case "Administrator":
                        //request.getRequestDispatcher("/AdminServlet").forward(request, response);
                        response.sendRedirect("AdminServlet");
                        break;
                }

            } else {

            }

        }
    }

}
