import Auth.Authentication;
import Data.Database;
import ServerMessages.ServerErrorMessage;
import constants.ServerCostants;
import java.util.Scanner;

public class BankAccountServer{
    public static boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ServerCostants.enterEmailHint);
        String email = scanner.nextLine();
        System.out.println(ServerCostants.enterPasswordHint);
        String password = scanner.nextLine();
        Authentication authentication = new Authentication();
        boolean isValidToLogin = authentication.login(email,password);
        return isValidToLogin;
    }

    public static void serverServices(){
        Scanner scanner = new Scanner(System.in);
        Menus.loginRegisterMenu();
        int menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1: // show balance
            case 2: // withdraw
            case 3: // deposit
            case 4: // print information
            case 5: // navigation back
            case 6: // exist
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database.initDatabase();
        while (true) {
            Menus.loginRegisterMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    if (login()){
                        serverServices();
                    }
                    break;
                case 2:

                    break;
                case 3:
                    return;
                default:
                    System.out.println(ServerErrorMessage.menuChoiceError);
            }
        }
    }
}


