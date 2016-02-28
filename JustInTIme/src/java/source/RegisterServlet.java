package source;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.activation.DataSource;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    private ArrayList<String> userData = new ArrayList<String>();
    private int numOfUsers = 0;
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

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
            out.println("<title>Servlet JITServlet</title>");
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
        //processRequest(request, response);

        System.out.println("Submit Test");

        String queryScript = "INSERT INTO user (Email, FirstName, LastName, Password,"
                + "BirthMonth, BirthDay, BirthYear, Gender, Phone, Code)"
                + " values (?,?,?,?,?,?,?,?,?,?)";
        
        String sqlScript = "INSERT INTO user (Email) Values (?)";
                

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String birthMonth = request.getParameter("BirthMonth");
        String birthDay = request.getParameter("BirthDay");
        String birthYear = request.getParameter("BirthYear");
        String gender = request.getParameter("gender");
        String phoneNumber = request.getParameter("phone");
        String pinCode = request.getParameter("pin");

     
        userData.add(email);
        userData.add(firstName);
        userData.add(lastName);
        userData.add(password);
        userData.add(birthMonth);
        userData.add(birthDay);
        userData.add(birthYear);
        userData.add(gender);
        userData.add(phoneNumber);
        userData.add(pinCode);
        
        Users user = new Users(firstName, lastName, email, password,
                birthMonth, birthDay, birthYear, gender, phoneNumber,
                pinCode);

        user.printUserAccountInfo();

        if (user.validate()) {
            System.out.println("User account data validated");
            System.out.println("Pushing user to database");
           
            
            try {
                // Register JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Open a connection
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

                // Execute SQL query
                stmt = conn.prepareStatement(queryScript);
                
                //stmt.setString(1, userData.remove(0));
                
                //Extract data from result set
                int i = 1;
                while(i <= userData.size())
                {
                    if(i<11){
                    stmt.setString(i, userData.get(i-1));
                    ++i;
                    }
                    
                }
                //execute query scnript
                //stmt.executeUpdate();
             
                rs = stmt.executeQuery("SELECT FirstName, LastName,"
                        + "Email, BirthMonth, BirthYear, BirthDay, Code,"
                        + "Phone, Gender, Password FROM user");
                
                while(rs.next()){
                  
                    String mail = rs.getString("Email");
                    String pw = rs.getString("Password");
                    String fname = rs.getString("FirstName");
                    String lname = rs.getString("LastName");
                    String birthM = rs.getString("BirthMonth");
                    String birthD = rs.getString("BirthDay");
                    String birthY = rs.getString("BirthYear");
                    String num = rs.getString("Phone");
                    String code = rs.getString("Code");
                    String gend = rs.getString("Gender");
                    
                    System.out.println("Hello from the data base: \n" + fname
                            + "\n "+ lname +"\n" + pw + "\n" + birthM + "-"+ birthD + "-"
                            + birthY + "\n" + num + "\n" + code + "\n" + gend);
                    
                }

                // Clean-up environment
                
                stmt.close();
                conn.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
            } finally {// nothing we can do
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            } //end try

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

    private class DBConnection {

        public DBConnection() {

        }

    }

}
