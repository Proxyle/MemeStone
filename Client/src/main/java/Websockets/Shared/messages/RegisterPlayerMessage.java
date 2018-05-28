package Websockets.Shared.messages;

public class RegisterPlayerMessage {
    String name;

    public String getName() {
        return name;
    }

    public RegisterPlayerMessage(String name) {
        this.name = name;
    }
}
