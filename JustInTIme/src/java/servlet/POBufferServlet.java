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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;
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

        String delivery = null;
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

                switch (item.getSize()) {
                    case "small":
                        item.setDeliveryTime(3);
                        break;
                    case "medium":
                        item.setDeliveryTime(5);
                        break;
                    case "large":
                        item.setDeliveryTime(7);
                        break;
                    default:
                        item.setDeliveryTime(5);
                }

                LocalDateTime currentTime = LocalDateTime.now();
                LocalDate date1 = currentTime.toLocalDate();

                //Calculate product delivery date
                LocalDate deliveryDate = date1.plusDays(item.getDeliveryTime());
                item.setDeliveryDate(deliveryDate.toString());

                System.out.println(String.valueOf(item.getDeliveryTime()));

                // Create Purchase Order Number and update PO Database table
                ArrayList<String> entryArray = new ArrayList<>();
                entryArray.add(poNum);
                entryArray.add(itemNum);
                entryArray.add(email);
                entryArray.add(String.valueOf(item.getTotalPrice()));
                entryArray.add(String.valueOf(item.getItemCount()));
                entryArray.add(date1.toString());
                entryArray.add(item.getDeliveryDate());
                DBManager.insertEntry("purchaseorder", entryArray);

                // Remove product from user's cart
                XMLManager.removeProductFromCart(email, itemNum);
                purchase.setPurchaseNumber(poNum);
                XMLManager.addPurchaseOrder(purchase);
                
                delivery= item.getDeliveryDate();

            }
        }
        DBManager.closeConnection();
        request.setAttribute("price", cart.getCartPrice());
        request.getSession().setAttribute("poNum", poNum);
        request.getSession().setAttribute("delivery", delivery);

        request.getRequestDispatcher("ConfirmPayment.jsp").forward(request,response);

    }


}
