package GUI;

import Models.Card.Card;
import Models.Card.Minion.Minion;
import Models.Card.Spell.Spell;
import javafx.application.Application;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class sceneCollection {
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnNewDeck = new Button("New Deck");
    Button btnEditDeck = new Button("Edit Deck");
    Button btnBack = new Button("Back");

    Scene scene;
    sceneController controller;
    ArrayList<Card> collection;

    public sceneCollection(sceneController controller, ArrayList<Card> collection) {
        scene = makeScene();
        this.collection = collection;
        this.controller = controller;
    }

    public Scene makeScene() {
        //Define VBox
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        //Define grid pane
        GridPane gridCollections = new GridPane();
        gridCollections.setPadding(new Insets(10));

        //Define scroll pane
        ScrollPane scrollPane = new ScrollPane(gridCollections);
        scrollPane.setMaxWidth(500);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(scrollPane);
        layoutPane.setRight(vBox);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(layoutPane);


        // Button to Create new deck
        Tooltip tooltipStartGame =
                new Tooltip("Press to create a new deck");
        btnNewDeck.setTooltip(tooltipStartGame);
        btnNewDeck.setMinWidth(buttonWidth);
        btnNewDeck.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                newDeck();
            }
        });

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
        Tooltip tooltipBack =
                new Tooltip("Press to go back to collections");
        btnBack.setTooltip(tooltipBack);
        btnBack.setMinWidth(buttonWidth);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                backButton();
            }
        });

        vBox.getChildren().addAll(btnEditDeck, btnNewDeck, btnBack);


        /*for (Card c:collection) {
            if (c instanceof Minion) {
                Minion m = c;
            sceneCard card = new sceneCard(c.getName(),c.getImage,c.getContext());
            }
        }*/
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
                if (card.equals(null))
                    gridCollections.add(card.getGrid(), x, y);

                if (x == 3) {
                    x = 1;
                    y++;
                } else {
                    x++;
                }
            }
        }

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void newDeck() {
        controller.newDeck();
    }

    public void editDeck() {
        controller.editDeck();
    }

    public void backButton() {
        controller.home();
    }

}
