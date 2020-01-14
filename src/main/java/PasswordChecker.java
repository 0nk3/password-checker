/* ******************************************************** *
 * @author : Ndumiso Onke Fanti                             *
 * Description : Given a particular password, the following *
 * methods check if the password meets the 6 requirements if*
 * if one condition is not met,the password is not accepted *
 *  1. Password must exist                                  *
 *  2. Password length must be greater than 8               *
 *  3. Password contains at least one upper case character  *
 *  4. Password contains at least one lower case character  *
 *  5. Password must contain at least one numeric character *
 *  6. Password must contain at least one special character *
 * ******************************************************** */
public class PasswordChecker {

    /* ************************************************************** *
     * To solve this problem, Im gonna rely on ASCII                  *
     * Where by each character has a unique number that represent it  *
     * There is an accompanying ASCII table for reference, as image   *
     * ************************************************************** */

    // 1. check if password exists
    public static boolean passwordExist(String password) {
        // if there is an input(no matter what kind), the function should return true
        return password.length() > 0;
    }

    // 2. check if password length greater than 8 characters
    public static boolean passwordLength(String password) {
        // if the input(even spaces) has a number of characters greater than 8, this should return true
        return password.length() > 8;
    }

    /*
     * 3. check if password has at least one lower case character
     */
    public static boolean checkLowerCaseCharacter(String password) {

        int countLowerCase = 0;                 // counts number of lower case characters

        for (int i = 0; i < password.length(); i++) {
            // In ASCII, lower case characters are between 97 and 122, inclusive
            if (((byte) password.charAt(i) >= 97) && ((byte) password.charAt(i) <= 122)) {
                countLowerCase++;
            }
        }
        //if this returns true, there is more than one Lower Case character in the password given by the user
        return (countLowerCase > 0);
    }

    /*
     * 4. check if the password contains at least one upper case character
     */
    public static boolean checkUpperCaseCharacter(String password) {
        int countUpperCase = 0;       // counts number of upper case characters
        for (int i = 0; i < password.length(); i++) {
            // In ASCII, upper case characters are between 90 and 65, inclusive
            if (((byte) password.charAt(i) >= 65) && ((byte) password.charAt(i) <= 90)) {
                countUpperCase++;
            }
        }
        // if this returns true, there is more than one Upper Case case character in th password given by the user
        return (countUpperCase > 0);
    }

    // 5. check if the password contains at least one numeric character
    public static boolean checkNumber(String password) {
        int countNumbers = 0;
        for (int i = 0; i < password.length(); i++) {
            if (((byte) password.charAt(i) >= 48) && (password.charAt(i) <= 57)) {
                countNumbers++;
            }
        }
        return (countNumbers > 0);
    }

    // 6.  check if the password contains at least one special character
    public static boolean checkSpecialCharacter(String password) {

        int countSpecialCharacter = 0;

        for (int i = 0; i < password.length(); i++) {
            if (((byte) password.charAt(i) >= 32) && (password.charAt(i) <= 47)) {
                countSpecialCharacter++;
            } else if ((byte) password.charAt(i) >= 58 && (password.charAt(i) <= 64)) {
                countSpecialCharacter++;
            } else if (((byte) password.charAt(i) >= 91) && (password.charAt(i) <= 96)) {
                countSpecialCharacter++;
            } else if (((byte) password.charAt(i) >= 123) && (password.charAt(i) <= 126)) {
                countSpecialCharacter++;
            }
        }
        return (countSpecialCharacter > 0);
    }

}
