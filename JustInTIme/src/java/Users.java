/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobveal
 */
public class Users {
    
    private String email = null;
    private String password = null;
    private String firstName = null;
    private String lastName = null;
    private String birthMonth = null;
    private String birthDay = null;
    private String birthYear = null;
    private String pinCode = null;
    private Boolean verified = false;
    
    public Users(String email, String pw, String fN, String lN, String bM, 
            String bD, String bY, String pC){
        this.email = email;
        this.birthDay = bD;
        this.birthMonth = bM;
        this.birthYear = bY;
        this.firstName = fN;
        this.lastName = lN;
        this.password = pw;
        this.pinCode = pC;
     
    }
    
    public Users(String email){
        this.email = email;
    }
    
    public String getEmail(){return this.email;}
    
    private void setAccount(){verified = true;}
    
}
