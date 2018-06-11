package GUI;

import Logic.GameMaster.GameMaster;
import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
import Models.Setting.Setting;
import Models.User.User;
import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.ClientWebSocket;
import Websockets.Client.GameClient;
import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IClientGUI;
import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.TimerTask;

public class sceneController extends BaseController implements IClientGUI, IMemestoneGUI {

    sceneLogin login;
    sceneHomeScreen home;
    sceneSettings settings;
    sceneCollection collections;
    sceneEditDeck editDeck;
    sceneNewDeck newDeck;
    sceneLeaderboard leaderboard;
    sceneGame game;
    IMemestoneGUI application;
    IGameClient gameClient;
    IGameMaster gameMaster;
    ArrayList<User> leaderboardUsers;

    public sceneController(IMemestoneGUI application){
        super(application);

        gameMaster = new GameMaster();
        login = new sceneLogin(this);
        home = new sceneHomeScreen(this, gameMaster);
        this.application =  application;
        login = new sceneLogin(this);
        home = new sceneHomeScreen(this, gameMaster);
        settings = new sceneSettings(this, new Setting(), gameMaster);
        leaderboard =  new sceneLeaderboard(this, leaderboardUsers);
        game = new sceneGame(this);
        getGameClient().registerGUI(this);
        this.application =  application;
        this.gameClient = new GameClient(new ClientMessageGenerator(new ClientWebSocket()));
    }

    public void login(){
        application.Draw(login.getScene());

    }

    public void home(String name){
        getGameClient().registerPlayer(name);
        application.Draw(home.getScene());
    }

    public void settings(){
        settings = new sceneSettings(this, new Setting(),gameMaster);
        application.Draw(settings.getScene());
    }

    public void collections(){
        collections = new sceneCollection(this, new ArrayList<Card>());
        application.Draw(collections.getScene());
    }

    public void editDeck(){
        application.Draw(editDeck.getScene());
    }

    public void newDeck(){
        //application.Draw(newDeck.getScene());
    }

    public void leaderboard(){
        leaderboard =  new sceneLeaderboard(this, leaderboardUsers);
        application.Draw(leaderboard.getScene());
    }

    public void game(){
        game = new sceneGame(this);
        application.Draw(game.getScene());
    }

    @Override
    public void processRegistrationResponse(boolean resp) {

    }

    @Override
    public void processRoundStart() {
        Platform.runLater(()->{
            new java.util.Timer().schedule(new TimerTask(){
                @Override
                public void run() {
                    //TODO startRound();
                }
            },5000);
        });
    }

    @Override
    public void processPlayerRegisterd() {
        //TODO
    }

    public void processPlayerRegisterd(boolean resp) {
        Platform.runLater(() -> {
            if(resp)
            {

            }
            else
            {

            }
        });

    }

    @Override
    public void Draw(Scene guiScene) {

    }
}
