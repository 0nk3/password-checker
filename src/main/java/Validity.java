/* ******************************************************** *
 * @author : Ndumiso Onke Fanti                             *
 * Description : PasswordIsValid and PasswordISOk Methods   *
 * ******************************************************** */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Validity extends  PasswordChecker{
    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());

    public Validity() {
        System.out.println("********************** Password Checker **********************\n");
    }

    /* ********************************************************************* *
     * Since the maximum number of conditions that must be passed is 6,      *
     * I will assume 6 as conditions passed, then reduce                     *
     * it by 1 everyvtime a condition is FAILED.                             *
     * ********************************************************************* */
    public boolean passwordIsValid(String password){

        int passedConditions = 6 ;

        if(!passwordExist(password)){
            logger.error("password should exist");
            passedConditions --;
        }
        if(!passwordLength(password)){
            logger.error("password should be longer than than 8 characters");
            passedConditions--;
        }
        if(!checkLowerCaseCharacter(password)){
            logger.error("password should have at least one lowercase letter");
            passedConditions--;
        }
        if(!checkUpperCaseCharacter(password)){
            logger.error("password should have at least one uppercase letter");
            passedConditions --;
        }
        if(!checkNumber(password)){
            logger.error("password should at least have one digit");
            passedConditions--;
        }
        if(!checkSpecialCharacter(password)){
            logger.error("password should have at least one special character");
            passedConditions--;
        }
        else {
            logger.info("password is valid");
        }
     return (passedConditions >6);
    }

    private static final int minimum = 3;   // for the function to return true, a minimum of 3 conditions should be passed

    private static int passedConditionsCounter = 0;  // Counter to keep track of how many conditions are passed

    public void passwordIsOk(String password){
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
        if(passedConditionsCounter >= minimum){
            logger.debug("User password is ok");
        }else {
            logger.debug("User password is not ok");

        }
    }

}
