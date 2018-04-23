package Websockets.Client;

import Logic.GameMaster.IGameMaster;

public interface ICommunicator {
    void setGameMaster(IGameMaster gameMaster);
    void start();
    void stop();
}
