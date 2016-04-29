/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import source.DBManager;
import source.Product;
import source.PurchaseOrder;
import source.XMLManager;

/**
 *
 * @author jacobveal
 */
public class ReturnServlet extends HttpServlet {

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
        System.out.println("Return Servlet:");

        String itemNum = request.getParameter("itemNum");
        String poNum = request.getParameter("poNum");
        System.out.println("Return Item (Item #, PO #): " + itemNum + " " + poNum);

        PurchaseOrder purchase = XMLManager.getPurchaseOrder(poNum);

        List<Product> products = purchase.getPurchasedItems().getProductArray();
        Product temp = new Product();
        for (int i = 0; i < products.size(); ++i) {
            String item = String.valueOf(products.get(i).getItemNo());
            if (item.equals(itemNum)) {
                temp = products.get(i);
                i = products.size();
            }
        }
        
        request.getSession().setAttribute("returnPONum", purchase.getPurchaseNumber());
        request.getSession().setAttribute("product", temp);
        request.getRequestDispatcher("ItemReturn.jsp").forward(request, response);
        
    }

}
