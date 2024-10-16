package Auth;

import Data.Database;
import ServerMessages.ServerErrorMessage;
public class Authentication implements AuthService{
    @Override
    public Boolean login(String email, String password) {
        if(ValidatorManger.validateInputField(email) && ValidatorManger.validateInputField(password)){
            if(ValidatorManger.isExistInDataBase(email,password)){
                return true;
            }else{
                System.out.println(ServerErrorMessage.notExistInDatabaseError);
                return false;
            }
        }else{
            System.out.println(ServerErrorMessage.emptyFieldError);
            return false;
        }
    }

    @Override
    public Boolean register(String userName, String email, String password) {
        boolean isRegistered = false;
        if(ValidatorManger.validateInputField(userName) && ValidatorManger.validateInputField(email) && ValidatorManger.validateInputField(password)){
            if(ValidatorManger.isEmailExist(email)){
                System.out.println(ServerErrorMessage.emailExist);
            }else if(ValidatorManger.isUerNameExist(userName)){
                System.out.println(ServerErrorMessage.userNameExist);
            }else{
                User newUser = new User(userName,email,password);
                Database.addUser(newUser);
                isRegistered = true;
            }
        }else{
            System.out.println(ServerErrorMessage.emptyFieldError);
        }
        return isRegistered;
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

}
