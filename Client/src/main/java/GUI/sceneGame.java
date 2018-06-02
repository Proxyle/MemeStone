package GUI;

import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
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
import javafx.scene.layout.VBox;
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

    int opponentHealth;
    int opponentEnergy;
    int heroHealth;
    int heroEnergy;

    //Card hold arrays
    private Card[] cardsOpponentHand;
    private Card[] cardsOpponentLeftLane;
    private Card[] cardsOpponentRightLane;
    private Card[] cardsHeroHand;
    private Card[] cardsHeroLeftLane;
    private Card[] cardsHeroRightLane;

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

    //Panes
    GridPane gridSettings;
    GridPane gridOpponentHand;
    GridPane gridOpponentStats;
    GridPane gridOpponentRightLane;
    GridPane gridOpponentLeftLane;
    GridPane gridHeroHand;
    GridPane gridHeroStats;
    GridPane gridHeroRightLane;
    GridPane gridHeroLeftLane;
    GridPane gridGameField;
    VBox vBoxOpponent;
    VBox vBoxHero;

    //Logic
    IGameMaster gameMaster;

    Scene scene;
    sceneController controller;

    public sceneGame(sceneController controller/*, IGameMaster gameMaster*/){
        this.gameMaster = gameMaster;
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define Panes

        //Grid opponent hand
        gridOpponentHand = makeGridWithEmptySlots(6);

        //Grid opponent stats
        gridOpponentStats = new GridPane();
        gridOpponentStats.setHgap(10);

        //Grid opponent left lane
        gridOpponentLeftLane = makeGridWithEmptySlots(3);

        //Grid opponent right lane
        gridOpponentRightLane = makeGridWithEmptySlots(3);

        //Grid hero hand
        gridHeroHand = makeGridWithEmptySlots(6);

        //Grid hero stats
        gridHeroStats = new GridPane();
        gridHeroStats.setHgap(10);

        //Grid hero left lane
        gridHeroLeftLane = makeGridWithEmptySlots(3);

        //Grid hero right lane
        gridHeroRightLane = makeGridWithEmptySlots(3);

        //Grid gamefield
        gridGameField = new GridPane();
        gridGameField.add(gridOpponentLeftLane,2,1);
        gridGameField.add(gridOpponentRightLane,4,1);
        gridGameField.add(gridHeroLeftLane,2,3);
        gridGameField.add(gridHeroRightLane,4,3);
        gridGameField.setGridLinesVisible(true);

        //Settings GridPane
        gridSettings = new GridPane();
        gridSettings.setHgap(10);

        //vBox
        vBoxHero = new VBox();
        vBoxHero.getChildren().addAll(gridHeroStats, gridHeroHand);

        vBoxOpponent = new VBox();
        vBoxOpponent.getChildren().addAll(gridOpponentHand, gridHeroStats);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setTop(vBoxOpponent);
        layoutPane.setCenter(gridGameField);
        layoutPane.setBottom(vBoxHero);
        layoutPane.setRight(gridSettings);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(layoutPane);

        //BuffLeft
        ivBuffLeft = new ImageView();
        ivBuffLeft.setImage(iBuffLeft);
        ivBuffLeft.setFitWidth(50);
        ivBuffLeft.setFitHeight(50);
        gridGameField.add(ivBuffLeft,1,2);

        //BuffRight
        ivBuffRight = new ImageView();
        ivBuffRight.setImage(iBuffRight);
        ivBuffRight.setFitWidth(50);
        ivBuffRight.setFitHeight(50);
        gridGameField.add(ivBuffRight,5,2);

        //Opponents Health
        pbHealthBarOpponent = new ProgressBar();
        pbHealthBarOpponent.setMinWidth(380);
        gridOpponentStats.add(pbHealthBarOpponent, 1,1);
        lblHealthOpponent = new Label("Health: 50/50");
        gridOpponentStats.add(lblHealthOpponent, 1,1);

        //Opponents Energy
        pbEnergyBarOpponent = new ProgressBar();
        pbEnergyBarOpponent.setMinWidth(380);
        gridOpponentStats.add(pbEnergyBarOpponent,3, 1);
        lblEnergyOpponent = new Label("Energy: 3/10");
        gridOpponentStats.add(lblEnergyOpponent, 3,1);

        //Heros Health
        pbHealthBarHero = new ProgressBar();
        pbHealthBarHero.setMinWidth(380);
        gridHeroStats.add(pbHealthBarHero, 1,1);
        lblHealthHero = new Label("Health: 50/50");
        gridHeroStats.add(lblHealthHero, 1,1);

        //Heros Energy
        pbEnergyBarHero = new ProgressBar();
        pbEnergyBarHero.setMinWidth(380);
        gridHeroStats.add(pbEnergyBarHero,3, 1);
        lblEnergyHero = new Label("Energy: 3/10");
        gridHeroStats.add(lblEnergyHero, 3,1);

        //Opponents Hero
        ivHeroOpponent = new ImageView();
        ivHeroOpponent.setImage(iOpponentsHero);
        ivHeroOpponent.setFitWidth(120);
        ivHeroOpponent.setFitHeight(120);
        gridOpponentStats.add(ivHeroOpponent,2,1);


        //Heros Hero
        ivHero= new ImageView();
        ivHero.setImage(iHerosHero);
        ivHero.setFitWidth(120);
        ivHero.setFitHeight(120);
        gridHeroStats.add(ivHero,2,1);

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
        gridGameField.add(btnEndTurn, 5,2);

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
        gridGameField.add(btnOptions, 5,3);

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

        //Create card holder arrays
        cardsHeroHand = new Card[6];
        cardsHeroLeftLane = new Card[3];
        cardsHeroRightLane = new Card[3];
        cardsOpponentHand = new Card[6];
        cardsOpponentLeftLane = new Card[3];
        cardsOpponentRightLane = new Card[3];

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
        //TODO save coordinates somewhere and shit like fuck me what am I doing aaah I have an idea but that needs server side editing and we dont have time and shit
        ivEmptySlot.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> SquareClick(GridPane.getRowIndex( ivEmptySlot),GridPane.getColumnIndex( ivEmptySlot)));
        return ivEmptySlot;
    }

    private GridPane makeGridWithEmptySlots(int amount){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        for(int i=1; i<(amount + 1); i++){
            grid.add(emptySlotImage(), i,1,1,1);
        }
        return grid;
    }

    public void endTurn() {
        gameMaster.nextTurn();
    }

    public void options() {
        if (gridSettings.isVisible())
            gridSettings.setVisible(false);
        else if (!gridSettings.isVisible())
            gridSettings.setVisible(true);
    }

    public void forfeit() {

    }

    public void settings() {

    }

    public void exitGame() {
        gameMaster.exitGame();
    }

    public void drawCard(int amount) {
        if (checkHandSpace(amount)){
            for (int i = 0; i < 5; i++){
                //TODO drawCards and stuff
            }
        }
    }

    private boolean checkHandSpace(int amount){
        int freeSpots = 0;
        for(int i = 0; i < 5; i++){
            if (cardsHeroHand[i].equals(null))
                freeSpots++;
        }
        if (freeSpots >= amount)
            return true;

        return false;
    }

    private void placeCard(Card card, int xposSelected, int yposSelected, int xposPlace, int yposPlace){

    }
}
