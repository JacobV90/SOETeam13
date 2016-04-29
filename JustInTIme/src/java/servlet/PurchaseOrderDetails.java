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
import source.Product;
import source.PurchaseOrder;
import source.XMLManager;

/**
 *
 * @author jacobveal
 */
public class PurchaseOrderDetails extends HttpServlet {

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
        System.out.println("Purchase Order Details Servlet:");

        String poNum = request.getParameter("details");

        System.out.println("Purchase Order Number: " + poNum);

        PurchaseOrder purchase = XMLManager.getPurchaseOrder(poNum);

        for (Product item : purchase.getPurchasedItems().getProductArray()) {

            System.out.println("<<<<<------>>>>>:");

            for (String value : item.getProduct()) {

                System.out.println("Value from XML:" + value);
            }
        }

        purchase.setPurchaseNumber(poNum);
        request.getSession().setAttribute("purchase", purchase);
        request.getRequestDispatcher("/PODetails.jsp").forward(request, response);

    }

}
