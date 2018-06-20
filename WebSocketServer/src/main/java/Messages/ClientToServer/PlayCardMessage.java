package Messages.ClientToServer;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Cards.Spells.*;

import java.lang.reflect.Type;

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

    public PlayCardMessage(Card card, int[] location){
        String type = card.getClass().getName();
        switch(type){
            case "Minion":
                minion = (Minion) card;
            case "DamageSpell":
                damageSpell = (DamageSpell) card;
            case "DrawSpell":
                drawSpell = (DrawSpell) card;
            case "HealSpell":
                healSpell = (HealSpell) card;
            case "ResurrectSpell":
                resurrectSpell = (ResurrectSpell) card;
            default:
                return;
        }
    }
}
