import Auth.Authentication;
import Data.Database;
import ServerMessages.ServerErrorMessage;
import ServerMessages.ServerSuccessMessages;
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
        return authentication.login(email,password);
    }

    public static boolean register(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(ServerCostants.enterEmailHint);
        String email = scanner.nextLine();
        System.out.println(ServerCostants.userNameHint);
        String userName = scanner.nextLine();
        System.out.println(ServerCostants.enterPasswordHint);
        String password = scanner.nextLine();
        Authentication authentication = new Authentication();
        return authentication.register(userName, email, password);
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
            case 5:
                startServer();
                break;
        }
    }


    public static void startServer(){
        Scanner scanner = new Scanner(System.in);
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
                    System.out.println(ServerSuccessMessages.goodBye);
                    return;
                default:
                    System.out.println(ServerErrorMessage.menuChoiceError);
            }
        }
    }

    public static void main(String[] args) {
        Database.initDatabase();
        startServer();
    }
}


