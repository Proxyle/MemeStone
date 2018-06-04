package Websockets.Shared.messages;

public class LoginMessage {
    String userName;

    public String getUserName() {
        return userName;
    }

    public LoginMessage(String userName){
        this.userName = userName;
    }
}
