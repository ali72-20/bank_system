import Auth.Authentication;
import Auth.User;
import BankControllers.BackAccount;
import BankControllers.CheckBankAccount;
import BankControllers.SavingBankAccount;
import Data.Database;
import ServerMessages.ServerErrorMessage;
import ServerMessages.ServerStrings;
import ServerMessages.ServerSuccessMessages;

import java.util.Scanner;

public class BankAccountServer {
    static User user;

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ServerStrings.enterEmailHint);
        String email = scanner.nextLine();
        System.out.println(ServerStrings.enterPasswordHint);
        String password = scanner.nextLine();
        Authentication authentication = new Authentication();
        return authentication.login(email, password);
    }

    public static boolean register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ServerStrings.enterEmailHint);
        String email = scanner.nextLine();
        System.out.println(ServerStrings.userNameHint);
        String userName = scanner.nextLine();
        System.out.println(ServerStrings.enterPasswordHint);
        String password = scanner.nextLine();
        Authentication authentication = new Authentication();
        user = new User(userName, email, password);
        return authentication.register(userName, email, password);
    }

    public static void showBalance() {
        System.out.println(ServerStrings.yourAccountBalance + user.getBackAccount().getBalance());
    }

    public static void serverServices() {
        Scanner scanner = new Scanner(System.in);
        Menus.serverServices();
        int menuChoice = scanner.nextInt();
        switch (menuChoice) {
            case 1:
                showBalance();
                break;
            case 2:
                System.out.println(ServerStrings.enterWithDrawMoney);
                double withdrawMoney = scanner.nextDouble();
                if (user.getBackAccount().withdraw(withdrawMoney)) {
                    System.out.println(ServerSuccessMessages.success);
                    showBalance();
                }else{
                    System.out.println(ServerStrings.notAvailableMoney);
                }
                break;
            case 3:
                System.out.println(ServerStrings.enterDepositMoney);
                double depositMoney = scanner.nextDouble();
                if(user.getBackAccount().deposit(depositMoney)){
                    System.out.println(ServerSuccessMessages.success);
                    showBalance();
                }else{
                    System.out.println(ServerErrorMessage.somethingWentWrong);
                }
                break;
            case 4:
                user.getBackAccount().showInformation();
                break;
            case 5:
                startServer();
                break;
        }
    }

    public static double enterStarterBalance() {
        Scanner scanner = new Scanner(System.in);
        double staterBalance;
        System.out.println(ServerStrings.enterStartedBalance);
        System.out.println(ServerStrings.needToBeMore1000);
        staterBalance = scanner.nextDouble();
        return staterBalance;
    }
    // login error: "خطآ في التسجيل"
    // login error: "login error"
    // login error: "Error de inicio de sesión"
    public static BackAccount creatAccount(User usr) {
        Scanner scanner = new Scanner(System.in);
        BackAccount bankAccount;
        while (true) {
            Menus.createNewAccountMenu();
            int choice = scanner.nextInt();
            if (choice == 1) {
                bankAccount = new BackAccount("4354335", enterStarterBalance(), usr);
                return bankAccount;
            } else if (choice == 2) {
                double balance = enterStarterBalance();
                while (balance < 1000) {
                    System.out.println(ServerStrings.pleaseEnterMoreThan1000);
                    balance = enterStarterBalance();
                }
                bankAccount = new SavingBankAccount("434546", balance, usr);
                return bankAccount;
            } else {
                System.out.println(ServerErrorMessage.menuChoiceError);
            }
        }
    }

    public static void checkAccount() {
        if (CheckBankAccount.isExistAccount(user)) {
            serverServices();
        } else {
            BackAccount newBackAccount = creatAccount(user);
            user.setBackAccount(newBackAccount);
        }
    }

    public static void startServer() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Menus.loginRegisterMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (login()) {
                        System.out.println(ServerSuccessMessages.successLogin);
                        checkAccount();
                    }
                    break;
                case 2:
                    if (register()) {
                        System.out.println(ServerSuccessMessages.successRegister);
                        checkAccount();
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


