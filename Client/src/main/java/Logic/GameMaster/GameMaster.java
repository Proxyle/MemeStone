package Logic.GameMaster;

import Models.Board.IBoard;
import Models.Card.Card;
import Models.User.IPlayer;
import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.ClientWebSocket;
import Websockets.Client.IClientMessageGenerator;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameMaster implements IGameMaster, Observer {
    private IBoard board;
    public IPlayer user;
    private IClientMessageGenerator generator;
    private IClientGUI gui;

    private List<Card> collection;
    private List<Card> deck;

    public void setCollection(List<Card> collection) {
        this.collection = collection;
    }

    public GameMaster() {
        this.generator = new ClientMessageGenerator(new ClientWebSocket());
        this.deck = new ArrayList<>();
    }

    /*Login*/
    public void logIn(String name, String password) {
        generator.logIn(name, password);
    }

    public void signUp(String name, String password, String email) {
        generator.registerPlayerOnServer(name, password, email);
    }

    @Override
    public void registerGameGui(IClientGUI gui) {
        this.gui = gui;
    }

    @Override
    public void collection() {
        generator.getCollection();
    }

    @Override
    public void leaderboard() {
        generator.getLeaderboard();
    }

    @Override
    public void exitGame() {
        generator.exitGame();
    }

    @Override
    public void getSettings() {
        generator.getSettings();
    }

    @Override
    public void attackCard(int attack, int defend) {
        generator.attackCard(attack, defend);
    }

    @Override
    public void playCard(Card card, int[] location) {
        generator.playCard(card, location);
    }

    @Override
    public void nextTurn() {
        generator.nextTurn();
    }

    @Override
    public void escapeConcede() {
        generator.escapeConcede();
    }

    @Override
    public void addCardToDeck(int location, List<Card> collection, List<Card> deck) {
        deck.add(collection.get(location));
        collection.remove(location);
    }

    @Override
    public void removeCardFromDeck(int location, List<Card> collection, List<Card> deck) {
        if(deck.size() > 30){
            deck.remove(location);
            collection.add(deck.get(location));
        }
    }
    @Override
    public void saveDeck(ArrayList<Card> collections, ArrayList<Card> deck){
        //TODO send to rest? or websockets
        //send back to collections
    }

    @Override
    public void buyCards() {
        //TODO send to server
    }

    @Override
    public String[] getTaskQuests() {
        //TODO get 3 daily quests from rest
        return new String[0];
    }

    /*Menu*/
    @Override
    public void update(Observable o, Object arg) {

    }
}
