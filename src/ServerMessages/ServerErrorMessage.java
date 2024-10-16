package ServerMessages;

abstract public class ServerErrorMessage {
    public final static String menuChoiceError = "ERROR: In valid choice\nplease choose from menu";
    public final static String emptyFieldError = "ERROR: These are required";
    public final static String notExistInDatabaseError = "Error: Email or password is incorrect";
    public final static String emailExist = "This email was user before";
    public final static String userNameExist = "This user name is already used";

}
