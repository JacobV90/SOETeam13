/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static source.RegisterServlet.DB_URL;
import static source.RegisterServlet.PASS;
import static source.RegisterServlet.USER;

/**
 *
 * @author jacobveal
 */
public class LoginServlet extends HttpServlet {

    Connection connection = null;
    Statement stmt = null;

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        
        
        System.out.println("Made it to login Servlet");

        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            //Grab email and passwords from database
            String query = "Select * FROM user WHERE Email = '"+email+"'"+
                      "AND Password = '"+password+"'";

            // Execute SQL query
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Boolean found = false;
            if(rs.first()){
                found = true;
                System.out.println("Found user");
                
                String firstName = null;
                String role = null;
                
                firstName = rs.getString("FirstName");
                role = rs.getString("Role");
                  
                System.out.println(firstName);
                System.out.println(role);
                
                request.setAttribute("name", firstName);
                request.setAttribute("role", role);
                
                request.getRequestDispatcher("homePage.jsp").forward(request, response);
            
            
                
            }
            else{
                System.out.println("User not found");
            }
            

            
            /*while (rs.next() || !found) {
                String em = rs.getString("Email");
                String pw = rs.getString("Password");

                if (em.equals(email) && pw.equals(password)) {
                    found = true;
                    System.out.println("\nFound user \n");
                }
               
            }*/

            // Clean-up environment
            stmt.close();
            connection.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {// nothing we can do
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        } //end try
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
