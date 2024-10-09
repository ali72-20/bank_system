package Data;

import Auth.User;

public interface DataBaseServices {
    void addUser(User user);
    void removeUser(User user);
    void checkHaveUser(User user);
}
