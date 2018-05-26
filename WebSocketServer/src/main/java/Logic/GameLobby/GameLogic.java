package Logic.GameLobby;

import Communication.MessageGenerator.IMessageGenerator;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Deck;
import Models.Player;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic implements IGameLogic {

    IMessageGenerator messageGenerator;
    ArrayList<Player> players = new ArrayList();
    Random r = new Random();
    int currentPlayer;
    Card[][] board = new Card[2][7];

    public GameLogic(IMessageGenerator messageGenerator)
    {
        this.messageGenerator = messageGenerator;
    }

    public void registerNewPlayer(String userName, String sessionId, Deck deck){
        if(players.size() < 2)
        {
            if(checkPlayerNameAlreadyExists(userName)){
                messageGenerator.notifyRegisterResult(sessionId, false);
                return;
            }

            Player p = new Player(sessionId, userName, deck);
            players.add(p);
            messageGenerator.notifyRegisterResult(sessionId, true);
            messageGenerator.notifyPlayerAdded(sessionId, userName);
            checkStartingCondition();
        }
        else
        {
            messageGenerator.notifyRegisterResult(sessionId, false);
        }
    }

    private boolean checkPlayerNameAlreadyExists(String userName){
        for(Player pl : players)
            if(pl.getName().equals(userName))
            {
                return true;
            }


        return false;
    }

    private void checkStartingCondition() {
        if (players.size() == 2) {
            //Start the game
            startNewRound();
        }
    }

    private void startNewRound(){
        messageGenerator.notifyStartRound();
        currentPlayer = r.nextBoolean() ? 0 : 1;
        drawCard(2);
        Player p = players.get(currentPlayer);
        messageGenerator.notifyPlayerId(p.getSessionId(), players.indexOf(p));
        currentPlayer = 1-currentPlayer;
        drawCard(3);
        p = players.get(currentPlayer);
        messageGenerator.notifyPlayerId(p.getSessionId(), players.indexOf(p));
        endTurn(players.get(currentPlayer).getSessionId());
    }

    private boolean checkPlayerTurn(String sessionId){
        return players.get(currentPlayer).getSessionId().equals(sessionId);
    }

    public void endTurn(String sessionId){
        if (checkPlayerTurn(sessionId))
        currentPlayer = 1-currentPlayer;
        startOfTurn();
    }

    private void startOfTurn(){
        Player p = players.get(currentPlayer);
        p.drawCard();
        messageGenerator.notifyUpdatePlayer(p.getSessionId(), p);
        messageGenerator.notifyPlayerTurn(p.getSessionId());
    }

    public void playCard(String sessionId, Card card, int[] location){
        if (checkPlayerTurn(sessionId)){
            if (currentPlayer == 1) {
                        location[0] = 1 - location[0];
                        if (location[1] != 6) {
                            location[1] = 5 - location[2];
                }
            }


            Player p = players.get(currentPlayer);
            if (p.playCard(card, this, location))
            {
                messageGenerator.notifyUpdatePlayer(sessionId, p);
                messageGenerator.notifyUpdateBoard(board);
            }
            else{
                messageGenerator.notifyActionFail(sessionId);
                messageGenerator.notifyUpdatePlayer(sessionId, p);
            }
        }
    }

    public void attack(String sessionId, int[] attacker, int[] defender){
        if (checkPlayerTurn(sessionId)) {
            if (currentPlayer == 1) {
                attacker[0] = 1 - attacker[0];
                defender[0] = 1 - defender[0];
                if (attacker[1] != 6)
                    attacker[1] = 5 - attacker[1];
                if (defender[1] != 6)
                    defender[1] = 5 - defender[1];
            }
            Minion attack = (Minion)board[attacker[0]][attacker[1]];
            Minion defend = (Minion)board[defender[0]][defender[1]];

            if (attack.getAttackPoints() < 1){
                messageGenerator.notifyActionFail(sessionId);
            }
            else {
                boolean alive = attack.receiveDamage(defend.getAttackPoints());
                if (!defend.receiveDamage(attack.getAttackPoints()))
                    defend = null;
                if (!alive)
                    attack = null;
                board[attacker[0]][attacker[1]] = attack;
                board[defender[0]][defender[1]] = defend;

                messageGenerator.notifyUpdateBoard(board);
                if (attack == null && attacker[1] == 6)
                {
                    gameEnd(1 - attacker[0]);
                }
                else if (defend == null && defender[1] == 6){
                    gameEnd(1- defender[0]);
                }
            }
        }
    }

    private void gameEnd(int winner){
        String winningName = players.get(winner).getName();
        messageGenerator.notifyGameEnd(winningName);
    }

    public boolean placeMinion(int[] location, Minion minion){
        if (location[0] == currentPlayer && board[location[0]][location[1]] == null) {
            board[location[0]][location[1]] = minion;
            return true;
        }
        return false;
    }

    public void drawCard(int amount){
        Player p = players.get(currentPlayer);
        while (amount > 0) {
            p.drawCard();
            amount--;
        }
        messageGenerator.notifyUpdatePlayer(p.getSessionId(), p);
    }

    public boolean damageTarget(int amount, int[] location){
        Minion target = (Minion)board[location[0]][location[1]];
        if (target == null)
            return false;
        target.receiveDamage(amount);
        board[location[0]][location[1]] = target;
        return true;
    }
}
