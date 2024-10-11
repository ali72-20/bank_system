package Auth;

import ServerMessages.ServerErrorMessage;
public class Authentication implements AuthService{
    @Override
    public Boolean login(String email, String password) {
        if(ValidatorManger.emailValidation(email) && ValidatorManger.passwordValidation(password)){
            if(ValidatorManger.isExistInDataBase(email,password)){
                return true;
            }else{
                System.out.println(ServerErrorMessage.notExistInDatabaseError);
                return false;
            }
        }else{
            System.out.println(ServerErrorMessage.emptyLoginError);
            return false;
        }
    }

    @Override
    public void register(String userName, String email, String password) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

}
