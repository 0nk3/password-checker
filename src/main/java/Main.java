import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        //Creating a Logger Object to log into a file
        final Logger logger = LogManager.getLogger(Main.class.getName());

        // Validity object to access the method that checks if a password is ok or not
        Validity validity = new Validity();

        //Scanner object to allows read input from keyboard
        Scanner input = new Scanner(System.in);

        String password ;
        // get user input as password for checking its validity
        System.out.println("Please enter a password : ");
        password = input.nextLine();

        try{
            validity.passwordIsValid(password);
            System.out.println(validity.passwordIsOk(password) ? "User password is ok" : "User password is not ok" );

        }catch(Exception e){
            logger.log(Level.DEBUG, e.getMessage());
        }
        finally {
            System.out.println("===================> DONE <===========================");
        }
        //validity.passwordIsOk(password);
    }
}

