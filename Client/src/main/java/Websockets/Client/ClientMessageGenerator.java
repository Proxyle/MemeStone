package Websockets.Client;

import Models.Card.Card;
import Websockets.Shared.interfaces.IClientGUI;
import Websockets.Shared.messages.*;

public class ClientMessageGenerator implements IClientMessageGenerator {
    private Websockets.Client.IClientWebSocket clientWebSocket;



    public ClientMessageGenerator(Websockets.Client.IClientWebSocket clientWebSocket){
        this.clientWebSocket = clientWebSocket;
    }
    public void registerPlayerOnServer(String name) {


    }

    @Override
    public void logInToServer(String name) {
        clientWebSocket.start();
        clientWebSocket.send(new LoginMessage());
    }

    @Override
    public void startGame() {

    }

    @Override
    public void getCollection() {

    }

    @Override
    public void getLeaderboard() {

    }

    @Override
    public void exitGame() {

    }

    @Override
    public void getSettings() {

    }

    @Override
    public void drawCard() {

    }

    @Override
    public void healCard(int[] target) {

    }

    @Override
    public void attackCard(int attack, int defend) {
        clientWebSocket.send(new AttackMessage(attack, defend));
    }

    @Override
    public void resurrectMinion() {

    }

    @Override
    public void nextTurn() {
        clientWebSocket.send(new EndTurnMessage());
    }

    @Override
    public void escapeConcede() {
        clientWebSocket.send(new ForfeitMessage());
    }

    public void playCard(Card card, int[] location){
        clientWebSocket.send(new PlayCardMessage(card, location));
    }
    //TODO Message Methods
}
