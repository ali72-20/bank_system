import ServerMessages.ServerStrings;

abstract public class Menus {
    public static void loginRegisterMenu(){
        System.out.println("1- " + ServerStrings.login);
        System.out.println("2- " + ServerStrings.register);
        System.out.println("3- " + ServerStrings.exit);
    }
    public static void serverServices(){
        System.out.println("1- " + ServerStrings.checkBalance);
        System.out.println("2- " + ServerStrings.withdraw);
        System.out.println("3- " + ServerStrings.deposit);
        System.out.println("4- " + ServerStrings.showInformation);
        System.out.println("5- " + ServerStrings.logout);
    }

    public static void createNewAccountMenu(){
        System.out.println(ServerStrings.youNeedToCreateAccount);
        System.out.println("1- " + ServerStrings.basicBankAccount);
        System.out.println("2- " + ServerStrings.savingBankAccount);
    }
}
