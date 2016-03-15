package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlet.EmailVerified.DB_URL;
import source.XMLManager;

/**
 * The EmailVerified classes get method is called when the user clicks the sent
 * email link. Once ran, the class will look for the users email in the in
 * active database and if found will push their information to the database;
 *
 *
 * @author jacobveal
 */
public class EmailVerified extends HttpServlet {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/justintime?autoReconnect=true&useSSL=false"
            + "&allowMultiQueries=true";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Hondas2k";

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

        // Grab email from user and display it to console
        String userEmail = request.getParameter("email");
        System.out.println("    EmailVerifiedServlet:" + userEmail);

        // Find user in inActiveUsers database
        ArrayList<String> userArray = XMLManager.getUser(userEmail);

        // SQL query to check pin code validation and available 
        final String pinCodeQuery = "SELECT * FROM user_code;";

        // SQL query to mark pin code as active
        final String pinCodeActive = "update user_code set isUsed = ? where Code = ?;";

        // SQL query to push the user to the data base
        final String queryScript = "INSERT INTO user (Email, FirstName, LastName, Password,"
                + "BirthMonth, BirthDay, BirthYear, Gender, Phone, Code, Role)"
                + " values (?,?,?,?,?,?,?,?,?,?,?)";

        // Connection variables
        Connection conn = null;
        PreparedStatement stmt = null;
        PreparedStatement pinStmt = null;
        PreparedStatement pinStmt2 = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare run execute statments
            stmt = conn.prepareStatement(queryScript);
            pinStmt = conn.prepareStatement(pinCodeQuery);
            pinStmt2 = conn.prepareStatement(pinCodeActive);

            // Find pin code in database
            String pinCode = null;
            ResultSet rs = pinStmt.executeQuery();
            System.out.println("pin code query executed");

            // Check to see if pin code record exists
            if (rs.first()) {

                pinCode = rs.getString("Code");
                System.out.println("Got Pin Code");

                //Set pin code active parameters and execute
                pinStmt2.setInt(1, 1);
                pinStmt2.setString(2, pinCode);
                pinStmt2.executeUpdate();

                System.out.println("pin code active query executed");

            } else {
                System.out.println("Pin code record not found");
            }

            //push user to database
            if (pinCode.equals(userArray.get(9)) && userArray.size() > 1) {

                //Extract data from result set
                int i = 1;
                while (i <= userArray.size()) {

                    stmt.setString(i, userArray.get(i - 1));
                    ++i;
                }
            } else {
                System.out.println("Invalide pin code entered");
            }

            // Execute sql query
            stmt.executeUpdate();
            System.out.println("User successfully pushed to data base");

            // Clean-up environment
            pinStmt2.close();
            pinStmt.close();
            stmt.close();
            conn.close();

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (SQLException | ClassNotFoundException se) {

            System.out.println("Database issue");

            request.getRequestDispatcher("/signup.jsp").forward(request, response);

        } finally {
            try {
                // nothing we can do
                pinStmt2.close();
                pinStmt.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmailVerified.class.getName()).log(Level.SEVERE, null, ex);
            }

        } //end try

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
        processRequest(request, response);
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
