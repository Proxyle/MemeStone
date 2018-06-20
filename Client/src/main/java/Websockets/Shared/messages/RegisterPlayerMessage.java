package Websockets.Shared.messages;

public class RegisterPlayerMessage {
    String userName;

    public String getUserName() {
        return userName;
    }

    public RegisterPlayerMessage(String userName){
        this.userName = userName;
    }

}
