package Messages.ServerToClient;

import Models.Player;

public class UpdatePlayerMessage {
    private Player player;

    public Player getPlayer(){
        return player;
    }

    public UpdatePlayerMessage(Player player){
        this.player = player;
    }
}
