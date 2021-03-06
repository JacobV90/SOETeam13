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

        ArrayList<ArrayList<String>> purchaseList = new ArrayList<>();
        
        String previous = null;
        for (Map.Entry<String, ArrayList<String>> entry : productMap.entrySet()) {
            ArrayList<String> purchase = entry.getValue();
            System.out.println(purchase.get(0));
            if (purchase.get(2).equals(email) && !purchase.get(0).equals(previous)) {
                purchase.remove(1);
                purchase.remove(1);
                purchase.remove(2);
                purchaseList.add(purchase);
                previous = purchase.get(0);
            }
        }
        
        request.getSession().setAttribute("orders", purchaseList);
        request.getRequestDispatcher("/MyOrders.jsp").forward(request, response);
    }
    
}
