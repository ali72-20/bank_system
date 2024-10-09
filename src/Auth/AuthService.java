package Auth;

public interface AuthService{
    void login(String email,String password);
    void register(String userName,String email,String password);
    void changePassword(String oldPassword,String newPassword);
}
