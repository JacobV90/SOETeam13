package source;

import java.util.ArrayList;
import java.util.Arrays;
import org.passay.LengthRule;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordData;
import org.passay.WhitespaceRule;

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

    private Boolean verified = false;
    private ArrayList<String> userData;

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String birthMonth;
    private String birthDay;
    private String birthYear;
    private String pinCode;
    private String phoneNumber;
    private String gender;
    private String role;
    private final int minPasswordLength = 6;
    private final int maxPasswordLength = 16;
    private final int numUpperCase = 1;
    private final int numLowerCase = 1;
    private final int numDigits = 1;

    public Users(String fN, String lN, String email, String pw, String bM,
            String bD, String bY, String gender, String number, String pC) {

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

    public void printUserAccountInfo() {
        System.out.println(this.firstName + "\n"
                + this.lastName + "\n" + this.email + "\n"
                + this.password + "\n" + this.birthMonth
                + "\n" + this.birthDay + "\n" + this.birthYear + "\n" + this.gender
                + "\n" + this.phoneNumber + "\n" + this.pinCode);
    }

    public boolean validate() {

        /*PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // length between 8 and 16 characters
                new LengthRule(minPasswordLength, maxPasswordLength),
                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, numUpperCase),
                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, numLowerCase),
                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, numDigits),
                // at least one symbol (special character)
                // no whitespace
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(this.password));*/
        
        Boolean result = PasswordControl.validatePass(this.password);

        // Check password validation
        if (result) {
            System.out.println("Password is valid...hashing password");

            // hash password
            this.password = BCrypt.hashpw(this.password, BCrypt.gensalt(10));

            System.out.println(this.password);
            verified = true;
        } else {
            System.out.println("Invalid password:");
            
            verified = false;
            return verified;
        }

        // Check pinCode validation
        StringBuilder sb = new StringBuilder();
        sb.append(pinCode);
        if (!(sb.charAt(0) == 'a' || sb.charAt(0) == 'm' || sb.charAt(0) == 'u')) {
            System.out.println("Not a valid pin code");
            return false;
        }

        // Check number validation
        this.parseStringForNumbers(phoneNumber);

        if (verified) {
            System.out.println("passed number validation");

            return true;
        } else {
            System.out.println("failed number validation");
            return false;
        }

    }

    public ArrayList<String> getUserDataArray() {

        userData = new ArrayList<>();

     

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
            userData.add(getRole(pinCode));

       
        return userData;

    }

   

    private String getRole(String pin) {
        StringBuilder sb = new StringBuilder();

        sb.append(pin);

        switch (sb.charAt(0)) {
            case 'a':
                this.role = "Administrator";
                break;
            case 'm':
                this.role = "Manager";
                break;
            case 'u':
                this.role = "User";
                break;
            default:
                break;
        }
        System.out.println(role);
        return role;
    }

    private boolean passwordValidation() {

        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // length between 8 and 16 characters
                new LengthRule(minPasswordLength, maxPasswordLength),
                // at least one upper-case character
                new CharacterRule(EnglishCharacterData.UpperCase, numUpperCase),
                // at least one lower-case character
                new CharacterRule(EnglishCharacterData.LowerCase, numLowerCase),
                // at least one digit character
                new CharacterRule(EnglishCharacterData.Digit, numDigits),
                // at least one symbol (special character)
                // no whitespace
                new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(this.password));

        if (result.isValid()) {
            System.out.println("Password is valid");
            return verified = true;
        } else {
            System.out.println("Invalid password:");
            for (String msg : validator.getMessages(result)) {

                System.out.println(msg);
            }
            verified = false;
            return verified;
        }
    }

    private void parseStringForNumbers(String obj) throws NumberFormatException {

        try {
            double number = Double.parseDouble(obj);
            verified = true;
        } catch (NumberFormatException e) {
            System.out.println("Number could not be converted to a double");
            verified = false;
        }
    }

}
