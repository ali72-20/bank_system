package Data;
import Auth.User;

public interface DataBaseServices {

   static void addUser(User user){}
    void removeUser(User user);
    void checkHaveUser(User user);
}
