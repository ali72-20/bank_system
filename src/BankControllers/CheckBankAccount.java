package BankControllers;
import Auth.User;

abstract public class CheckBankAccount {
    public static boolean isExistAccount(User user){
        if(user.getBackAccount() == null){
            return false;
        }
        return true;
    }
}
