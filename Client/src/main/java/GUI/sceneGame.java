package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneGame{
    //Properties
    double buttonWidth = 150;
    Image iHerosHero = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image iOpponentsHero = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image iCardBack = new Image("file:C:\\Test\\MemestonePicas\\EmptySlot.jpg", 120, 120, false, false);
    Image iEmptySlot = new Image("file:C:\\Test\\MemestonePicas\\EmptySlot.jpg", 120, 120, false, false);
    Image iBuffLeft = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image iBuffRight = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image imgLoad;

    //Buttons
    Button btnEndTurn = new Button("End Turn");
    Button btnOptions = new Button("Options");
    Button btnForfeit = new Button("Forfeit");
    Button btnSettings = new Button("Settings");
    Button btnExitGame = new Button("Exit Game");

    ImageView ivEmptySlot;
    ImageView ivCardBack;
    ImageView ivHeroOpponent;
    ImageView ivHero;
    ImageView ivBuffLeft;
    ImageView ivBuffRight;

    ProgressBar pbHealthBarOpponent;
    ProgressBar pbHealthBarHero;
    ProgressBar pbEnergyBarOpponent;
    ProgressBar pbEnergyBarHero;

    Label lblHealthOpponent;
    Label lblHealthHero;
    Label lblEnergyOpponent;
    Label lblEnergyHero;

    Scene scene;
    sceneController controller;

    public sceneGame(sceneController controller){
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define Panes

        //Main Game GridPane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(-110, 10, 10, 10));

        //Settings GridPane
        GridPane gridSettings = new GridPane();
        gridSettings.setHgap(10);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(grid);
        layoutPane.setRight(gridSettings);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(layoutPane);

        //Set empty image slots

        //Opponents hand
        for(int i=2; i<8; i++){
            grid.add(emptySlotImage(), i,1,1,1);
        }

        //Opponents field
        for(int i=2; i<5; i++){
            grid.add(emptySlotImage(), i,4,1,1);
        }
        for(int i=6; i<9; i++){
            grid.add(emptySlotImage(), i,4,1,1);
        }

        //Heros field
        for(int i=2; i<5; i++){
            grid.add(emptySlotImage(), i,6,1,1);
        }
        for(int i=6; i<9; i++){
            grid.add(emptySlotImage(), i,6,1,1);
        }

        //Heros Hand
        for(int i=2; i<8; i++){
            grid.add(emptySlotImage(), i,9,1,1);
        }

        //BuffLeft
        ivBuffLeft = new ImageView();
        ivBuffLeft.setImage(iBuffLeft);
        ivBuffLeft.setFitWidth(50);
        ivBuffLeft.setFitHeight(50);
        grid.add(ivBuffLeft,1,5);

        //BuffRight
        ivBuffRight = new ImageView();
        ivBuffRight.setImage(iBuffRight);
        ivBuffRight.setFitWidth(50);
        ivBuffRight.setFitHeight(50);
        grid.add(ivBuffRight,9,5);

        //Opponents Health
        pbHealthBarOpponent = new ProgressBar();
        pbHealthBarOpponent.setMinWidth(380);
        grid.add(pbHealthBarOpponent, 2,3,3,1);
        lblHealthOpponent = new Label("Health: 50/50");
        grid.add(lblHealthOpponent, 2,3,1,1);

        //Opponents Energy
        pbEnergyBarOpponent = new ProgressBar();
        pbEnergyBarOpponent.setMinWidth(380);
        grid.add(pbEnergyBarOpponent,6, 3, 3,1);
        lblHealthOpponent = new Label("Energy: 3/10");
        grid.add(lblHealthOpponent, 6,3,1,1);

        //Heros Health
        pbHealthBarHero = new ProgressBar();
        pbHealthBarHero.setMinWidth(380);
        grid.add(pbHealthBarHero, 2,7,3,1);
        lblHealthHero = new Label("Health: 50/50");
        grid.add(lblHealthHero, 2,7,1,1);

        //Heros Energy
        pbEnergyBarHero = new ProgressBar();
        pbEnergyBarHero.setMinWidth(380);
        grid.add(pbEnergyBarHero,6, 7, 3,1);
        lblHealthHero = new Label("Energy: 3/10");
        grid.add(lblHealthHero, 6,7,1,1);

        //Opponents Hero
        ivHeroOpponent = new ImageView();
        ivHeroOpponent.setImage(iOpponentsHero);
        ivHeroOpponent.setFitWidth(120);
        ivHeroOpponent.setFitHeight(120);
        grid.add(ivHeroOpponent,5,3);


        //Heros Hero
        ivHero= new ImageView();
        ivHero.setImage(iHerosHero);
        ivHero.setFitWidth(120);
        ivHero.setFitHeight(120);
        grid.add(ivHero,5,7);

        //Buttons------------------------------------------------------------------------

        // Button to end turn
        Tooltip tooltipStartGame =
                new Tooltip("Press to start a new game");
        btnEndTurn.setTooltip(tooltipStartGame);
        btnEndTurn.setMinWidth(buttonWidth);
        btnEndTurn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                endTurn();
            }
        });
        grid.add(btnEndTurn, 10,6,1,1);

        // Button to open options
        Tooltip tooltipCollection =
                new Tooltip("Press to view your collection");
        btnOptions.setTooltip(tooltipCollection);
        btnOptions.setMinWidth(buttonWidth);
        btnOptions.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                options();
            }
        });
        gridSettings.add(btnOptions, 1,1);

        // Button to forfeit
        Tooltip tooltipLeaderboard =
                new Tooltip("Press to view the leaderboard");
        btnForfeit.setTooltip(tooltipLeaderboard);
        btnForfeit.setMinWidth(buttonWidth);
        btnForfeit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                forfeit();
            }
        });
        gridSettings.add(btnForfeit, 1,2);

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
        gridSettings.add(btnSettings, 1,3);

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
        gridSettings.add(btnExitGame, 1,4);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    private ImageView emptySlotImage(){
        ivEmptySlot = new ImageView();
        ivEmptySlot.setImage(iEmptySlot);
        ivEmptySlot.setFitWidth(120);
        ivEmptySlot.setFitHeight(200);
        return ivEmptySlot;
    }

    public void endTurn() {

    }

    public void options() {

    }

    public void forfeit() {

    }

    public void settings() {

    }

    public void exitGame() {
        System.exit(0);
    }
}
