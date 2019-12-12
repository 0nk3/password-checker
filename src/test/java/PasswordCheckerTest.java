import org.junit.jupiter.api.Test;

/* ******************************************************** *
 * @author : Ndumiso Onke Fanti                             *
 * Description : Test Cases for the password methods        *
 * "onke10222!" and its various combinations of letters will*
 *  be used as the test password                            *
 * ******************************************************** */
public class PasswordCheckerTest {

    // PasswordChecker passwordCheckerObject = new PasswordChecker();
    @Test
    void testExistence() {
        assert PasswordChecker.passwordExist("onke12345") : " Test Case Should PASS"; // test should pass because there exist a password entered with a certain length > 0
        assert PasswordChecker.passwordExist(" ") : " Test Case Should PASS";         //test should pass
        //assert PasswordChecker.passwordExist("") : " Test Case Should FAIL";          // test should FAIL because there exists no password enter with a certain length
    }

    @Test
    void testLength() {
        assert PasswordChecker.passwordLength("onke12345") : "Test Case Should PASS";    // test should pass because password length is greater than 8
        //assert PasswordChecker.passwordLength("onke") : "Test Case Should FAIL";      // test should FAIL because length of the password is less than 8
    }

    @Test
    void testLowerCaseChars() {
        assert PasswordChecker.checkLowerCaseCharacter("onke12345") : "Test Case should PASS";
//        assert PasswordChecker.checkLowerCaseCharacter("ONKE12345") : "Test Case should FAIL";    // test should FAIL because there is not a single lower case character
    }

    @Test
    void UpperCaseChars() {
        assert PasswordChecker.checkUpperCaseCharacter("oNke12345") : "Test Case should PASS";
        //  assert PasswordChecker.checkUpperCaseCharacter("onke12345"): "Test Case should FAIL because there is no upper case character";
    }

    @Test
    void testNumbers() {
        assert PasswordChecker.checkNumber("onke12345") : "Test Case should PASS";
        //assert PasswordChecker.checkNumber("onkeonke") : "Test Case should FAIL becaause there is no numeric character";

    }

    /* ********************************************************************** *
     * There are a lot of case that need to be tested for this method because  *
     * of how the special characters ar distributed, also looking the ranges   *
     * in which they lie by looking at the checkSpecialCharacter Method        *
     * I'll be checking the lower bound, upper bound and the 2 random chars    *
     * that lie in between a specified range in the method. The char will be   *
     * inserted any where in the string password                               *
     * *********************************************************************** */
    @Test
    void testSpecialCharacter() {
        // First part of the if statement in the method
        assert PasswordChecker.checkSpecialCharacter("onke10222!") : "Test should PASS";
        assert PasswordChecker.checkSpecialCharacter("onke10222 ") : "Test should PASS";   // check if detects space as a special character(lowe bound)
        assert PasswordChecker.checkSpecialCharacter("onke10222'") : "Test should PASS";
        assert PasswordChecker.checkSpecialCharacter("onke10222.") : "Test should PASS";   // check if detects a dot as a special char(upper bound)
        assert PasswordChecker.checkSpecialCharacter("onke10222/") : "Test should PASS";
        // Second part
        assert PasswordChecker.checkSpecialCharacter("onke10222:") : "Test should PASS";  // lower bound --> :
        assert PasswordChecker.checkSpecialCharacter("onke;10222") : "Test should PASS";  // upper bound --> ;
        assert PasswordChecker.checkSpecialCharacter("onke10222@") : "Test should PASS";
        assert PasswordChecker.checkSpecialCharacter("onke10222=") : "Test should PASS";
        // 3rd Part
        assert PasswordChecker.checkSpecialCharacter("onke102[22") : "Test should PASS";  // lower bound --> [
        assert PasswordChecker.checkSpecialCharacter("onke1_0222") : "Test should PASS";  // upper bound --> _
        assert PasswordChecker.checkSpecialCharacter("onke102^22") : "Test should PASS";
        assert PasswordChecker.checkSpecialCharacter("onke102'22!") : "Test should PASS";
        // 4th Part
        assert PasswordChecker.checkSpecialCharacter("{onke10222") : "Test should PASS";  // lower bound --> {
        assert PasswordChecker.checkSpecialCharacter("on~ke10222") : "Test should PASS";   // upper bound --> ~
        assert PasswordChecker.checkSpecialCharacter("onk|e10222") : "Test should PASS";
        assert PasswordChecker.checkSpecialCharacter("onke1022}2") : "Test should PASS";

        //assert PasswordChecker.checkSpecialCharacter("onke10222") : "Test should FAIL, there is no special character";
    }
}




