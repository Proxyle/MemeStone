package Websockets.Client;

import Websockets.Shared.interfaces.IClientGUI;

public interface IGameClient {
    void registerPlayer(String userName);
    void handlePlayerRegistrationResponse(boolean success);
    void processRoundStarted();
    void handlePlayerRegistered(String playerName);
    void registerGUI(IClientGUI clientGUI);
}
