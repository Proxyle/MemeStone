package Messages.ClientToServer;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Cards.Spells.*;

public class PlayCardMessage {
    Minion minion;
    DamageSpell damageSpell;
    DrawSpell drawSpell;
    HealSpell healSpell;
    ResurrectSpell resurrectSpell;

    int[] location;

    public Card getCard() {
        if (minion != null)
            return minion;
        if (damageSpell != null)
            return damageSpell;
        if (drawSpell!= null)
            return drawSpell;
        if (healSpell!= null)
            return healSpell;
        if (resurrectSpell != null)
            return resurrectSpell;
        return null;
    }

    public int[] getLocation() {
        return location;
    }

    public PlayCardMessage(Minion minion, int[] location){
        this.minion = minion;
        this.location = location;
    }

    public PlayCardMessage(DamageSpell damageSpell, int[] location){
        this.damageSpell = damageSpell;
        this.location = location;
    }

    public PlayCardMessage(DrawSpell drawSpell, int[] location){
        this.drawSpell = drawSpell;
        this.location = location;
    }

    public PlayCardMessage(HealSpell healSpell, int[] location){
        this.healSpell = healSpell;
        this.location = location;
    }

    public PlayCardMessage(ResurrectSpell resurrectSpell, int[] location){
        this.resurrectSpell = resurrectSpell;
        this.location = location;
    }
}
