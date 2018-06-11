package Websockets.Client;

import Models.Card.Card;
import Models.User.Player;
import Websockets.Shared.interfaces.IClientGUI;

public class GameClient implements IGameClient {

    IClientMessageGenerator messageGenerator;

    private IClientGUI clientGUI;

    public GameClient(IClientMessageGenerator generator) {
        this.messageGenerator = generator;
    }

    public void registerGUI(IClientGUI clientGUI){
        this.clientGUI = clientGUI;
    }

    @Override
    public void registerPlayer(String userName) {
        messageGenerator.registerPlayerOnServer(userName);
    }

    @Override
    public void handlePlayerTurn() {
        clientGUI.processRoundStart();
    }

    @Override
    public void handleGameEnd(String winner) {
        clientGUI.processGameEnd(winner);
    }

    @Override
    public void handlePlayerActionFail() {
        clientGUI.processPlayerActionFail();
    }

    @Override
    public void handleUpdateBoard(Card[][] board) {
        clientGUI.processUpdateBoard(board);
    }

    @Override
    public void handleUpdatePlayer(Player player) {
        clientGUI.processUpdatePlayer(player);
    }

    @Override
    public void handlePlayerRegistrationResponse(boolean success) {
        clientGUI.processRegistrationResponse(success);
    }

    @Override
    public void handlePlayerRegistered(String playerName) {
        clientGUI.processPlayerRegisterd(playerName);
    }
}
