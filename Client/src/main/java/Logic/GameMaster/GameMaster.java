package Logic.GameMaster;

import Models.Card.Card;
import Models.User.IPlayer;
import Models.User.Player;
import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.ClientWebSocket;
import Websockets.Client.IClientMessageGenerator;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

    public class GameMaster implements IGameMaster {
        public  IPlayer user;
        private IClientMessageGenerator generator;
        private IClientGUI gui;

    public GameMaster() {
        this.generator = new ClientMessageGenerator(new ClientWebSocket());
    }

    public boolean logIn(String name, String password) {
        Player p = generator.logIn(name, password);
        if (p != null){
            this.user = p;
            return true;
        }
        return false;
    }

    public void signUp(String name, String password, String email) {
        generator.registerPlayerOnServer(name, password, email);
    }

    public IPlayer getUser() {
        return user;
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
        user.getDeck().add(user.getCollection().get(location));
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
    public void saveDeck(ArrayList<Card> collection, ArrayList<Card> deck){
        generator.saveDeck((ArrayList) user.getCollection(), (ArrayList) user.getDeck());
    }

    @Override
    public void buyCards() {
        generator.buyCards();
    }

    @Override
    public void getDailyQuests() {
        generator.getDailyQuest();
    }
}
