/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

/**
 *
 * @author jacobveal
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;
//import javax.swing.JOptionPane;

public class Email {

    private static String toEmail;
    private static final String USERNAME = "JITInventories";
    private static final String FROM_EMAIL = "JITInventories@gmail.com";
    private static final String PASSWORD = "jitjitjit";

    public static void sendEmail(String email) throws MalformedURLException{
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        toEmail = email;

        URL url = new URL("http://localhost:8080/JustInTime/EmailVerified?email=" + toEmail);
        String subject = "Welcome to Just In Time Inventories";
        String txtMessage = "Thank you for registering with us. Now you can get"
                + " your products Just IN Time! \n Click link to verify your"
                + "email address \n " + url.toString();

        Session session = Session.getInstance(props, new Authenticator() //Session session = Session.getInstance(props, new SendMail(username, password));
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(txtMessage);

            Transport.send(message);
            System.out.println("Email successfully sent");
            //JOptionPane.showMessageDialog(null,"Email sended!");

        } catch (MessagingException e) {
            //JOptionPane.showMessageDialog(null,"Something happened!");
            System.out.println("Email sending failed" + "\n" + e);

            throw new RuntimeException(e);
        }
    }

}
