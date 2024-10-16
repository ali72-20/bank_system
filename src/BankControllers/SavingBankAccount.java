package BankControllers;
import Auth.User;

public class SavingBankAccount extends BackAccount{
    public SavingBankAccount(String accountId,double balance, User user){
        super(accountId,user);
        if(balance < 1000){
            System.out.println("Not Valid balance");
        }else{
            this.setBalance(balance);
        }
    }
    @Override
    public String getAccountType(){
        return "Saving bank account";
    }

    @Override
    public boolean withdraw(double money){
        if(money > 0 && getBalance() - money >= 1000){
            this.setBalance(getBalance() - money);
            return true;
        }else{
            System.out.println("Invalid operation");
            return false;
        }
    }
}
