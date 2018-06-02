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

    }

    @Override
    public void startGame() {

    }

    @Override
    public void collection() {

    }

    @Override
    public void leaderboard() {

    }

    @Override
    public void exitGame() {

    }

    @Override
    public void getSettings() {

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

    }

    @Override
    public void healCard(Card target) {

    }

    @Override
    public void attackCard(Card target) {

    }

    @Override
    public void resurrectMinion() {

    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void escapeConcede() {

    }

    /*Menu*/


    @Override
    public void update(Observable o, Object arg) {

    }
}
