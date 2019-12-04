/* ******************************************************** *
 * @author : Ndumiso Onke Fanti                             *
 * Description : PasswordIsValid and PasswordISOk Methods   *
 * ******************************************************** */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Validity extends  PasswordChecker{
    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());

    public Validity() {
        logger.info("********************** Password Checker **********************\n");
    }


    public void passwordIsValid(String password){

        if(!passwordExist(password)){
            logger.error("password should exist");
        }
        if(!passwordLength(password)){
            logger.error("password should be longer than than 8 characters");
        }
        if(!checkLowerCaseCharacter(password)){
            logger.error("password should have at least one lowercase letter");
        }
        if(!checkUpperCaseCharacter(password)){
            logger.error("password should have at least one uppercase letter");
        }
        if(!checkNumber(password)){
            logger.error("password should at least have one digit");
        }
        if(!checkSpecialCharacter(password)){
            logger.error("password should have at least one special character");
        }
        else {
            logger.info("password should exist");
        }
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

        }}

}
