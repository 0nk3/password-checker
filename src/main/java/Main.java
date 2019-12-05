import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        final Logger logger = LogManager.getLogger(Main.class.getName());

        Validity validity = new Validity();
        Scanner input = new Scanner(System.in);
        String password ;

        System.out.println("Please enter a password : ");
        password = input.nextLine();
        try{
            validity.passwordIsValid(password);

        }catch(Exception e){
            logger.error(e.getMessage());
        }
        finally {
            System.out.println("*****************************************************");
        }

        validity.passwordIsOk(password);
    }
}

