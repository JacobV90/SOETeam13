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
public class MyOrdersServlet extends HttpServlet {

    

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
        
        System.out.println("My Orders Servlet");
        
        String email = (String) request.getSession().getAttribute("userEmail");
        List<String> array = new ArrayList<>();
        array.add("User_Id");

        DBManager.initializeConnection();
        HashMap<String, ArrayList<String>> productMap = DBManager.searchTable("purchaseorder", array, email);
        DBManager.closeConnection();

        List<ArrayList<String>> purchaseList = new ArrayList<>();

        for (Map.Entry<String, ArrayList<String>> entry : productMap.entrySet()) {
            ArrayList<String> purchase = entry.getValue();

            if (purchase.get(2).equals(email)) {
                purchaseList.add(purchase);
                System.out.println(purchaseList.get(0).get(2));
            }

        }
        
        request.getSession().setAttribute("orders", purchaseList);

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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
