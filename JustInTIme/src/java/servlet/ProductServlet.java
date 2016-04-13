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

        String itemNo = request.getParameter("productNumber");
        String action = request.getParameter("action");

        switch (action) {
            case "details":
                List<Product> productList = (List) request.getSession().getAttribute("productList");

                for (Object item : productList) {
                    Product product = (Product) item;
                    if (String.valueOf(product.getItemNo()).equals(itemNo)) {
                        request.getSession().setAttribute("product", product);
                        request.getRequestDispatcher("/ProductDetails.jsp").forward(request, response);
                    }
                }
                System.out.println(((Product) productList.get(0)).getItemName());

                break;
            default:
                break;
        }

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

        //Grab parameters from previous page
        String name = request.getParameter("ProductName");
        String description = request.getParameter("ProductDescription");
        String action = request.getParameter("submit");
        String itemNum = request.getParameter("itemNum");
        String price = request.getParameter("ProductPrice");
        String count = request.getParameter("ProductQuantity");
        String email = (String) request.getSession().getAttribute("userEmail");
        System.out.println(email);
        System.out.println(itemNum);

        //determines which type of database query execution to perform
        switch (action) {
            case "Add":
                System.out.println(action);
                Product product = new Product(name, Integer.valueOf(count), Double.valueOf(price), description);
                ArrayList<String> list = new ArrayList<>();
                list.add(email);
                list.add(String.valueOf(product.getItemNo()));
                DBManager.initializeConnection();
                DBManager.insertEntry("item", product.getProduct());
                DBManager.insertEntry("itemaddedby", list);
                DBManager.closeConnection();
                break;
            case "Delete":
                System.out.println(action);
                DBManager.initializeConnection();
                DBManager.deleteEntry("item", itemNum, "Item_No");
                DBManager.closeConnection();
                break;
            case "Modify":
                System.out.println(action);
                DBManager.initializeConnection();
                DBManager.updateEntry("item", "Item_No", "1", "Item_Name", name);
                DBManager.updateEntry("item", "Item_No", "1", "Item_Cost", price);
                DBManager.updateEntry("item", "Item_No", "1", "Item_Qty", count);
                DBManager.updateEntry("item", "Item_No", "1", "Item_Desc", description);
                DBManager.closeConnection();
                break;

        }

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

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
