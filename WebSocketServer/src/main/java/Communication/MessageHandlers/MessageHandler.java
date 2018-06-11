package Communication.MessageHandlers;

import Logic.GameLobby.GameLogic;
import Logic.GameLobby.IGameLogic;
import Messages.ClientToServer.AttackMessage;
import Messages.ClientToServer.EndTurnMessage;
import Messages.ClientToServer.PlayCardMessage;
import Messages.ClientToServer.RegisterPlayerMessage;
import Models.Cards.Card;
import Models.Deck;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class MessageHandler implements IMessageHandler {
    IGameLogic gameLogic;

    public void setGameLogic(IGameLogic gameLogic){
        this.gameLogic = gameLogic;
    }
    @Override
    public void handleMessage(String sessionId, String data, String simpleType, Gson gson) {
        switch(simpleType) {
            case "RegisterPlayerMessage":
                System.out.println("RegisterPlayedMessage parsing started");
                RegisterPlayerMessage registerPlayerMessage = gson.fromJson(data, RegisterPlayerMessage.class);
                System.out.print("RegisterPlayerMessage parsing finished");
                registerPlayer(sessionId, registerPlayerMessage.getUserName(), registerPlayerMessage.getDeck());
            case "AttackMessage":
                System.out.println("AttackMessage parsing started");
                AttackMessage attackMessage = gson.fromJson(data, AttackMessage.class);
                System.out.println("AttackMessage parsing finished");
                attack(sessionId, attackMessage.getAttacker(), attackMessage.getDefender());
            case "EndTurnMessage":
                endTurn(sessionId);
            case "PlayCardMessage":
                System.out.println("PlayCardMessage parsing started");
                PlayCardMessage playCardMessage = gson.fromJson(data, PlayCardMessage.class);
                System.out.println("PlayCardMessage parsing finished");
                playCard(sessionId, playCardMessage.getCard(), playCardMessage.getLocation());
            default:
                return;
        }
    }

    private void registerPlayer(String sessionId, String userName, Deck deck){
        gameLogic.registerNewPlayer(sessionId, userName, deck);
    }

    private void attack(String sessionId, int[] attacker, int[] defender){
        gameLogic.attack(sessionId, attacker, defender);
    }

    private void endTurn(String sessionId){
        gameLogic.endTurn(sessionId);
    }

    private void playCard(String sessionId, Card card, int[] location){
        gameLogic.playCard(sessionId, card, location);
    }
}
