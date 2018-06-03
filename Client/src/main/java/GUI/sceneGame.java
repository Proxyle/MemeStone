package GUI;

import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
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

import java.util.ArrayList;

public class sceneGame{
    //Properties
    ArrayList<Integer> clickOne;
    ArrayList<Integer> clickTwo;
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

    GridPane gridOpponentHand;
    GridPane gridOpponentStats;
    GridPane gridHeroHand;
    GridPane gridHeroStats;
    GridPane gridGameCardField;
    GridPane gridGameField;
    GridPane gridSettings;
    VBox vbOpponentTop;
    VBox vbHeroBottom;

    ArrayList<Card> opponentHand;
    ArrayList<Card> heroHand;
    Card[][] gameField;


    Scene scene;
    sceneController controller;
    IGameMaster gameMaster;

    public sceneGame(sceneController controller, IGameMaster gameMaster){
        scene = makeScene();
        this.controller = controller;
        this.gameMaster = gameMaster;
    }

    public Scene makeScene(){
        //Define Panes

        //Settings GridPane
        gridSettings = new GridPane();
        gridSettings.setHgap(10);

        gridOpponentHand = fillGridWithEmptyCards(6, 0, 0);
        gridHeroHand = fillGridWithEmptyCards(6, 1, 2);
        gridGameCardField = fillGameCardFieldWithEmptyCard();
        gridGameField = new GridPane();

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setTop(vbOpponentTop);
        layoutPane.setCenter(gridGameField);
        layoutPane.setBottom(vbHeroBottom);
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
        gridGameField.add(ivBuffLeft,1,1);

        //BuffRight
        ivBuffRight = new ImageView();
        ivBuffRight.setImage(iBuffRight);
        ivBuffRight.setFitWidth(50);
        ivBuffRight.setFitHeight(50);
        gridGameField.add(ivBuffLeft,3,1);

        //Opponents Health
        pbHealthBarOpponent = new ProgressBar();
        pbHealthBarOpponent.setMinWidth(380);
        gridOpponentStats.add(pbHealthBarOpponent, 1,1);
        lblHealthOpponent = new Label("Health: 50/50");
        gridOpponentStats.add(lblHealthOpponent, 1,1);

        //Opponents Energy
        pbEnergyBarOpponent = new ProgressBar();
        pbEnergyBarOpponent.setMinWidth(380);
        gridOpponentStats.add(pbEnergyBarOpponent, 1,3);
        lblHealthOpponent = new Label("Energy: 3/10");
        gridOpponentStats.add(lblHealthOpponent, 1,3);

        //Heros Health
        pbHealthBarHero = new ProgressBar();
        pbHealthBarHero.setMinWidth(380);
        gridHeroStats.add(pbHealthBarHero, 1,1);
        lblHealthHero = new Label("Health: 50/50");
        gridHeroStats.add(lblHealthHero, 1,1);

        //Heros Energy
        pbEnergyBarHero = new ProgressBar();
        pbEnergyBarHero.setMinWidth(380);
        gridHeroStats.add(pbEnergyBarHero, 1,3);
        lblHealthHero = new Label("Energy: 3/10");
        gridHeroStats.add(lblHealthHero, 1,3);

        //Opponents Hero
        ivHeroOpponent = new ImageView();
        ivHeroOpponent.setImage(iOpponentsHero);
        ivHeroOpponent.setFitWidth(120);
        ivHeroOpponent.setFitHeight(120);
        gridOpponentStats.add(ivHeroOpponent, 1,2);


        //Heros Hero
        ivHero= new ImageView();
        ivHero.setImage(iHerosHero);
        ivHero.setFitWidth(120);
        ivHero.setFitHeight(120);
        gridHeroStats.add(ivHero, 1,2);

        //Buttons---------------------------------------------------------------------

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
        gridGameField.add(btnEndTurn, 4,1);

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
        gridGameField.add(btnOptions, 1,4);

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
        gridSettings.add(btnForfeit, 1,1);


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
        gridSettings.add(btnExitGame, 1,1);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    private ImageView emptySlotImage(int player, int field){
        //field 0 = opponent hand
        //field 1 = game field
        //field 2 = hero hand
        ivEmptySlot = new ImageView();
        ivEmptySlot.setImage(iEmptySlot);
        ivEmptySlot.setFitWidth(120);
        ivEmptySlot.setFitHeight(200);
        ivEmptySlot.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> cardClick(GridPane.getRowIndex( ivEmptySlot),GridPane.getColumnIndex( ivEmptySlot), player, field));
        return ivEmptySlot;
    }

    private GridPane fillGridWithEmptyCards(int amount, int player, int field){
        GridPane grid = new GridPane();
        for (int i = 0; i < amount; i++){
            grid.add(emptySlotImage(player, field),i,0);
        }
        return grid;
    }

    private GridPane fillGameCardFieldWithEmptyCard(){
        GridPane grid = new GridPane();
        for (int i = 0; i < 6; i++){
            grid.add(emptySlotImage(0, 1),i,0);
            grid.add(emptySlotImage(1, 1),i,1);
        }
        return grid;
    }

    public void removeNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {

        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            if (node instanceof GridPane && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                GridPane grid = (GridPane) node;
                gridPane.getChildren().remove(grid);
                break;
            }
        }
    }

    public boolean checkNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        ObservableList<Node> children = gridPane.getChildren();
        for (Node node : children) {
            if (node instanceof GridPane && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                return true;
            }
        }
        return false;
    }

    public void cardClick(int x, int y, int player, int field){
        if (field == 0){
        } else if (clickOne == null){
            clickOne = new ArrayList<>();
            clickOne.add(0, x);
            clickOne.add(1, y);
            clickOne.add(2, player);
            clickOne.add(3, field);
        } else if (clickTwo == null){
            clickTwo = new ArrayList<>();
            clickTwo.add(0, x);
            clickTwo.add(1, y);
            clickTwo.add(3, player);
            clickTwo.add(3, field);

            checkAction();
        }
    }

    private void checkAction(){
        if (clickOne.get(3) == 1){

        }
    }

    public void endTurn() {
        gameMaster.nextTurn();
    }

    public void options() {
        if (gridSettings.isVisible()){
            gridSettings.setVisible(false);
        } else if (!gridSettings.isVisible()){
            gridSettings.setVisible(true);
        }
    }

    public void forfeit() {
        gameMaster.escapeConcede();
    }

    public void exitGame() {
        gameMaster.exitGame();
    }
}
