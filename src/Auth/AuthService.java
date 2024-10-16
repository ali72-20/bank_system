package Auth;

public interface AuthService{
    Boolean login(String email, String password);

    Boolean register(String userName,String email,String password);
    void changePassword(String oldPassword,String newPassword);
}
