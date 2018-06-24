package Communication.MessageGenerator;

import Models.Board;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Player;

import java.util.List;

public interface IMessageGenerator {
    void notifyCardBought(String sessionId);
    void notifyStartRound(List<String> sessionIds, int lobbyId);
    void notifyPlayerTurn(String sessionId);
    void notifyUpdatePlayer(String sessionId, Player player);
    void notifyUpdateBoard(String sessionId, Board board);
    void notifyActionFail(String sessionId);
    void notifyGameEnd (List<String> sessionIds, String winningName);
}
