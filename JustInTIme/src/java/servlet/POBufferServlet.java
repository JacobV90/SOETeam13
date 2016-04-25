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
import source.Product;
import source.ProductContainer;
import source.PurchaseOrder;
import source.XMLManager;

/**
 *
 * @author jacobveal
 */
public class POBufferServlet extends HttpServlet {

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
            out.println("<title>Servlet POBufferServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet POBufferServlet at " + request.getContextPath() + "</h1>");
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

        ProductContainer cart = (ProductContainer) request.getSession().getAttribute("Cart");
        PurchaseOrder purchase = new PurchaseOrder();
        purchase.setPurchasedItems(cart);
        String email = (String) request.getSession().getAttribute("userEmail");
        DBManager.initializeConnection();
        
        

        String poNum = String.valueOf(DBManager.getRowCount("purchaseorder"));
        request.setAttribute("poNum", poNum);

        for (Product item : cart.getProductArray()) {

            String itemNum = String.valueOf(item.getItemNo());
            String itemCartCount = String.valueOf(item.getItemCount());
            String itemCount = DBManager.selectEntryValue("item", "Item_No", itemNum, "Item_Qty");
            System.out.println(itemCount);

            int numCartItems = Integer.valueOf(itemCartCount);
            int numItems = Integer.valueOf(itemCount);

            if (numCartItems > numItems | numItems == 0) {
                request.getRequestDispatcher("/Cart.jsp").forward(request, response);
            } else {
                // Update quantity amounts in item table
                int newItemCount = numItems - numCartItems;
                DBManager.updateEntry("item", "Item_No", itemNum, "Item_Qty", String.valueOf(newItemCount));

                // Create Purchase Order Number and update PO Database table
                ArrayList<String> entryArray = new ArrayList<>();
                entryArray.add(poNum);
                entryArray.add(itemNum);
                entryArray.add(email);
                entryArray.add(String.valueOf(item.getTotalPrice()));
                entryArray.add(String.valueOf(item.getItemCount()));
                DBManager.insertEntry("purchaseorder", entryArray);

                // Remove product from user's cart
                XMLManager.removeProductFromCart(email, itemNum);
                purchase.setPurchaseNumber(poNum);
                XMLManager.addPurchaseOrder(purchase);

            }
        }
        DBManager.closeConnection();

        response.sendRedirect("POServlet");

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
