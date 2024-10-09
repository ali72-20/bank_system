package Auth;

abstract public class ValidatorManger {
    // regex --> regular expressions
    public static Boolean emailValidation(String email){
        if(email.isEmpty()) return false;
        else return true;
    }
    public static Boolean passwordValidation(String password){
        if(password.isEmpty()) return false;
        return true;
    }

}
