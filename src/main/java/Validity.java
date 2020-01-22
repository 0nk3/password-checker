/* ******************************************************** *
 * @author : Ndumiso Onke Fanti                             *
 * Description : PasswordIsValid and PasswordISOk Methods   *
 * ******************************************************** */

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Validity extends PasswordChecker {
    private static final Logger logger = LogManager.getLogger(PasswordChecker.class.getName());

    Validity() {
        System.out.println("********************** Password Checker ********************************************************\n");
    }

    /* ********************************************************************* *
     * Since the maximum number of conditions that must be passed is 6,      *
     * I will assume 6 as conditions passed, then reduce                     *
     * it by 1 everyvtime a condition is FAILED.                             *
     * ********************************************************************* */
    boolean passwordIsValid(String password) {

        int passedConditions = 6;

        if (!passwordExist(password)) {
            logger.log(Level.ERROR, "password should exist");
            passedConditions--;
        }
        if (!passwordLength(password)) {
            logger.log(Level.ERROR, "password should be longer than than 8 characters");
            passedConditions--;
        }
        if (!checkLowerCaseCharacter(password)) {
            logger.log(Level.ERROR, "password should have at least one lowercase letter");
            passedConditions--;
        }
        if (!checkUpperCaseCharacter(password)) {
            logger.log(Level.ERROR, "password should have at least one uppercase letter");
            passedConditions--;
        }
        if (!checkNumber(password)) {
            logger.log(Level.ERROR, "password should at least have one digit");
            passedConditions--;
        }
        if (!checkSpecialCharacter(password)) {
            logger.log(Level.ERROR,"password should have at least one special character");
            passedConditions--;
        }
        if(passedConditions<6){
            logger.log(Level.DEBUG, "password is not ok");
        }
        else {
            logger.log(Level.DEBUG, "password is ok");

        }
        // the value of passed conditions is expected to be 6  if non of the conditions failed.
        return (passedConditions == 6);
    }
    // for the function to return true, a minimum of 3 conditions should be passed
    private static final int minimum = 3;

    // Counter to keep track of how many conditions are passed
    public static int passedConditionsCounter = 0;

    boolean passwordIsOk(String password) {
        if (passwordExist(password)) {
            passedConditionsCounter++;
        }
        if (passwordLength(password)) {
            passedConditionsCounter++;
        }
        if (checkLowerCaseCharacter(password)) {
            passedConditionsCounter++;
        }
        if (checkUpperCaseCharacter(password)) {
            passedConditionsCounter++;
        }
        if (checkNumber(password)) {
            passedConditionsCounter++;
        }
        if (checkSpecialCharacter(password)) {
            passedConditionsCounter++;
        }
    return (passedConditionsCounter >minimum);
    }

}
