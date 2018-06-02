package Websockets.Client;

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
    public void handlePlayerRegistrationResponse(boolean success) {

    }

    @Override
    public void processRoundStarted() {

    }

    @Override
    public void handlePlayerRegistered(String playerName) {

    }
}
