package Websockets.Client;

import Models.Card.Card;
import Models.User.User;
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

    }

    @Override
    public void handleGameEnd(String winner) {
        
    }

    @Override
    public void handlePlayerActionFail() {

    }

    @Override
    public void handleRoundStart() {

    }

    @Override
    public void handleUpdateBoard(Card[][] board) {

    }

    @Override
    public void handleUpdatePlayer(User player) {

    }

    @Override
    public void handlePlayerRegistrationResponse(boolean success) {

    }

    @Override
    public void processRoundStarted() {

    }

    @Override
    public void handlePlayerRegistered(String playerName) {

    }
}
