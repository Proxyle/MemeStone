package GUI;

import Logic.GameMaster.GameMaster;
import Logic.GameMaster.IGameMaster;
import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.ClientWebSocket;
import Websockets.Client.GameClient;
import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IClientGUI;
import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.TimerTask;

public class sceneController extends BaseController implements IClientGUI, IMemestoneGUI {
    sceneLogin login;
    sceneHomeScreen home;
    sceneSettings settings;
    sceneCollection collections;
    sceneEditDeck editDeck;
    sceneLeaderboard leaderboard;
    sceneGame game;
    IMemestoneGUI application;
    IGameClient gameClient;


    public sceneController(IMemestoneGUI application){
        super(application);
        login = new sceneLogin(this);
        home = new sceneHomeScreen(this);
        game = new sceneGame(this);
        this.gameClient = new GameClient(new ClientMessageGenerator(new ClientWebSocket()));
        getGameClient().registerGUI(this);
        this.application =  application;
    }

    public void login(){
        application.Draw(login.getScene());

    }

    public void home(String name){
        getGameClient().registerPlayer(name);
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
