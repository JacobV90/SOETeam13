package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.Email;
import source.PasswordStorage;
import source.Users;
import source.XMLManager;

/**
 *
 * @author jacobveal
 */
public class RegisterServlet extends HttpServlet {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/justintime?autoReconnect=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "Hondas2k";

    private final ArrayList<String> userData;

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public RegisterServlet() {
        this.userData = new ArrayList<>();
    }

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
            out.println("<title>Servlet + RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JITServlet at " + request.getContextPath() + "</h1>");
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

        final String queryScript = "INSERT INTO user (Email, FirstName, LastName, Password,"
                + "BirthMonth, BirthDay, BirthYear, Gender, Phone, Code)"
                + " values (?,?,?,?,?,?,?,?,?,?)";

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthMonth = request.getParameter("BirthMonth");
        String birthDay = request.getParameter("BirthDay");
        String birthYear = request.getParameter("BirthYear");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phone");
        String pinCode = request.getParameter("pin");

        Users user = new Users(firstName, lastName, email, password,
                birthMonth, birthDay, birthYear, gender, phoneNumber,
                pinCode);

        user.printUserAccountInfo();

        if (user.validate()) {
            System.out.println("User account data validated");
            System.out.println("Waiting for email Verifcation....");

            XMLManager.addUser(user.getUserDataArray());
            
            System.out.println("Pushing user to database....");

            try {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // Execute SQL query
                stmt = conn.prepareStatement(queryScript);

                //Extract data from result set
                int i = 1;
                ArrayList<String> userArray = user.getUserDataArray();
                while (i <= userArray.size()) {

                    stmt.setString(i, userArray.get(i - 1));
                    ++i;
                }
                stmt.executeUpdate();

                // Clean-up environment
                stmt.close();
                conn.close();

            } catch (SQLException se) {
            } catch (ClassNotFoundException ße) {
            } finally {// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                }//end finally try
            } //end try
            try {
                Email.sendEmail(email);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PasswordStorage.CannotPerformOperationException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()
                    + "/signupVerify.jsp"));

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
