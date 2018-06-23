package Logic.GameServer;

import Communication.MessageGenerator.IMessageGenerator;
import Logic.GameLogic.GameLogic;
import Logic.GameLogic.IGameLogic;
import Models.Board;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Player;

import java.util.ArrayList;
import java.util.List;

public class GameServerMain implements IGameServerMain, IGameServerMainGameLogic{
    private static final int WIN_SCORE = 100;
    private static final int LOSE_SCORE = 20;

    int counter = 0;
    IMessageGenerator messageGenerator;
    List<Player> playersInQueue = new ArrayList<>();
    List<IGameLogic> lobbies = new ArrayList<>();

    public GameServerMain(IMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
    }

    //region Main
    @Override
    public void endTurn(int lobbyId, String sessionId) {
        findLobby(lobbyId).endTurn(sessionId);
    }

    @Override
    public void playCard(int lobbyId, String sessionId, Card card, int[] location) {
        findLobby(lobbyId).playCard(sessionId, card, location);
    }

    @Override
    public void attack(int lobbyId, String sessionId, int attacker, int defender) {
        findLobby(lobbyId).attack(sessionId, attacker, defender);
    }

    @Override
    public void joinQueue(Player player) {
        playersInQueue.add(player);
    }

    @Override
    public void leaveQueue(String sessionId) {
        Player player = null;
        for(Player p: playersInQueue){
            if (p.getSessionId().equals(sessionId))
                player = p;
        }
        playersInQueue.remove(player);
    }

    @Override
    public void updateDeck(int playerId, List<Card> deck) {
        //todo
    }

    @Override
    public void forfeit(String sessionId, int lobbyId){
        findLobby(lobbyId).forfeit(sessionId);
    }

    @Override
    public void buyCard(int playerId){
        //todo
    }
    //endregion

    //region gameLogic
    @Override
    public void notifyUpdatePlayer(String sessionId, Player player) {
        messageGenerator.notifyUpdatePlayer(sessionId, player);
    }

    @Override
    public void notifyPlayerTurn(String sessionId) {
        messageGenerator.notifyPlayerTurn(sessionId);
    }

    @Override
    public void notifyUpdateBoard(String sessionId, Board board) {
        messageGenerator.notifyUpdateBoard(sessionId, board);
    }

    @Override
    public void notifyActionFail(String sessionId) {
        messageGenerator.notifyActionFail(sessionId);
    }

    @Override
    public void notifyGameEnd(int lobbyId, List<String> sessionIds, String winningName, Player winner, Player loser) {
        //todo

        messageGenerator.notifyGameEnd(sessionIds, winningName);
        lobbies.remove(findLobby(lobbyId));
    }

    @Override
    public void notifyStartRound(List<String> sessionIds, int lobbyId) {
        messageGenerator.notifyStartRound(sessionIds, lobbyId);
    }
    //endregion


    private IGameLogic findLobby(int lobbyId){
        for (IGameLogic lobby : lobbies){
            if (lobby.getLobbyId() == lobbyId)
                return lobby;
        }
        return null;
    }

    public void matchPlayers(){
        while (1<playersInQueue.size()){
            Player p1 = playersInQueue.get(0);
            Player p2 = playersInQueue.get(1);
            lobbies.add(new GameLogic(this, nextLobbyId(), p1, p2));
            playersInQueue.remove(p1);
            playersInQueue.remove(p2);
        }
    }

    private int nextLobbyId(){
        counter++;
        if (counter > 2500000)
            counter = 1;
        return counter;
    }
}
