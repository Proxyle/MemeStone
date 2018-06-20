package Websockets.Client;


import Models.Card.Card;
import Websockets.Shared.messages.*;


public class ClientMessageGenerator implements IClientMessageGenerator {
    private Websockets.Client.IClientWebSocket clientWebSocket;



    public ClientMessageGenerator(Websockets.Client.IClientWebSocket clientWebSocket){
        this.clientWebSocket = clientWebSocket;
    }
    public void registerPlayerOnServer(String name) {
        clientWebSocket.start();
        clientWebSocket.send(new RegisterPlayerMessage(name));

    }

    @Override
    public void logInToServer(String name) {
        clientWebSocket.start();
        clientWebSocket.send(new LoginMessage(name));
    }

    @Override
    public void getCollection() {
        clientWebSocket.send(new GetCollectionMessage());
    }

    @Override
    public void getLeaderboard() {
        clientWebSocket.send(new GetLeaderBoardMessage());
    }

    @Override
    public void exitGame() {
        clientWebSocket.send(new ForfeitMessage());
    }

    @Override
    public void getSettings() {
        clientWebSocket.send(new GetSettingsMessage());
    }

    @Override
    public void attackCard(int attack, int defend) {
        clientWebSocket.send(new AttackMessage(attack, defend));
    }

    @Override
    public void nextTurn() {
        clientWebSocket.send(new EndTurnMessage());
    }

    @Override
    public void escapeConcede() {
        clientWebSocket.send(new ForfeitMessage());
    }

    public void playCard(Card card, int location){
        clientWebSocket.send(new PlayCardMessage(card, location));
    }
    //TODO Message Methods
}
