import Auth.Authentication;
import Data.Database;
import ServerMessages.ServerErrorMessage;
import ServerMessages.ServerSuccessMessages;
import constants.ServerCostants;
import java.util.Scanner;

public class BankAccountServer{

    public static Database database;

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


    public static  boolean register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ServerCostants.enterEmailHint);
        String email = scanner.nextLine();
        System.out.println(ServerCostants.userNameHint);
        String userName = scanner.nextLine();
        System.out.println(ServerCostants.enterPasswordHint);
        String password = scanner.nextLine();
        Authentication authentication = new Authentication();
       boolean isRegistered = authentication.register(userName, email, password);
        return isRegistered;
    }
    public static void serverServices(){
        Scanner scanner = new Scanner(System.in);
        Menus.serverServices();
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
                        System.out.println(ServerSuccessMessages.successLogin);
                        serverServices();
                    }
                    break;
                case 2:
                    if(register()) {
                        System.out.println(ServerSuccessMessages.successRegister);
                        serverServices();
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println(ServerErrorMessage.menuChoiceError);
            }
        }
    }
}


