package GUI;

import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.Spell;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class sceneEditDeck {
    //Properties
    double buttonWidth = 150;
    ArrayList<Card> collection;
    ArrayList<Card> deck;

    //Buttons
    Button btnSaveDeck;
    Button btnBack;
    Button btnMoveToCollections;
    Button btnMoveToDeck;

    //Grids
    GridPane gridCollection;
    GridPane gridDeck;
    ScrollPane spCollections;
    ScrollPane spDeck;
    BorderPane layout;
    HBox moveButtons;
    VBox otherButtons;
    VBox containerCenter;

    Scene scene;
    sceneController controller;

    public sceneEditDeck(sceneController controller, ArrayList<Card> collection, ArrayList<Card> deck){
        scene = makeScene();
        this.controller = controller;
        this.collection = collection;
        this.deck = deck;
    }

    public Scene makeScene(){
        //Define grid pane
        gridCollection = new GridPane();
        gridCollection.setHgap(10);
        gridCollection.setPadding(new Insets(10));
        spCollections = new ScrollPane(gridCollection);

        gridDeck = new GridPane();
        gridDeck.setHgap(10);
        gridDeck.setPadding(new Insets(10));
        spDeck = new ScrollPane(gridDeck);

        moveButtons = new HBox();
        otherButtons = new VBox();
        containerCenter = new VBox();

        containerCenter.getChildren().addAll(gridCollection, moveButtons, gridDeck);

        layout = new BorderPane();
        layout.setCenter(containerCenter);
        layout.setRight(otherButtons);

        // Create the scene
        Group root = new Group();
        root.getChildren().add(layout);
        Scene scene = new Scene(root, 1920, 1080);



        // Button to save deck
        Tooltip tooltipSaveDeck =
                new Tooltip("Press to save deck");
        btnSaveDeck.setTooltip(tooltipSaveDeck);
        btnSaveDeck.setMinWidth(buttonWidth);
        btnSaveDeck.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                saveDeck();
            }
        });

        // Button to go back to collections
        Tooltip tooltipBack =
                new Tooltip("Press to go back to collections");
        btnBack.setTooltip(tooltipBack);
        btnBack.setMinWidth(buttonWidth);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                backButton();
            }
        });

        setArrayToGrid(collection, gridCollection);
        setArrayToGrid(deck, gridDeck);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void saveDeck() {

    }

    public void backButton() {
        controller.collections();
    }

    private void setArrayToGrid(ArrayList<Card> list, GridPane grid){
        int i = 0;
        for (Card c: list) {
            sceneCard card;
            GridPane gridCard = null;
            if (c instanceof Minion) {
                Minion m = (Minion) c;
                card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                gridCard = card.getGrid();
            } else if (c instanceof Spell) {
                Spell m = (Spell) c;
                card = new sceneCard(m.getName(), null, m.getContext(), m.getCost());
                gridCard = card.getGrid();
            }
            grid.add(gridCard, i, 0);
            i++;
        }
    }

}
