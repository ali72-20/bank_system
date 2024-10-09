package Auth;

import ServerErrorMessage.ServerErrorMessage;
public class Authentication  implements AuthService{
    @Override
    public void login(String email, String password) {
        if(ValidatorManger.emailValidation(email) && ValidatorManger.passwordValidation(password)){

        }else{
            System.out.println(ServerErrorMessage.emptyLoginError);
        }
    }

    @Override
    public void register(String userName, String email, String password) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

}
