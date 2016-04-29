package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import source.Email;
import source.Users;
import source.XMLManager;

/**
 *
 * The RegisterServlet class takes information entered on the signup.jsp page
 * passes it to the user object to validate data and calls the Email's class send
 * method.
 * 
 * @author jacobveal
 */
public class RegisterServlet extends HttpServlet {

    public static String FilePath;
  
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

        if (user.validate()) {
            System.out.println("User account data validated");

            XMLManager.addUser(user.getUserDataArray());

            try {
                Email.sendRegEmail(email);
            } catch (MalformedURLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.getRequestDispatcher("/signupVerify.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/signup.jsp").forward(request, response);

        }

    }

}
