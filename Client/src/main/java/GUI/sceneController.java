package GUI;

import Logic.GameMaster.GameMaster;
import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
import Models.User.Player;
import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.ClientWebSocket;
import Websockets.Client.GameClient;
import Websockets.Client.IGameClient;
import Websockets.Shared.interfaces.IClientGUI;
import javafx.application.Platform;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class sceneController extends BaseController implements IClientGUI, IMemestoneGUI {

    sceneLogin login;
    sceneHomeScreen home;
    sceneCollection collections;
    sceneEditDeck editDeck;
    sceneNewDeck newDeck;
    sceneLeaderboard leaderboard;
    sceneGame game;
    IMemestoneGUI application;
    IGameClient gameClient;
    IGameMaster gameMaster;
    ArrayList<Player> leaderboardUsers;

    public sceneController(IMemestoneGUI application){
        super(application);

        gameMaster = new GameMaster();
        login = new sceneLogin(this);
        home = new sceneHomeScreen(this, gameMaster);
        this.application =  application;
        login = new sceneLogin(this);
        home = new sceneHomeScreen(this, gameMaster);
        leaderboard =  new sceneLeaderboard(this, leaderboardUsers);
        game = new sceneGame(this);
        //getGameClient().registerGUI(this);
        this.application =  application;
        this.gameClient = new GameClient(new ClientMessageGenerator(new ClientWebSocket()));
    }

    public void login(){
        application.Draw(login.getScene());

    }

    public void home(String name){
        //getGameClient().registerPlayer(name);
        application.Draw(home.getScene());
    }

    public void collections(){
        collections = new sceneCollection(this, new ArrayList<Card>());
        application.Draw(collections.getScene());
    }

    public void editDeck(){
        application.Draw(editDeck.getScene());
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
        Platform.runLater(()->{

        });
    }

    @Override
    public void processRoundStart() {
        Platform.runLater(()->{
            new java.util.Timer().schedule(new TimerTask(){
                @Override
                public void run() {
                    //TODO startRound();
                }
            },5);
        });
    }

    @Override
    public void processPlayerRegisterd(String name) {

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
        Platform.runLater(()->{

        });
    }

    @Override
    public void processGameEnd(String winner) {
        Platform.runLater(()->{

        });
    }

    @Override
    public void processPlayerActionFail() {
        Platform.runLater(()->{

        });
    }

    @Override
    public void processUpdateBoard(Card[][] board) {
        Platform.runLater(()->{

        });
    }

    @Override
    public void processUpdatePlayer(Player player) {
        Platform.runLater(()->{

        });
    }

    @Override
    public void processGetCollection(List<Card> collection) {
        gameMaster.setCollection(collection);
    }
}
