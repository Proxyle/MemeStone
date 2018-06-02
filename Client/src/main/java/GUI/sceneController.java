package GUI;

import Logic.GameMaster.GameMaster;
import Logic.GameMaster.IGameMaster;
import Websockets.Shared.interfaces.IClientGUI;
import javafx.scene.Scene;

public class sceneController implements IClientGUI {
    sceneLogin login;
    sceneHomeScreen home;
    sceneSettings settings;
    sceneCollection collections;
    sceneEditDeck editDeck;
    sceneNewDeck newDeck;
    sceneLeaderboard leaderboard;
    sceneGame game;
    IMemestoneGUI application;
    IGameMaster gameMaster;

    public sceneController(IMemestoneGUI application){
        gameMaster = new GameMaster();
        login = new sceneLogin(this);
        home = new sceneHomeScreen(this, gameMaster);
        this.application =  application;
    }

    public void login(){
        application.Draw(login.getScene());
    }

    public void home(){
        application.Draw(home.getScene());
    }

    public void settings(){
        settings = new sceneSettings(this, gameMaster.getSettings());
        application.Draw(settings.getScene());
    }

    public void collections(){
        collections = new sceneCollection(this, gameMaster.collection());
        application.Draw(collections.getScene());
    }

    public void editDeck(){
        application.Draw(editDeck.getScene());
    }

    public void newDeck(){
        //application.Draw(newDeck.getScene());
    }

    public void leaderboard(){
        leaderboard =  new sceneLeaderboard(this, gameMaster.leaderboard());
        application.Draw(leaderboard.getScene());
    }

    public void game(){
        game = new sceneGame(this);
        application.Draw(game.getScene());
    }

    public void processRegistrationResponse(boolean resp) {

    }

    public void processRoundStart() {

    }

    public void processPlayerRegisterd() {

    }
}
