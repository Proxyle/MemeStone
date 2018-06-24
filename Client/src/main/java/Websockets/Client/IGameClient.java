package Websockets.Client;

import Models.BoardField.*;
import Models.Card.Card;
import Models.User.Player;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.List;

public interface IGameClient {
    void registerPlayer(String userName);
    void handlePlayerRegistrationResponse(boolean success);
    void handlePlayerRegistered(String playerName);
    void registerGUI(IClientGUI clientGUI);
    void handleGameEnd(String winner);
    void handlePlayerActionFail();
    void handleUpdateBoard(Board board);
    void handleUpdatePlayer(Player player);



    void handleReceivedCollection(List<Card> collection);

    void handleRoundStart(int lobbyId);

    void handleCardBought();
}
