package GUI;

import Logic.GameMaster.IGameMaster;
import Models.Board.Board;
import Models.Board.FieldBuff;
import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.Spell;
import Models.User.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class sceneGame{
    //Properties
    double buttonWidth = 150;
    Image iHerosHero = new Image("resources/images/hero.jpg", 120, 120, false, false);
    Image iOpponentsHero = new Image("resources/images/opponent.jpg", 120, 120, false, false);
    Image iEmptySlot = new Image("resources/images/EmptySlot.jpg", 120, 120, false, false);
    Image iBuffLeft;
    Image iBuffRight;

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

    public sceneGame(sceneController controller, IGameMaster gameMaster){
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
        ivEmptySlot.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex( ivEmptySlot),GridPane.getRowIndex( ivEmptySlot)));
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

    public void updateBoard(Board board){
        sceneCard card;
        gridOpponentField = new GridPane();
        gridHeroField = new GridPane();

        if (board.getLeftField().getBuff() == FieldBuff.p1Dmg || board.getLeftField().getBuff() == FieldBuff.p2Dmg || board.getLeftField().getBuff() == FieldBuff.P3Dmg)
            iBuffLeft = new Image("resources/images/posDmg.jpg", 120, 120, false, false);
        else if (board.getLeftField().getBuff() == FieldBuff.p1Health || board.getLeftField().getBuff() == FieldBuff.p2Health || board.getLeftField().getBuff() == FieldBuff.P3Health)
            iBuffLeft = new Image("resources/images/posHealth.jpg", 120, 120, false, false);
        else if (board.getLeftField().getBuff() == FieldBuff.n1Health)
            iBuffLeft = new Image("resources/images/negHealth.jpg", 120, 120, false, false);
        else if (board.getLeftField().getBuff() == FieldBuff.n1Dmg)
            iBuffLeft = new Image("resources/images/negDmg.jpg", 120, 120, false, false);

        if (board.getRightField().getBuff() == FieldBuff.p1Dmg || board.getRightField().getBuff() == FieldBuff.p2Dmg || board.getRightField().getBuff() == FieldBuff.P3Dmg)
            iBuffRight = new Image("resources/images/posDmg.jpg", 120, 120, false, false);
        else if (board.getRightField().getBuff() == FieldBuff.p1Health || board.getRightField().getBuff() == FieldBuff.p2Health || board.getRightField().getBuff() == FieldBuff.P3Health)
            iBuffRight = new Image("resources/images/posHealth.jpg", 120, 120, false, false);
        else if (board.getRightField().getBuff() == FieldBuff.n1Health)
            iBuffRight = new Image("resources/images/negHealth.jpg", 120, 120, false, false);
        else if (board.getRightField().getBuff() == FieldBuff.n1Dmg)
            iBuffRight = new Image("resources/images/negDmg.jpg", 120, 120, false, false);

        pbEnergyBarHero.setProgress(progressNumber(board.getLowerHeroMana(),10));
        lblEnergyHero.setText(String.valueOf(board.getLowerHeroMana()));

        pbHealthBarOpponent.setProgress(progressNumber(board.getUpperHero(),30));
        lblHealthOpponent.setText(String.valueOf(board.getUpperHero()));

        pbEnergyBarOpponent.setProgress(progressNumber(board.getUpperHeroMana(),10));
        lblEnergyOpponent.setText(String.valueOf(board.getUpperHeroMana()));

        pbHealthBarHero.setProgress(progressNumber(board.getLowerHero(),30));
        lblHealthHero.setText(String.valueOf(board.getLowerHero()));

        //Set top lane
        int x = 0;
        for(Minion m: board.getLeftField().getUpperField()){
            if (m != null) {
                card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex(gridCard), GridPane.getRowIndex(gridCard)));
                gridOpponentField.add(emptySlotImage(), x, 1);
            } else {
                gridOpponentField.add(emptySlotImage(), x, 1);
            }
            x++;
        }
        for (Minion m: board.getRightField().getUpperField()){
            if (m != null) {
                card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex(gridCard), GridPane.getRowIndex(gridCard)));
                gridOpponentField.add(emptySlotImage(), x, 1);
            } else {
                gridOpponentField.add(emptySlotImage(), x, 1);
            }
            x++;
        }

        //Set bottom lane
        for(Minion m: board.getLeftField().getLowerField()){
            if (m != null) {
                card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex(gridCard), GridPane.getRowIndex(gridCard)));
                gridHeroField.add(emptySlotImage(), x, 0);
            } else {
                gridHeroField.add(emptySlotImage(), x, 0);
            }
            x++;
        }
        for (Minion m: board.getRightField().getLowerField()){
            if (m != null) {
                card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                GridPane gridCard = card.getGrid();
                gridCard.addEventFilter(javafx.scene.input.MouseEvent.MOUSE_PRESSED, event -> clickObject(GridPane.getColumnIndex(gridCard), GridPane.getRowIndex(gridCard)));
                gridHeroField.add(emptySlotImage(), x, 0);
            } else {
                gridHeroField.add(emptySlotImage(), x, 0);
            }
            x++;
        }
    }

    private double progressNumber(int n, int base) {
        int value = base/n;
        if (value > 1)
            return 1;
        return value;
    }

    public void updatePlayer(Player player){
        gridHeroHand = new GridPane();
        sceneCard card;
        List<Card> c = player.getCards();
        for (int i = 0; i <= 5; i++){
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

    public void notifyPlayer(String text){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(text);

        alert.showAndWait();
    }
}
