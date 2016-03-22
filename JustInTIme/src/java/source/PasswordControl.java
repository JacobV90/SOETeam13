/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

import java.util.Arrays;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

/**
 *
 * @author jvtal
 */
public class PasswordControl {
    
    private static final int minPasswordLength = 6;
    private static final int maxPasswordLength = 16;
    private static final int numUpperCase = 1;
    private static final int numLowerCase = 1;
    private static final int numDigits = 1;
    
    public static boolean validatePass(String pw){
        
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

        RuleResult result = validator.validate(new PasswordData(pw));

        if (result.isValid()) {
            System.out.println("Password is valid");
            return true;
        } else {
            System.out.println("Invalid password:");
            for (String msg : validator.getMessages(result)) {

                System.out.println(msg);
            }
            return false;
        }
        
    }
    
}
