package Websockets.Client;

import Models.BoardField.*;
import Models.Card.Card;
import Models.User.Player;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.List;

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
    public void handleGameEnd(String winner) {
        clientGUI.processGameEnd(winner);
    }

    @Override
    public void handlePlayerActionFail() {
        clientGUI.processPlayerActionFail();
    }

    @Override
    public void handleUpdateBoard(Board board) {
        clientGUI.processUpdateBoard(board);
    }

    @Override
    public void handleUpdatePlayer(Player player) {
        clientGUI.processUpdatePlayer(player);
    }

    @Override
    public void handleReceivedCollection(List<Card> collection) {
        clientGUI.processGetCollection(collection);
    }

    @Override
    public void handleRoundStart(int lobbyId) {
        clientGUI.processRoundStart(lobbyId);
    }

    @Override
    public void handleCardBought() {
        clientGUI.processCardBought();
    }

    @Override
    public void registerPlayer(String userName) {
        //nee
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
