package Logic.GameLogic;

import Communication.MessageGenerator.IMessageGenerator;
import Logic.GameServer.IGameServerMainGameLogic;
import Models.Board;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Deck;
import Models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic implements IGameLogic {

    final int START_HEALTH = 20;
    int lobbyId;
    IGameServerMainGameLogic gameServer;
    ArrayList<Player> players = new ArrayList();
    Random r = new Random();
    int currentPlayer;
    Board gameBoard;


    private List<String> getSessionIds(){
        ArrayList<String> returnList = new ArrayList<>();
        returnList.add(players.get(0).getSessionId());returnList.add(players.get(1).getSessionId());
        return returnList;
    }

    public int getLobbyId(){
        return lobbyId;
    }

    public GameLogic(IGameServerMainGameLogic gameServer, int lobbyId, Player p1, Player p2){
        this.gameServer = gameServer;
        this.lobbyId = lobbyId;
        players.add(p1);
        players.add(p2);
        startNewRound();
    }

    private void startNewRound(){
        gameServer.notifyStartRound(getSessionIds(), lobbyId);
        currentPlayer = r.nextBoolean() ? 0 : 1;
        drawCard(2);
        Player p = players.get(currentPlayer);
        currentPlayer = 1-currentPlayer;
        drawCard(3);
        p = players.get(currentPlayer);

        gameBoard = new Board(START_HEALTH);

        endTurn(players.get(currentPlayer).getSessionId());
    }

    private boolean checkPlayerTurn(String sessionId){
        return players.get(currentPlayer).getSessionId().equals(sessionId);
    }

    public void endTurn(String sessionId){
        if (checkPlayerTurn(sessionId)) {
            System.out.println("End turn has been called");
            currentPlayer = 1 - currentPlayer;
            startOfTurn();
        }
    }

    private void startOfTurn(){
        System.out.println("Start turn");
        Player p = players.get(currentPlayer);
        System.out.println("Draw card");
        p.drawCard();
        System.out.println("NotifyPlayer");
        gameServer.notifyUpdatePlayer(p.getSessionId(), p);
        gameServer.notifyPlayerTurn(p.getSessionId());
        System.out.println("Done!");
    }

    public void playCard(String sessionId, Card card, int[] location){
        System.out.println("Starting playCard method");
        if (checkPlayerTurn(sessionId)){
            System.out.println("player turn found");
            if (currentPlayer == 1) {
                gameBoard = gameBoard.flipBoard();
            }

            System.out.println("Trying to find player");
            Player p = players.get(currentPlayer);
            System.out.print("Player found?"); System.out.println(p != null);
            if (p.playCard(card, this, location))
            {
                if (currentPlayer == 1)
                    gameBoard = gameBoard.flipBoard();
                gameServer.notifyUpdatePlayer(sessionId, p);
                gameServer.notifyUpdateBoard(players.get(0).getSessionId(), gameBoard);
                gameServer.notifyUpdateBoard(players.get(1).getSessionId(), gameBoard.flipBoard());
            }
            else{
                gameServer.notifyActionFail(sessionId);
            }
        }
        else{
            System.out.println("Not this guys turn");
            gameServer.notifyActionFail(sessionId);
        }
    }

    public void attack(String sessionId, int attacker, int defender){
        if (checkPlayerTurn(sessionId)) {
            Board board = gameBoard;
            if (currentPlayer == 1) {
                board = board.flipBoard();
            }
            if (attacker == 7) {
                gameServer.notifyActionFail(sessionId);
                return;
            }

            if (defender == 7){
                if (board.canAttackHero(attacker)){
                    if (board.attackOpponentHero(attacker))
                        gameEnd();
                }
            }

            if (!board.attack(attacker, defender)){
                gameServer.notifyActionFail(sessionId);
            }

            if (currentPlayer == 1){
                board = board.flipBoard();
            }
            gameBoard = board;

            gameServer.notifyUpdateBoard(players.get(0).getSessionId(), gameBoard);
            gameServer.notifyUpdateBoard(players.get(1).getSessionId(), gameBoard.flipBoard());
        }
    }

    private void gameEnd(){
        String winningName = players.get(currentPlayer).getName();
        gameServer.notifyGameEnd(lobbyId, getSessionIds(), winningName);
    }

    public boolean placeMinion(int location, Minion minion){
        return gameBoard.placeMinion(minion, location);
    }

    public void drawCard(int amount){
        Player p = players.get(currentPlayer);
        while (amount > 0) {
            p.drawCard();
            amount--;
        }
        gameServer.notifyUpdatePlayer(p.getSessionId(), p);
    }

    public boolean damageTarget(int amount, int[] location){
        return gameBoard.damage(location[1], amount, currentPlayer == location[0]);
    }
}
