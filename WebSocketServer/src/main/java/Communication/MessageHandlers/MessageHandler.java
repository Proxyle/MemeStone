package Communication.MessageHandlers;

import Logic.GameServer.IGameServerMain;
import Messages.ClientToServer.*;
import Models.Cards.Card;
import Models.Player;
import com.google.gson.Gson;

import java.util.List;

public class MessageHandler implements IMessageHandler {
    IGameServerMain gameServer;

    public void setGameServer(IGameServerMain gameServer){
        this.gameServer = gameServer;
    }
    @Override
    public void handleMessage(String sessionId, String data, String simpleType, Gson gson) {
        switch(simpleType) {
            case "AttackMessage":
                System.out.println("AttackMessage parsing started");
                AttackMessage attackMessage = gson.fromJson(data, AttackMessage.class);
                System.out.println("AttackMessage parsing finished");
                attack(sessionId, attackMessage.getLobbyId(), attackMessage.getAttacker(), attackMessage.getDefender());
                return;
            case "EndTurnMessage":
                EndTurnMessage endTurnMessage = gson.fromJson(data, EndTurnMessage.class);
                endTurn(sessionId, endTurnMessage.getLobbyId());
                return;
            case "PlayCardMessage":
                System.out.println("PlayCardMessage parsing started");
                PlayCardMessage playCardMessage = gson.fromJson(data, PlayCardMessage.class);
                System.out.println("PlayCardMessage parsing finished");
                playCard(sessionId, playCardMessage.getCard(), playCardMessage.getLocation(), playCardMessage.getLobbyId());
                return;
            case "BuyCardMessage":
                BuyCardMessage buyCardMessage = gson.fromJson(data, BuyCardMessage.class);
                buyCard(buyCardMessage.getPlayerId());
                return;
            case "ForfeitMessage":
                ForfeitMessage forfeitMessage = gson.fromJson(data, ForfeitMessage.class);
                forfeit(sessionId, forfeitMessage.getLobbyId());
                return;
            case "SaveDeckMessage":
                SaveDeckMessage saveDeckMessage = gson.fromJson(data, SaveDeckMessage.class);
                saveDeck(saveDeckMessage.getPlayerId(), saveDeckMessage.getDeck());
                return;
            case "JoinQueueMessage":
                JoinQueueMessage joinQueueMessage = gson.fromJson(data, JoinQueueMessage.class);
                joinQueue(sessionId, joinQueueMessage.getPlayer());
                return;
            case "LeaveQueueMessage":
                leaveQueue(sessionId);
                return;
            default:
                return;
        }
    }

    private void attack(String sessionId, int lobbyId, int attacker, int defender){
        gameServer.attack(lobbyId, sessionId, attacker, defender);
    }

    private void endTurn(String sessionId, int lobbyId){
        gameServer.endTurn(lobbyId, sessionId);
    }

    private void playCard(String sessionId, Card card, int[] location, int lobbyId){
        gameServer.playCard(lobbyId, sessionId, card, location);
    }

    private void forfeit(String sessionId, int lobbyId){
        gameServer.forfeit(sessionId, lobbyId);
    }

    private void saveDeck(int playerId, List<Card> deck){
        gameServer.updateDeck(playerId, deck);
    }

    private void joinQueue(String sessionId, Player player){
        player.setSessionId(sessionId);
        gameServer.joinQueue(player);
    }

    private void leaveQueue(String sessionId){
        gameServer.leaveQueue(sessionId);
    }

    private void buyCard(int playerId){
        gameServer.buyCard(playerId);
    }
}
