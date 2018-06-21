package GUI;

import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.Spell;
import Models.Player;
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
    double buttonWidth = 150;
    Image iHerosHero = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image iOpponentsHero = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image iCardBack = new Image("file:C:\\Test\\MemestonePicas\\EmptySlot.jpg", 120, 120, false, false);
    Image iEmptySlot = new Image("file:C:\\Test\\MemestonePicas\\EmptySlot.jpg", 120, 120, false, false);
    Image iBuffLeft = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image iBuffRight = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg", 120, 120, false, false);
    Image imgLoad;

    ArrayList<Integer> clickOne;
    ArrayList<Integer> clickTwo;

    int opponentHealth;
    int opponentEnergy;
    int heroHealth;
    int heroEnergy;

    //Card hold arrays
    private Card[] cardsHeroHand;
    private Card[][] cardsField;

    //Buttons
    Button btnEndTurn = new Button("End Turn");
    Button btnOptions = new Button("Options");
    Button btnForfeit = new Button("Forfeit");
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
    VBox vBoxSettings;
    GridPane gridOpponentStats;
    GridPane gridOpponentField;
    GridPane gridHeroHand;
    GridPane gridHeroStats;
    GridPane gridHeroField;
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
        clickOne = new ArrayList<>();
        clickTwo = new ArrayList<>();
        //Create card holder arrays
        cardsHeroHand = new Card[6];
        cardsField = new Card[2][7];
    }

    public Scene makeScene(){
        //Define Panes

        //Grid opponent stats
        gridOpponentStats = new GridPane();
        gridOpponentStats.setHgap(10);

        //Grid opponent field
        gridOpponentField = makeGridWithEmptySlots(6);

        //Grid hero hand
        gridHeroHand = makeGridWithEmptySlots(6);

        //Grid hero stats
        gridHeroStats = new GridPane();
        gridHeroStats.setHgap(10);

        //Grid hero field
        gridHeroField = makeGridWithEmptySlots(6);

        //Grid gamefield
        gridGameField = new GridPane();
        gridGameField.add(gridOpponentField,1,0);
        gridGameField.add(gridHeroField,1,2);

        //Settings GridPane
        vBoxSettings = new VBox();

        //vBox
        vBoxHero = new VBox();
        vBoxHero.getChildren().addAll(gridHeroStats, gridHeroHand);

        vBoxOpponent = new VBox();
        vBoxOpponent.getChildren().addAll(gridHeroStats);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setTop(vBoxOpponent);
        layoutPane.setCenter(gridGameField);
        layoutPane.setBottom(vBoxHero);
        layoutPane.setRight(vBoxSettings);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(layoutPane);

        //BuffLeft
        ivBuffLeft = new ImageView();
        ivBuffLeft.setImage(iBuffLeft);
        ivBuffLeft.setFitWidth(50);
        ivBuffLeft.setFitHeight(50);
        gridGameField.add(ivBuffLeft,0,1);

        //BuffRight
        ivBuffRight = new ImageView();
        ivBuffRight.setImage(iBuffRight);
        ivBuffRight.setFitWidth(50);
        ivBuffRight.setFitHeight(50);
        gridGameField.add(ivBuffRight,2,1);

        //Opponents Health
        pbHealthBarOpponent = new ProgressBar();
        pbHealthBarOpponent.setMinWidth(380);
        gridOpponentStats.add(pbHealthBarOpponent, 1,1);
        lblHealthOpponent = new Label(String.valueOf(opponentHealth));
        gridOpponentStats.add(lblHealthOpponent, 1,1);

        //Opponents Energy
        pbEnergyBarOpponent = new ProgressBar();
        pbEnergyBarOpponent.setMinWidth(380);
        gridOpponentStats.add(pbEnergyBarOpponent,3, 1);
        lblEnergyOpponent = new Label(String.valueOf(opponentEnergy));
        gridOpponentStats.add(lblEnergyOpponent, 3,1);

        //Heros Health
        pbHealthBarHero = new ProgressBar();
        pbHealthBarHero.setMinWidth(380);
        gridHeroStats.add(pbHealthBarHero, 1,1);
        lblHealthHero = new Label(String.valueOf(heroHealth));
        gridHeroStats.add(lblHealthHero, 1,1);

        //Heros Energy
        pbEnergyBarHero = new ProgressBar();
        pbEnergyBarHero.setMinWidth(380);
        gridHeroStats.add(pbEnergyBarHero,3, 1);
        lblEnergyHero = new Label(String.valueOf(heroEnergy));
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
                new Tooltip("Press to end turn");
        btnEndTurn.setTooltip(tooltipStartGame);
        btnEndTurn.setMinWidth(buttonWidth);
        btnEndTurn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                endTurn();
            }
        });
        gridGameField.add(btnEndTurn, 3,1);

        // Button to open options
        Tooltip tooltipCollection =
                new Tooltip("Press to open options");
        btnOptions.setTooltip(tooltipCollection);
        btnOptions.setMinWidth(buttonWidth);
        btnOptions.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                options();
            }
        });
        gridGameField.add(btnOptions, 4,1);

        // Button to forfeit
        Tooltip tooltipLeaderboard =
                new Tooltip("Press to forfeit");
        btnForfeit.setTooltip(tooltipLeaderboard);
        btnForfeit.setMinWidth(buttonWidth);
        btnForfeit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                forfeit();
            }
        });

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

        vBoxSettings.getChildren().addAll(btnForfeit,btnExitGame);

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
        ivEmptySlot.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex( ivEmptySlot),GridPane.getRowIndex( ivEmptySlot)));
        return ivEmptySlot;
    }

    public void removeNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {

        ObservableList<Node> childrens = gridPane.getChildren();
        for(Node node : childrens) {
            if(node instanceof GridPane && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                GridPane grid = (GridPane) node; // use what you want to remove
                gridPane.getChildren().remove(grid);
                break;
            }
        }
    }

    private GridPane makeGridWithEmptySlots(int amount){
        GridPane grid = new GridPane();
        grid.setHgap(10);
        for(int i=1; i<(amount + 1); i++){
            grid.add(emptySlotImage(), i,1,1,1);
        }
        return grid;
    }

    private void clickObject(int xpos, int ypos){
        if (clickOne.size() == 0){
            clickOne = new ArrayList<>();
            clickOne.add(0, xpos);
            clickOne.add(1, ypos);
        } else if (clickTwo.size() == 0){
            clickTwo = new ArrayList<>();
            clickTwo.add(0, xpos);
            clickTwo.add(1, ypos);

            checkAction();
        }
    }

    private void checkAction(){
        if (clickOne.get(1) == 2 && clickTwo.get(1) == 2){
        } else if (clickOne.get(1) == 2){
            int[] target = new int[2];
            target[0] = clickTwo.get(1);
            target[1] = clickTwo.get(0);
            gameMaster.playCard(cardsHeroHand[clickOne.get(0)], target);
        } else if (clickOne.get(1) == 0 && clickTwo.get(1) == 1){
            gameMaster.attackCard(clickOne.get(0), clickTwo.get(0));
        }

        clickOne = new ArrayList<>();
        clickTwo = new ArrayList<>();
    }

    public void endTurn() {
        gameMaster.nextTurn();
    }

    public void options() {
        if (vBoxSettings.isVisible())
            vBoxSettings.setVisible(false);
        else if (!vBoxSettings.isVisible())
            vBoxSettings.setVisible(true);
    }

    public void forfeit() {
        gameMaster.escapeConcede();
    }

    public void exitGame() {
        gameMaster.exitGame();
    }

    public void updateBoard(Minion[][] cards){
        sceneCard card;
        gridOpponentField = new GridPane();
        gridHeroField = new GridPane();
        for (int i = 0; i <= 1; i++){
            for (int j = 0; j <= 6; j++){
                Minion m =(Minion)cards[i][j];
                card = new sceneCard(m.getName(),null,m.getContext(),m.getHealthPoints(),m.getCost(),m.getAttackPoints());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex( gridCard),GridPane.getRowIndex( gridCard)));
                if (i == 0){
                    if (j == 6){

                    } else if (cards[i][j] == null){
                        gridHeroField.add(emptySlotImage(), j, i);
                    } else {
                        gridHeroField.add(card.getGrid(), j, i);
                    }

                } else if (i == 1){
                    if (cards[i][j] == null){
                        gridOpponentField.add(emptySlotImage(), i, j);
                    } else {
                        gridOpponentField.add(card.getGrid(), i, j);
                    }
                }
            }
        }
    }

    public void updatePlayer(Player player){
        gridHeroHand = new GridPane();
        sceneCard card;
        ArrayList<Card> c = player.getCards();
        for (int i = 0; i >= 5; i++){
            if (c.get(i) instanceof Minion){
                Minion m = (Minion)c.get(i);
                card = new sceneCard(m.getName(),null,m.getContext(),m.getHealthPoints(),m.getCost(),m.getAttackPoints());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex( gridCard),GridPane.getRowIndex( gridCard)));
                gridHeroHand.add(gridCard, i, 2 );
            } else if (c.get(i) instanceof Spell){
                Spell m = (Spell)c.get(i);
                card = new sceneCard(m.getName(),null,m.getContext(),m.getCost());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex( gridCard),GridPane.getRowIndex( gridCard)));
                gridHeroHand.add(gridCard, i, 0 );
            } else if (c.get(i) == null){
                gridHeroHand.add(emptySlotImage(), i, 2 );
            }
        }
    }
}
