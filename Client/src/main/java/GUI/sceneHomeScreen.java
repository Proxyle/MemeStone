package GUI;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneHomeScreen extends Application {
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnStartGame = new Button("Start Game");
    Button btnCollection = new Button("Collection");
    Button btnLeaderboard = new Button("Leaderboard");
    Button btnSettings = new Button("Settings");
    Button btnExitGame = new Button("Exit Game");

    public void start(Stage primaryStage) throws Exception{
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(390, 10, 10, 880));

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

        // Button to open settings
        Tooltip tooltipSettings =
                new Tooltip("Press to view your collection");
        btnSettings.setTooltip(tooltipSettings);
        btnSettings.setMinWidth(buttonWidth);
        btnSettings.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                settings();
            }
        });
        grid.add(btnSettings, 1,4,1,1);

        // Button to exit game
        Tooltip tooltipExitGame =
                new Tooltip("Press to view your collection");
        btnExitGame.setTooltip(tooltipExitGame);
        btnExitGame.setMinWidth(buttonWidth);
        btnExitGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                exitGame();
            }
        });
        grid.add(btnExitGame, 1,5,1,1);

        // Define title and assign the scene for main window
        primaryStage.setTitle("MemeStone");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void startGame() {

    }

    public void collection() {

    }

    public void leaderboard() {

    }

    public void settings() {

    }

    public void exitGame() {

    }


}
