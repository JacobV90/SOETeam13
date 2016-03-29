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
import source.DBManager;
import source.Product;

/**
 * The ModfiyProduct servlet class communicates with the data base to handle
 * product inquires from the user interface.
 *
 * @author jacobveal
 */
public class ProductServlet extends HttpServlet {

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
            out.println("<title>Servlet Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifyProduct at " + request.getContextPath() + "</h1>");
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

        String user = request.getParameter("Email");
        System.out.println(user);
        System.out.println("Hello from the product server");

    }

    /**
     * Handles the HTTP <code>POST</code> from AddProduct.jsp and
     * ModifiyProduct.jsp Determines if a product will be added, deleted or
     * modified in relationship to the database.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //Grab parameters from previous page
        String name = request.getParameter("ProductName");
        String description = request.getParameter("ProductDescription");
        String action = request.getParameter("submit");
        String itemNum = request.getParameter("itemNum");
        String price = request.getParameter("ProductPrice");
        String count = request.getParameter("ProductQuantity");

        //determines which action to perform on the database
        switch (action) {
            case "Add":
                System.out.println(action);
                Product product = new Product(name, Integer.valueOf(count), Double.valueOf(price), description);
                DBManager.initializeConnection();
                DBManager.insertEntry("item", product.getProduct());
                //DBManager.insertEntry("itemaddedby", )
                DBManager.closeConnection();
            case "Delete":
                System.out.println(action);
                DBManager.initializeConnection();
                DBManager.deleteEntry("item", itemNum, "Item_No");
                DBManager.closeConnection();
            case "Modify":
                System.out.println(action);
                DBManager.initializeConnection();
                DBManager.updateEntry("item", "Item_No", "1", "Item_Name", name);
                DBManager.updateEntry("item", "Item_No", "1", "Item_Cost", price);
                DBManager.updateEntry("item", "Item_No", "1", "Item_Qty", count);
                DBManager.updateEntry("item", "Item_No", "1", "Item_Desc", description);
                DBManager.closeConnection();
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
