/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.DBManager;
import source.PurchaseOrder;
import source.XMLManager;

/**
 *
 * @author jacobveal
 */
public class ItemReturnServlet extends HttpServlet {

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

        String itemNum = request.getParameter("itemNum");
        String poNum = request.getParameter("poNum");
        String reason = request.getParameter("reason");
        String buyerEmail = (String) request.getSession().getAttribute("userEmail");

        DBManager.initializeConnection();
        String managerEmail = null;
        ArrayList<String> array2 = new ArrayList<>();

        array2.add("Item_No");
        HashMap<String, ArrayList<String>> managers = DBManager.searchTable("itemaddedby", array2, itemNum);
        for (Map.Entry<String, ArrayList<String>> entry : managers.entrySet()) {
            ArrayList<String> manager = entry.getValue();
            managerEmail = manager.get(0);

        }

        ArrayList<String> array = new ArrayList<>();
        array.add(poNum);
        array.add(itemNum);
        array.add(buyerEmail);
        array.add(managerEmail);
        array.add(reason);

        DBManager.insertEntry("returned_items", array);
        DBManager.closeConnection();

        response.sendRedirect("ItemReturned.jsp");
    }

}
