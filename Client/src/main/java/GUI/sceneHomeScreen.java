package GUI;


import Logic.GameMaster.IGameMaster;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class sceneHomeScreen{
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnStartGame = new Button("Start Game");
    Button btnCollection = new Button("Collection");
    Button btnLeaderboard = new Button("Leaderboard");
    Button btnSettings = new Button("Settings");
    Button btnExitGame = new Button("Exit Game");
    Label lblQuest1 = new Label();
    Label lblQuest2 = new Label();
    Label lblQuest3 = new Label();

    Scene scene;
    sceneController controller;
    IGameMaster gameMaster;

    public sceneHomeScreen(sceneController controller, IGameMaster gameMaster){
        scene = makeScene();
        this.controller = controller;
        this.gameMaster = gameMaster;
    }

    public Scene makeScene(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(390, 10, 10, 880));

        VBox vboxQuests = new VBox();

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(grid);


        // Button to start game
        Tooltip tooltipStartGame =
                new Tooltip("Press to start a new game");
        btnStartGame.setTooltip(tooltipStartGame);
        btnStartGame.setMinWidth(buttonWidth);
        btnStartGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                startGame();
            }
        });
        grid.add(btnStartGame, 1,1,1,1);

        // Button to open collection
        Tooltip tooltipCollection =
                new Tooltip("Press to view your collection");
        btnCollection.setTooltip(tooltipCollection);
        btnCollection.setMinWidth(buttonWidth);
        btnCollection.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                collection();
            }
        });
        grid.add(btnCollection, 1,2,1,1);

        // Button to open leaderboard
        Tooltip tooltipLeaderboard =
                new Tooltip("Press to view the leaderboard");
        btnLeaderboard.setTooltip(tooltipLeaderboard);
        btnLeaderboard.setMinWidth(buttonWidth);
        btnLeaderboard.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                leaderboard();
            }
        });
        grid.add(btnLeaderboard, 1,3,1,1);

        // Button to exit game
        Tooltip tooltipExitGame =
                new Tooltip("Press to exit game");
        btnExitGame.setTooltip(tooltipExitGame);
        btnExitGame.setMinWidth(buttonWidth);
        btnExitGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                exitGame();
            }
        });
        grid.add(btnExitGame, 1,4,1,1);

        String[] dailyQuests = { "FAKA1", "FAKA2", "FAKA3" }; //gameMaster.getDailyQuests();
        lblQuest1.setText(dailyQuests[0]);
        lblQuest2.setText(dailyQuests[1]);
        lblQuest3.setText(dailyQuests[2]);

        vboxQuests.getChildren().addAll(lblQuest1,lblQuest2,lblQuest3);
        grid.add(vboxQuests, 1,5,1,1);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void startGame() {
        controller.game();
    }

    public void collection() {
        controller.collections();
    }

    public void leaderboard() {
        controller.leaderboard();
    }

    public void exitGame() {
        gameMaster.exitGame();
    }
}
