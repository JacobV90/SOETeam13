package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.XMLManager;
import source.DBManager;

/**
 * The EmailVerified classes get method is called when the user clicks the sent
 * email link. Once ran, the class will look for the users email in the in
 * active database and if found will push their information to the database;
 *
 *
 * @author jacobveal
 */
public class EmailVerified extends HttpServlet {

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

        DBManager.initializeConnection();

        // Grab user entered pincode and compare to database
        ArrayList<String> code = DBManager.selectEntry("user_code", "Code", userArray.get(9));

        if (!code.get(1).equals("1")) {

            ArrayList<String> codeArr = new ArrayList<>();

            String role = getRole(userArray.get(9));
            codeArr.add(userArray.get(0));
            codeArr.add("0");
            codeArr.add(role);

            // activate code
            DBManager.insertEntry("auth", codeArr);

            // push user to database
            if (DBManager.insertEntry("user", userArray)) {
                System.out.println("User pushed to data base");

                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } else {
                System.out.println("User push to database failed");
            }

        } else {
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
            System.out.println("Code already used");
        }

    }

    private String getRole(String pin) {
        String role = null;
        StringBuilder sb = new StringBuilder();

        sb.append(pin);

        switch (sb.charAt(0)) {
            case 'a':
                role = "Administrator";
                break;
            case 'm':
                role = "Manager";
                break;
            case 'u':
                role = "User";
                break;
            default:
                break;
        }
        System.out.println(role);
        return role;
    }
}
