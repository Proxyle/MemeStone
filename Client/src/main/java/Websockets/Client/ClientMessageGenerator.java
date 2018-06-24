package Websockets.Client;


import Models.Card.Card;
import Models.User.Player;
import REST.Client.MemeStoneRest;
import Websockets.Shared.messages.*;

import java.util.ArrayList;


public class ClientMessageGenerator implements IClientMessageGenerator {
    private Websockets.Client.IClientWebSocket clientWebSocket;

    public ClientMessageGenerator(Websockets.Client.IClientWebSocket clientWebSocket){
        this.clientWebSocket = clientWebSocket;
    }

    public void registerPlayerOnServer(String name, String password, String email) {
        MemeStoneRest rest = new MemeStoneRest();
        rest.register(name, password, email);
    }

    public Player logIn(String name, String password) {
        MemeStoneRest rest = new MemeStoneRest();
        Player p = rest.Login(name, password);
        return p;
    }

    @Override
    public void getCollection() {
        clientWebSocket.send(new GetCollectionMessage(new ArrayList<Card>()));
    }

    @Override
    public void getLeaderboard() {
        clientWebSocket.send(new GetLeaderBoardMessage());
    }

    @Override
    public void exitGame(int lobbyId) {
        clientWebSocket.send(new ForfeitMessage(lobbyId));
    }

    @Override
    public void getSettings() {
        clientWebSocket.send(new GetSettingsMessage());
    }

    @Override
    public void attackCard(int lobbyId, int attack, int defend) {
        clientWebSocket.send(new AttackMessage(lobbyId, attack, defend));
    }

    @Override
    public void nextTurn(int lobbyId) {
        clientWebSocket.send(new EndTurnMessage(lobbyId));
    }

    @Override
    public void escapeConcede(int lobbyId) {
        clientWebSocket.send(new ForfeitMessage(lobbyId));
    }

    public void playCard(int lobbyId, Card card, int[] location){
        clientWebSocket.send(new PlayCardMessage(lobbyId, card, location));
    }

    @Override
    public void saveDeck(ArrayList<Card> collection, ArrayList<Card> deck) {
        clientWebSocket.send(new SaveDeckMessage(collection, deck));
    }

    @Override
    public void buyCards(int id) {
        clientWebSocket.send(new BuyCardMessage(id));
    }

    @Override
    public void getDailyQuest() {
        //something with rest
    }

    //TODO Message Methods
}
