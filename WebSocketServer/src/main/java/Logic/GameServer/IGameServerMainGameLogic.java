package Logic.GameServer;

import Models.Board;
import Models.Cards.Minion;
import Models.Player;

import java.util.List;

public interface IGameServerMainGameLogic {

    void notifyUpdatePlayer(String sessionId, Player player);
    void notifyPlayerTurn(String sessionId);
    void notifyUpdateBoard(String sessionId, Board board);
    void notifyActionFail(String sessionId);
    void notifyGameEnd(int lobbyId, List<String> sessionIds, String winningName, Player winner, Player loser);
    void notifyStartRound(List<String> sessionIds, int lobbyId);
}
