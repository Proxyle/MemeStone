package Websockets.Shared.messages;

public class AttackMessage {
    int lobbyId;
    int attacker;
    int defender;

    public int getLobbyId() {
        return lobbyId;
    }

    public int getAttacker() {
        return attacker;
    }

    public int getDefender() {
        return defender;
    }

    public AttackMessage(int lobbyId, int attacker, int defender){
        this.lobbyId = lobbyId;
        this.attacker = attacker;
        this.defender = defender;
    }
}
