package Logic.GameLogic;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Deck;

public interface IGameLogic {
    int getLobbyId();
    void endTurn(String sessionId);
    void playCard(String sessionId, Card card, int[] location);
    void attack(String sessionId, int attacker, int defender);
    boolean placeMinion(int location, Minion minion);
    boolean damageTarget(int amount, int[] location);
    void drawCard(int amount);
    void forfeit(String sessionId);
}
