package GUI;

import javafx.scene.Scene;

public class sceneController {
    sceneLogin login;
    sceneHomeScreen home;
    sceneSettings settings;
    sceneCollection collections;
    sceneEditDeck editDeck;
    sceneLeaderboard leaderboard;
    sceneGame game;
    IMemestoneGUI application;

    public sceneController(IMemestoneGUI application){
    login = new sceneLogin(this);
    home = new sceneHomeScreen(this);
    settings = new sceneSettings(this);
    leaderboard =  new sceneLeaderboard(this);
    game = new sceneGame(this);
    this.application =  application;
    }

    public void login(){
        application.Draw(login.getScene());
    }

    public void home(){
        application.Draw(home.getScene());
    }

    public void settings(){
        application.Draw(settings.getScene());
    }

    public void collections(){
        application.Draw(collections.getScene());
    }

    public void editDeck(){
        application.Draw(editDeck.getScene());
    }

    public void leaderboard(){
        application.Draw(leaderboard.getScene());
    }

    public void game(){
        application.Draw(game.getScene());
    }
}
