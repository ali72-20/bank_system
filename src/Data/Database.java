package Data;

import Auth.User;

import java.util.ArrayList;
import java.util.List;

abstract public class Database implements DataBaseServices {
    List<User> database;
    public Database(){
        database = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public void checkHaveUser(User user) {

    }
}
