package Data;

import Auth.User;

import java.util.ArrayList;
import java.util.List;



abstract public class Database implements DataBaseServices {
    public static List<User> database;
    public static void initDatabase(){
        database = new ArrayList<>();
    }
    public static void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void checkHaveUser(User user) {

    }
}
