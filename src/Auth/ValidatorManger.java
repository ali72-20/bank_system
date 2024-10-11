package Auth;

import Data.Database;

abstract public class ValidatorManger {
    public static Boolean emailValidation(String email){
        if(email.isEmpty()) return false;
        else return true;
    }
    public static Boolean passwordValidation(String password){
        if(password.isEmpty()) return false;
        return true;
    }
    public static Boolean isExistInDataBase(String email, String passwrod){
        for(int i = 0; i < Database.database.size(); ++i){
            if(Database.database.get(i).getUserEmail() == email && Database.database.get(i).getUserPassword() == passwrod)
                return true;
        }
        return false;
    }

}
