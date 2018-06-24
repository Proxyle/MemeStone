package Websockets.Shared.messages;

import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.DamageSpell;
import Models.Card.Spell.DrawSpell;
import Models.Card.Spell.HealSpell;
import Models.Card.Spell.ResurrectSpell;

public class PlayCardMessage {
    int lobbyId;
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

    public int getLobbyId() {
        return lobbyId;
    }

    public int[] getLocation() {
        return location;
    }

    public PlayCardMessage(int lobbyId, Minion minion, int[] location){
        this.lobbyId = lobbyId;
        this.minion = minion;
        this.location = location;
    }

    public PlayCardMessage(int lobbyId, DamageSpell damageSpell, int[] location){
        this.lobbyId = lobbyId;
        this.damageSpell = damageSpell;
        this.location = location;
    }

    public PlayCardMessage(int lobbyId, DrawSpell drawSpell, int[] location){
        this.lobbyId = lobbyId;
        this.drawSpell = drawSpell;
        this.location = location;
    }

    public PlayCardMessage(int lobbyId, HealSpell healSpell, int[] location){
        this.lobbyId = lobbyId;
        this.healSpell = healSpell;
        this.location = location;
    }

    public PlayCardMessage(int lobbyId, ResurrectSpell resurrectSpell, int[] location){
        this.lobbyId = lobbyId;
        this.resurrectSpell = resurrectSpell;
        this.location = location;
    }

    public PlayCardMessage(int lobbyId, Card card, int[] location){
        this.lobbyId = lobbyId;
        String type = card.getClass().getName();
        switch(type){
            case "Minion":
                minion = (Minion) card;
                break;
            case "DamageSpell":
                damageSpell = (DamageSpell) card;
                break;
            case "DrawSpell":
                drawSpell = (DrawSpell) card;
                break;
            case "HealSpell":
                healSpell = (HealSpell) card;
                break;
            case "ResurrectSpell":
                resurrectSpell = (ResurrectSpell) card;
                break;
            default:
                return;
        }
    }
}


