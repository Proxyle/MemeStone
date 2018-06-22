package GUI;

import Logic.GameMaster.GameMaster;
import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Setting.Setting;
import Models.Player;
import Models.User.IPlayer;
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
        getGameClient().registerGUI(this);
        this.application =  application;
        this.gameClient = new GameClient(new ClientMessageGenerator(new ClientWebSocket()));
    }

    public void login(){
        application.Draw(login.getScene());

    }

    public void home(){
        application.Draw(home.getScene());
    }

    public void collections(){
        IPlayer user = gameMaster.getPlayer;
        collections = new sceneCollection(this,gameMaster,user.getCards(), user.getRanking());
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
            IPlayer user = gameMaster.getPlayer;
            if(winner.equals(user.getUsername())){
                game.notifyPlayer("GG EZ");
            } else{
                game.notifyPlayer("You lost! Get Shrekt!");
            }
            home();
        });
    }

    @Override
    public void processPlayerActionFail() {
        Platform.runLater(()->{
            game.notifyPlayer("No, just no...");
        });
    }

    @Override
    public void processUpdateBoard(Card[][] board) {
        Platform.runLater(()->{
            game.updateBoard((Minion[][])board);
        });
    }

    @Override
    public void processUpdatePlayer(Player player) {
        Platform.runLater(()->{
            game.updatePlayer(player);
        });
    }

    @Override
    public void processGetCollection(List<Card> collection) {
        gameMaster.setCollection(collection);
    }
}
