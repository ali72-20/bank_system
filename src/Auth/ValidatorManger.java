package Auth;

import Data.Database;

import java.util.Objects;

abstract public class ValidatorManger {
    public static Boolean validateInputField(String input){
        if(input.isEmpty()) return false;
        return true;
    }
    public static Boolean isExistInDataBase(String email, String password){
        for(int i = 0; i < Database.database.size(); ++i){
            if(Objects.equals(Database.database.get(i).getUserEmail(), email) && Objects.equals(Database.database.get(i).getUserPassword(), password))
                return true;
        }
        return false;
    }

    public static Boolean isEmailExist(String email){
        for (int i = 0;i < Database.database.size(); ++i){
            if(Objects.equals(Database.database.get(i).getUserEmail(),email)){
                return true;
            }
        }
        return false;
    }

    public static Boolean isUerNameExist(String userName){
        for(int i = 0;i < Database.database.size(); ++i){
            if(Objects.equals(Database.database.get(i).getUserName(),userName)){
                return true;
            }
        }
        return false;
    }

}
