package Websockets.Shared.messages;

import Models.User.Player;

public class JoinQueueMessage {
    Player player;

    public Player getPlayer() {
        return player;
    }

    public JoinQueueMessage(Player player) {
        this.player = player;
    }
}
