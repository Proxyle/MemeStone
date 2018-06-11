package Logic.GameLobby;

import Communication.MessageGenerator.IMessageGenerator;
import Models.Cards.Card;
import Models.Cards.Minion;
import Models.Deck;
import Models.Player;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic implements IGameLogic {

    final int START_HEALTH = 20;

    IMessageGenerator messageGenerator;
    ArrayList<Player> players = new ArrayList();
    Random r = new Random();
    int currentPlayer;
    Minion[][] board = new Minion[2][7];


    public GameLogic(IMessageGenerator messageGenerator)
    {
        this.messageGenerator = messageGenerator;
    }

    public void registerNewPlayer(String sessionId, String userName, Deck deck){
        System.out.print("registerNewPlayer has been called");
        if(players.size() < 2)
        {
            if(checkPlayerNameAlreadyExists(userName)){
                messageGenerator.notifyRegisterResult(sessionId, false);
                System.out.println(" but name already exists!");
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
            System.out.println(" but failed!");
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
            System.out.println("Round starts");
            startNewRound();
        }
    }

    private void startNewRound(){
        messageGenerator.notifyStartRound();
        currentPlayer = r.nextBoolean() ? 0 : 1;
        drawCard(2);
        Player p = players.get(currentPlayer);
        currentPlayer = 1-currentPlayer;
        drawCard(3);
        p = players.get(currentPlayer);

        board[0][6] = new Minion("Hero", "", 0, 0, START_HEALTH);
        board[1][6] = new Minion("Hero", "", 0, 0, START_HEALTH);

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
        messageGenerator.notifyUpdatePlayer(p.getSessionId(), p);
        messageGenerator.notifyPlayerTurn(p.getSessionId());
        System.out.println("Done!");
    }

    public void playCard(String sessionId, Card card, int[] location){
        System.out.println("Starting playCard method");
        if (checkPlayerTurn(sessionId)){
            System.out.println("player turn found");
            if (currentPlayer == 1) {
                        location[0] = 1 - location[0];
                        if (location[1] != 6) {
                            location[1] = 5 - location[2];
                }
            }

            System.out.println("Trying to find player");
            Player p = players.get(currentPlayer);
            System.out.print("Player found?"); System.out.println(p != null);
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
        else{
            System.out.println("Not this guys turn");
            messageGenerator.notifyActionFail(sessionId);
        }
    }

    public void attack(String sessionId, int attacker, int defender){
        if (checkPlayerTurn(sessionId)) {
            if (currentPlayer == 1) {
                if (attacker != 6)
                    attacker = 5 - attacker;
                if (defender != 6)
                    defender = 5 - defender;
            }
            Minion attack = board[currentPlayer][attacker];
            if (attack == null) {
                messageGenerator.notifyActionFail(sessionId);
                return;
            }
            if (attacker < 3){ // left lane
                if (defender < 6 && defender > 2){ //if target is in right lane
                    messageGenerator.notifyActionFail(sessionId);
                    return;
                }
                else if (defender == 6){ //if target is the hero
                    if (!checkAttackHero()){
                        messageGenerator.notifyActionFail(sessionId);
                        return;
                    }
                }
            }
            else if (attacker < 6){ //right lane
                if (defender < 3){ //if target is in right lane
                    messageGenerator.notifyActionFail(sessionId);
                    return;
                }
                else if (defender == 6){ //if target is hero
                    if (!checkAttackHero()){
                        messageGenerator.notifyActionFail(sessionId);
                        return;
                    }

                }
            }
            else{ //hero
                if (defender == 6){//if target is hero
                    if (!checkAttackHero()){
                        messageGenerator.notifyActionFail(sessionId);
                        return;
                    }
                }
            }
            Minion defend = board[1-currentPlayer][defender];

            if (defend == null){
                messageGenerator.notifyActionFail(sessionId);
                return;
            }


            if (attack.getAttackPoints() < 1){
                messageGenerator.notifyActionFail(sessionId);
            }
            else {
                boolean alive = attack.receiveDamage(defend.getAttackPoints());
                if (!defend.receiveDamage(attack.getAttackPoints()))
                    defend = null;
                if (!alive)
                    attack = null;
                board[currentPlayer][attacker] = attack;
                board[1-currentPlayer][defender] = defend;

                messageGenerator.notifyUpdateBoard(board);

                if (attack == null && attacker == 6)
                {
                    gameEnd(1 - currentPlayer);
                }
                else if (defend == null && defender == 6){
                    gameEnd(currentPlayer);
                }
            }
        }
    }

    private boolean checkAttackHero(){
        for (int i = 0; i<6; i++){
            Minion m = board[1-currentPlayer][i];
            if (m != null){
                return false;
            }
        }
        return true;
    }

    private void gameEnd(int winner){
        String winningName = players.get(winner).getName();
        messageGenerator.notifyGameEnd(winningName);
    }

    public boolean placeMinion(int[] location, Minion minion){
        System.out.println("Placing Minion");
        if (location[0] == currentPlayer && board[location[0]][location[1]] == null) {
            System.out.println("Spot empty, pacing minion");
            board[location[0]][location[1]] = minion;
            return true;
        }
        System.out.println("Spot not empty");
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
