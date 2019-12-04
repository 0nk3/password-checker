import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Validity validity = new Validity();
        Scanner input = new Scanner(System.in);
        String password ;

        System.out.println("Please enter a password : ");
        password = input.nextLine();


        validity.passwordIsValid(password);
        System.out.println("*****************************************************");
        validity.passwordIsOk(password);

        System.out.println();
    }
}

