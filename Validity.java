/* ******************************************************** *
 * @author : Ndumiso Onke Fanti                             *
 * Description : PasswordIsValid and PasswordISOk Methods   *
 * ******************************************************** */

public class Validity extends  PasswordChecker{

    public void passwordIsValid(String password){

        if(!passwordExist(password)){
            System.out.println("1. password should exist");
        }
        if(!passwordLength(password)){
            System.out.println("2. password should be longer than than 8 characters");
        }
        if(!checkLowerCaseCharacter(password)){
            System.out.println("3. password should have at least one lowercase letter");
        }
        if(!checkUpperCaseCharacter(password)){
            System.out.println("4. password should have at least one uppercase letter");
        }
        if(!checkNumber(password)){
            System.out.println("5. password should at least have one digit");
        }
        if(!checkSpecialCharacter(password)){
            System.out.println("6. password should have at least one special character");
        }
        else {
            System.out.println("Password Valid");
        }
    }

    private static final int minimum = 3;   // for the function to return true, a minimum of 3 conditions should be passed

    private static int passedConditionsCounter = 0;  // Counter to keep track of how many conditions are passsed

    public boolean passwordIsOk(String password){
        if(passwordExist(password)){
            passedConditionsCounter++;
        }
        if(passwordLength(password)){
            passedConditionsCounter++;
        }
        if(checkLowerCaseCharacter(password)){
            passedConditionsCounter++;
        }
        if(checkUpperCaseCharacter(password)){
            passedConditionsCounter++;
        }
        if(checkNumber(password)){
            passedConditionsCounter++;
        }
        if(checkSpecialCharacter(password)){
            passedConditionsCounter++;
        }

        return(passedConditionsCounter >= 3);
    }
}
