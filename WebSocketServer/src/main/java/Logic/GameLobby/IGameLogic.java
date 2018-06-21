package Logic.GameLobby;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Deck;

public interface IGameLogic {
    void registerNewPlayer(String userName, String sessionId, Deck deck);
    void endTurn(String sessionId);
    void playCard(String sessionId, Card card, int[] location);
    void attack(String sessionId, int attacker, int defender);
    boolean placeMinion(int[] location, Minion minion);
    void drawCard(int amount);
    boolean damageTarget(int amount, int[] location);
}
