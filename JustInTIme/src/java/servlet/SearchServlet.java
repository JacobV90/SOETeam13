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
import java.util.Iterator;
import java.util.List;
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
public class SearchServlet extends HttpServlet {

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

        System.out.println("Search Servlet: ");
        String keyword = request.getParameter("Product");
        ArrayList<String> array = new ArrayList<>();
        array.add("Item_Name");

        // Fetch products from database based on inputted keyword
        DBManager.initializeConnection();
        HashMap<String, ArrayList<String>> productMap = DBManager.searchTable("item", array, keyword);
        DBManager.closeConnection();

        // ArrayList to hold product values
        ProductContainer cart = new ProductContainer();

        // iterate through map and retreive product values
        for (Map.Entry<String, ArrayList<String>> entry : productMap.entrySet()) {
            ArrayList<String> plist = entry.getValue();
            Product product = new Product();

            // Create product object
            if (plist != null) {
                product.setItemNo(Integer.valueOf(plist.get(0)));
                product.setItemName(plist.get(1));
                product.setItemPrice(Integer.valueOf(plist.get(2)));
                product.setItemCount(Integer.valueOf(plist.get(3)));
                product.setItemDescription(plist.get(4));
                product.setSize(plist.get(5));
                product.setImageUrl(plist.get(6));
                cart.addProduct(product);
            }
        }
        
        request.getSession().setAttribute("productList", cart);
        request.getRequestDispatcher("/ProductPage.jsp").forward(request, response);
    }

}
