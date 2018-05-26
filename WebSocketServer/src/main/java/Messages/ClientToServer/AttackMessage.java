package Messages.ClientToServer;

public class AttackMessage {
    int[] attacker;
    int[] defender;

    public int[] getAttacker() {
        return attacker;
    }

    public int[] getDefender() {
        return defender;
    }

    public AttackMessage(int[] attacker, int[] defender){
        this.attacker = attacker;
        this.defender = defender;
    }
}
