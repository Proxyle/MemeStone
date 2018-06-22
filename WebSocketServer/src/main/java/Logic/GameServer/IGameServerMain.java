package Logic.GameServer;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Player;

import java.util.List;

public interface IGameServerMain {
    void endTurn(int lobbyId, String sessionId);
    void playCard(int lobbyId, String sessionId, Card card, int[] location);
    void attack(int lobbyId, String sessionId, int attacker, int defender);
    void joinQueue(Player player);
    void leaveQueue(String sessionId);
    void updateDeck(int playerId, List<Card> deck);
    void forfeit(String sessionId, int lobbyId);
    void buyCard(int playerId);
}
