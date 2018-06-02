package Websockets.Shared.messages;

import Models.User.*;

public class UpdatePlayerMessage {
    private User player;

    public User getPlayer(){
        return player;
    }

    public UpdatePlayerMessage(User player){
        this.player = player;
    }
}
