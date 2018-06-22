package Websockets.Shared.messages;


import Models.User.Player;

public class RegisterPlayerMessage {
    Player player;

    public Player getPlayer() {
        return player;
    }

    public RegisterPlayerMessage(Player p){
        this.player = p;
    }

}
