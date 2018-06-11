package Websockets.Client;

import Models.Card.Card;
import Models.User.User;
import Websockets.Shared.interfaces.IClientGUI;

public interface IGameClient {
    void registerPlayer(String userName);
    void handlePlayerRegistrationResponse(boolean success);
    void handlePlayerRegistered(String playerName);
    void registerGUI(IClientGUI clientGUI);
    void handlePlayerTurn();
    void handleGameEnd(String winner);
    void handlePlayerActionFail();
    void handleUpdateBoard(Card[][] board);
    void handleUpdatePlayer(User player);
}
