/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.DBManager;
import source.Product;
import source.ProductContainer;

/**
 *
 * @author jacobveal
 */
public class ManagerServlet extends HttpServlet {

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

        
        System.out.println("Manager Servlet: ");
        String email = (String) request.getSession().getAttribute("userEmail");

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

       
        request.getSession().setAttribute("productList", products);
        request.getRequestDispatcher("/ManagerProductPage.jsp").forward(request, response);
    }

}
