package BankControllers;

import Auth.User;
import ServerMessages.ServerErrorMessage;
import ServerMessages.ServerStrings;

public class BackAccount{
    private String accountId;
    private double balance;
    private User user;

   public BackAccount(String accountId, double balance, User user){
       this.accountId = accountId;
       this.balance = balance;
       this.user = user;
   }

    BackAccount(String accountId, User user){
       this.accountId = accountId;
       this.user = user;
   }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAccountType(){
       return ServerStrings.basicBankAccount;
    }
    public void showInformation(){
        System.out.println(getUser().getUserEmail());
        System.out.println(getUser().getUserName());
        System.out.println(getBalance());
        System.out.println(getAccountType());
    }
    public boolean deposit(double money){
       if(money > 0) {
           this.balance += money;
           return true;
       }else {
           System.out.println(ServerErrorMessage.invalidMoney);
           return false;
       }

    }
    public boolean withdraw(double money){
       if(money <= balance && money > 0){
            this.balance-=money;
            return true;
       }else{
           System.out.println(ServerErrorMessage.invalidMoney);
           return false;
       }
    }
}
