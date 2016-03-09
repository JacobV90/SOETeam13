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
    
   
    
        
        public static void sendEmail(String email){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        String username = "JITInventories";
        String password = "jitjitjit";
        String fromEmail = username + "@gmail.com";
        String toEamil = email;
        
        String url = "http://localhost:8080/JustInTime/EmailVerified/";
        String subject = "Welcome to Just In Time Inventories";
        String txtMessage = "Thank you for registering with us. Now you can get"
                + " your products Just IN Time! \n Click link to verify your"
                + "email address " + url;
        
       Session session = Session.getInstance(props,new Authenticator()
            //Session session = Session.getInstance(props, new SendMail(username, password));
       {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username, password);
            }
        });
        
        try 
        {
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEamil));
            message.setSubject(subject);
            message.setText(txtMessage);
            
            

            Transport.send(message);
            System.out.println("Email successfully sent");
            //JOptionPane.showMessageDialog(null,"Email sended!");
            
        } catch (MessagingException e) 
        {
            //JOptionPane.showMessageDialog(null,"Something happened!");
            System.out.println("Email sending failed" +"\n" + e);

            throw new RuntimeException(e);
        }
    }
        
    
}

