package Websockets.Client;

public interface IGameClient {
    void registerPlayer(String userName);
    void handlePlayerRegistrationResponse(boolean success);
    void processRoundStarted();
    void handlePlayerRegistered(String playerName);
}
