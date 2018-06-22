package Communication.MessageGenerator;

import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Player;

public interface IMessageGenerator {

    void notifyRegisterResult(String sessionId, boolean success);
    void notifyPlayerAdded(String sessionId, String userName);
    void notifyStartRound();
    void notifyPlayerTurn(String sessionId);
    void notifyUpdatePlayer(String sessionId, Player player);
    void notifyUpdateBoard(Minion[][] board);
    void notifyActionFail(String sessionId);
    void notifyGameEnd (String winningName);
}
