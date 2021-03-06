/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.Product;
import source.ProductContainer;
import source.XMLManager;

/**
 *
 * @author jacobveal
 */
public class CartServlet extends HttpServlet {

   
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
        
        String email = (String) request.getSession().getAttribute("userEmail");
        String itemNo = request.getParameter("productNumber");
        List productList = (List) request.getSession().getAttribute("productList");
        for (Object item : productList) {
            Product prod = (Product) item;
            if (String.valueOf(prod.getItemNo()).equals(itemNo)) {
                request.setAttribute("product", prod);
                request.getRequestDispatcher("/Cart.jsp").forward(request, response);
            }
        }
        
        response.sendRedirect("/CartBufferServlet");
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
        
        String action = request.getParameter("submit");
        String email = (String) request.getSession().getAttribute("userEmail");
        String itemNum = request.getParameter("productNumber");
        String itemCount = request.getParameter("qty");
        
        switch (action) {
            case "addtocart":
                ProductContainer productCart = (ProductContainer) request.getSession().getAttribute("productList");
                for (Product item : productCart.getProductArray()) {
                    Product prod = (Product) item;
                    if (String.valueOf(prod.getItemNo()).equals(itemNum)) {
                        prod.setItemCount(Integer.valueOf(itemCount));
                        XMLManager.addProductToCart(email, prod);
                    }
                }
                break;
            case "deletefromcart":
                XMLManager.removeProductFromCart(email, itemNum);
                break;
            case "Cancel":
                
                break;
            default:
                
                break;
            
        }
        response.sendRedirect("CartBufferServlet");
        
    }

}
