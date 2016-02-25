package source;

import java.io.Serializable;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobveal
 */
@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class Users implements Serializable{
    
    private String email = null;
    private String password = null;
    private String firstName = null;
    private String lastName = null;
    private String birthMonth = null;
    private String birthDay = null;
    private String birthYear = null;
    private String pinCode = null;
    private String phoneNumber = null;
    private String gender = null;
    private Boolean verified = false;
   
    
    public Users(String email, String pw, String fN, String lN, String bM, 
            String bD, String bY, String pC, String number, String gender){
        this.email = email;
        this.birthDay = bD;
        this.birthMonth = bM;
        this.birthYear = bY;
        this.firstName = fN;
        this.lastName = lN;
        this.password = pw;
        this.pinCode = pC;
        this.phoneNumber = number;
        this.gender = gender;
    }
    
    public Users(String email){
        this.email = email;
    }
    
    public String getEmail(){return this.email;}
    
    private void setAccount(){verified = true;}
    
    public void printUserAccountInfo(){
        System.out.println(this.email + "\n" + this.firstName + "\n" + 
                this.lastName + "\n" + this.birthMonth + "\n" + this.birthMonth
                + "\n" + this.birthDay + "\n" +this.birthYear + "\n" + this.pinCode
                + "\n" + this.phoneNumber + "\n" + this.gender);
    }
    

    @Override
    public void processAction(ActionEvent event) throws AbortProcessingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("Test");
    
    }
    
}
