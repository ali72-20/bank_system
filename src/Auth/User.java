package Auth;

import BankControllers.BackAccount;

public class User {
    private String userName;
    private String userEmail;
    private String userPassword;
    private BackAccount backAccount;
    public User(String userName, String userEmail, String userPassword){
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.backAccount = backAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public BackAccount getBackAccount() {
        return backAccount;
    }

    public void setBackAccount(BackAccount backAccount) {
        this.backAccount = backAccount;
    }
}
