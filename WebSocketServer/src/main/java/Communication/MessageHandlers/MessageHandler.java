package Communication.MessageHandlers;

import Logic.GameLogic.IGameLogic;
import Logic.GameServer.IGameServerMain;
import Messages.ClientToServer.AttackMessage;
import Messages.ClientToServer.EndTurnMessage;
import Messages.ClientToServer.PlayCardMessage;
import Messages.ClientToServer.RegisterPlayerMessage;
import Models.Cards.Card;
import Models.Deck;
import com.google.gson.Gson;

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
            case "FindGame"://Todo fix name
                //Todo fix matchmaking
                return;
            case "GetCollection": //Todo fix name
                //Todo fix returning matchmaking
                return;
            case "UpdateDeck": //Todo fix name
                //Todo fix updating deck
                return;
            case "Concede": //todo fix name
                //todo fix handler
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
}
