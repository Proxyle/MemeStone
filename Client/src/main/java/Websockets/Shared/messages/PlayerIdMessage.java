package Websockets.Shared.messages;

public class PlayerIdMessage {
    int id;

    public int getId() {
        return id;
    }

    public PlayerIdMessage(int id){
        this.id = id;
    }
}
