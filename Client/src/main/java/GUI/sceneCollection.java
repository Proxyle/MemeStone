package GUI;

import Logic.GameMaster.IGameMaster;
import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.Spell;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class sceneCollection {
    //Properties
    double buttonWidth = 150;
    final protected int packCost = 100;
    IGameMaster gameMaster;

    //Buttons
    Button btnEditDeck = new Button("Edit Deck");
    Button btnBuyCards = new Button("Buy new cards");
    Button btnBack = new Button("Back");
    Button btnOk = new Button("Ok");
    Label lblScore;

    Group groupCollections;
    Group groupNewCards;
    VBox newCards;

    Scene scene;
    sceneController controller;
    ArrayList<Card> collection;

    public sceneCollection(sceneController controller, IGameMaster gameMaster, ArrayList<Card> collection, int score) {
        scene = makeScene();
        this.collection = collection;
        this.controller = controller;
        this.gameMaster = gameMaster;
    }

    public Scene makeScene() {
        //Define VBox
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        newCards = new VBox();
        newCards.setPadding(new Insets(10));
        newCards.setSpacing(10);

        //Define grid pane
        GridPane gridCollections = new GridPane();
        gridCollections.setPadding(new Insets(10));

        //Define scroll pane
        ScrollPane scrollPane = new ScrollPane(gridCollections);
        scrollPane.setMaxWidth(500);


        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(scrollPane);
        layoutPane.setCenter(newCards);
        layoutPane.setRight(vBox);
        layoutPane.setRight(btnOk);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(layoutPane);

        groupCollections = new Group();
        gridCollections.getChildren().addAll(vBox,scrollPane);
        groupCollections = new Group();
        groupNewCards.getChildren().addAll(newCards, btnOk);

        // Button to edit deck
        Tooltip tooltipCollection =
                new Tooltip("Press to edit a selected deck");
        btnEditDeck.setTooltip(tooltipCollection);
        btnEditDeck.setMinWidth(buttonWidth);
        btnEditDeck.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                editDeck();
            }
        });

        // Button to go back to collections
        Tooltip tooltipButCards =
                new Tooltip("Press to buy a card pack for "+ packCost);
        btnBuyCards.setTooltip(tooltipButCards);
        btnBuyCards.setMinWidth(buttonWidth);
        btnBuyCards.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buyCards();
            }
        });

        // Button to go back to collections
        Tooltip tooltipBack =
                new Tooltip("Press to go back to home screen");
        btnBack.setTooltip(tooltipBack);
        btnBack.setMinWidth(buttonWidth);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                backButton();
            }
        });

        vBox.getChildren().addAll(btnEditDeck, btnBack);

        // Button to go back to collections
        Tooltip tooltipOk =
                new Tooltip("Press to go back to collections");
        btnOk.setTooltip(tooltipOk);
        btnOk.setMinWidth(buttonWidth);
        btnOk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                okButton();
            }
        });


        sceneCard card = null;
        int x = 1;
        int y = 1;
        if (collection != null){
            for (Card c : collection) {
                if (c instanceof Minion) {
                    Minion m = (Minion) c;
                    card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                } else if (c instanceof Spell) {
                    Spell s = (Spell) c;
                    card = new sceneCard(s.getName(), null, s.getContext(), s.getCost());
                }
                if (card == null)
                    gridCollections.add(card.getGrid(), x, y);

                if (x == 3) {
                    x = 1;
                    y++;
                } else {
                    x++;
                }
            }
        }

        groupNewCards.setVisible(false);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void editDeck() {
        controller.editDeck();
    }

    public void buyCards(){
        gameMaster.buyCards();
    }

    public void showCards(ArrayList<Card> cards) {
        groupCollections.setVisible(false);
        groupNewCards.setVisible(true);
        newCards = new VBox();
        sceneCard card = null;
        for (Card c : cards) {
            if (c instanceof Minion) {
                Minion m = (Minion) c;
                card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
            } else if (c instanceof Spell) {
                Spell s = (Spell) c;
                card = new sceneCard(s.getName(), null, s.getContext(), s.getCost());
            }
            newCards.getChildren().add(card.getGrid());
        }
    }

    public void backButton() {
        controller.home("derp");
    }

    public void okButton(){
        controller.collections();
    }

}
