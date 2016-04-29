/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import source.DBManager;
import source.Product;
import source.ProductContainer;

/**
 * The ModfiyProduct servlet class communicates with the data base to handle
 * product inquires from the user interface.
 *
 * @author jacobveal
 */
@MultipartConfig
public class ProductServlet extends HttpServlet {

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

        System.out.println(itemNo);

        switch (action) {
            case "details":
                ProductContainer productCart = (ProductContainer) request.getSession().getAttribute("productList");

                for (Product item : productCart.getProductArray()) {
                    Product product = (Product) item;
                    if (String.valueOf(product.getItemNo()).equals(itemNo)) {

                        //File image = new File(product.getImageUrl());
                        //byte[] imageBytes = Files.readAllBytes(image.toPath());
                        // response.setContentLength(imageBytes.length);
                        //response.getOutputStream().write(imageBytes);
                        //request.setAttribute("image", image.getName());
                        //System.out.println(image.getName());
                        request.getSession().setAttribute("product", product);
                        request.getRequestDispatcher("/ProductDetails.jsp").forward(request, response);
                    }
                }

                break;
            default:
                System.out.println("No action taken");
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

        String email = (String) request.getSession().getAttribute("userEmail");

        ArrayList<String> values = parseRequest(request, response);

        String action = values.get(values.size() - 1);

        //determines which type of database query execution to perform
        switch (action) {
            case "Add":
                System.out.println(action);
                Product product = new Product(values.get(0), Integer.valueOf(values.get(1)), Double.valueOf(values.get(2)), values.get(4), values.get(3));

                product.setImageUrl(values.get(5));

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
                DBManager.deleteEntry("item", values.get(0), "Item_No");
                //DBManager.deleteEntry("itemaddedby", itemNum, "Item_No");
                DBManager.closeConnection();
                break;
            case "Modify":
                System.out.println(action);
                DBManager.initializeConnection();
                String itemNo = values.get(0);
                DBManager.updateEntry("item", "Item_No", itemNo, "Item_No", values.remove(0));
                DBManager.updateEntry("item", "Item_No", itemNo, "Item_Name", values.remove(0));
                DBManager.updateEntry("item", "Item_No", itemNo, "Item_Cost", values.remove(0));
                DBManager.updateEntry("item", "Item_No", itemNo, "Item_Qty", values.remove(0));
                DBManager.updateEntry("item", "Item_No", itemNo, "Item_Desc", values.remove(0));

                if (!values.isEmpty()) {
                    DBManager.updateEntry("item", "Item_No", itemNo, "Image_Url", values.remove(0));
                }

                DBManager.closeConnection();
                break;
            case "Return":
                String itemNum = values.get(0);
                String poNum = (String) request.getSession().getAttribute("returnPONum");
                Product item = (Product) request.getSession().getAttribute("product");
                ArrayList<String> array = new ArrayList<>();
                array.add(poNum);
                array.add(itemNum);
                array.add(item.getDeliveryDate());
                array.add(values.get(5));

                DBManager.initializeConnection();
                DBManager.insertEntry("returned_items", array);
                DBManager.closeConnection();

                break;

        }
        response.sendRedirect("ManagerServlet");
    }

    private ArrayList<String> parseRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ArrayList<String> values = new ArrayList<>();

        FileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            // Parse the request to get file items.
            List<FileItem> fileItems = upload.parseRequest(request);

            // Process the uploaded file items
            Iterator i = fileItems.iterator();

            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();

                if (fi.isFormField()) {
                    values.add(fi.getString());
                    System.out.println("Parse Request: " + fi.getString());

                } else {
                    // Get the uploaded file parameters
                    ServletContext servlet = request.getServletContext();
                    File uploadDir = new File(servlet.getRealPath("/images/").toString());
                    File temp = File.createTempFile("img", ".jpg", uploadDir);
                    values.add(temp.getName());
                    fi.write(temp);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }

        return values;

    }

}
