package Logic.GameMaster;

import Models.Board.IBoard;
import Models.Card.Card;
import Models.User.IUser;
import Models.Setting.Setting;
import Models.User.User;
import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.ClientWebSocket;
import Websockets.Client.IClientMessageGenerator;
import Websockets.Shared.interfaces.IClientGUI;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GameMaster implements IGameMaster, Observer {
    private IBoard board;
    private IUser user;
    private IClientMessageGenerator generator;
    private IClientGUI gui;

    public GameMaster() {
        this.generator = new ClientMessageGenerator(new ClientWebSocket());
    }

    /*Login*/
    public void logIn(String name) {
        generator.logInToServer(name);
    }

    public void signUp(String name) {
        generator.registerPlayerOnServer(name);
    }

    @Override
    public void registerGameGui(IClientGUI gui) {
        this.gui = gui;
    }

    @Override
    public void startGame() {
        generator.startGame();
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
    public void changeVolume() {
        //this is will not be implemented
    }

    @Override
    public void changeDisplay() {
        //this is will not be implemented
    }

    @Override
    public void drawCard(int amount) {
        generator.drawCard();
    }

    @Override
    public void healCard(Card card, int[] target) {
        generator.healCard(card, target);
    }

    @Override
    public void attackCard(int attack, int defend) {
        generator.attackCard(attack, defend);
    }

    @Override
    public void playCard(Card card, int location) {
        generator.playCard(card, location);
    }

    @Override
    public void resurrectMinion() {
        generator.resurrectMinion();
    }

    @Override
    public void nextTurn() {
        generator.nextTurn();
    }

    @Override
    public void escapeConcede() {
        generator.escapeConcede();
    }

    /*Menu*/


    @Override
    public void update(Observable o, Object arg) {

    }
}
