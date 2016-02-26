package source;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobveal
 */
public class Users{
    
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
   
    
    public Users(  String fN, String lN, String email,String pw, String bM, 
            String bD, String bY , String gender , String number, String pC ){
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
        
        this.validate();
    }
    
    public Users(String email){
        this.email = email;
    }
    
    public String getEmail(){return this.email;}
    
    private void setAccount(){verified = true;}
    
    public void printUserAccountInfo(){
        System.out.println(this.firstName + "\n" + 
                this.lastName + "\n" + this.email + "\n" +
                "\n" + this.password + "\n" + this.birthMonth
                + "\n" + this.birthDay + "\n" +this.birthYear + "\n" + this.gender
                 + "\n" + this.phoneNumber+ "\n" + this.pinCode );
    }
    
   private void validate(){
       
       this.parseStringForNumbers(this.phoneNumber);
       this.parseStringForNumbers(this.phoneNumber);
       this.parseStringForNumbers(this.pinCode);
       
       if(verified){
            System.out.println("passed number validation");
       }
       else{
           System.out.println("failed number validation");
       }
   }

   private void encrypPassword(){};
   
   private void parseStringForNumbers(String obj){
       
       try{
            double number = Double.parseDouble(obj);
            verified = true;
       }catch(NumberFormatException e){
           System.out.println("Number could not be converted to a double");
           verified = false;
       }
       
       
      
   }
    
}
