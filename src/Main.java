import Auth.Authentication;
import Auth.User;
import ServerErrorMessage.ServerErrorMessage;


import java.util.Scanner;

public class Main {
    public static void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your email: ");
        String email = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        Authentication authentication = new Authentication();
        authentication.login(email,password);

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menus.loginRegisterMenu();
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    login();
                    break;
                case 2:
                    // regiter
                    break;
                case 3:
                    return;
                default:
                    System.out.println(ServerErrorMessage.menuChoiceError);
            }
        }
    }
}


