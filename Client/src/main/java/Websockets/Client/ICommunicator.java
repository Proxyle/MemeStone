package Websockets.Client;

public interface ICommunicator {
    void setGameMaster(IGameMaster gameMaster);
    void start();
    void stop();
}
