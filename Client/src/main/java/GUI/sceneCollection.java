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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.validation.constraints.Min;
import java.util.ArrayList;

public class sceneCollection{
    //Properties
    double buttonWidth = 150;
    ArrayList<Card> cards;

    //Buttons
    Button btnNewDeck = new Button("New Deck");
    Button btnEditDeck = new Button("Edit Deck");
    Button btnBack = new Button("Back");

    Scene scene;
    sceneController controller;

    public sceneCollection(sceneController controller, ArrayList<Card> cards){
        scene = makeScene();
        this.controller = controller;
        this.cards = cards;
    }

    public Scene makeScene(){
        //Define VBox
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        //Define HBox
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxWidth(500);
        scrollPane.setContent(hbox);

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

        vBox.getChildren().addAll(btnEditDeck,btnNewDeck,btnBack);

        for (Card c: cards) {
            if (c instanceof Minion){
                Minion m = (Minion)c;
                sceneCard card = new sceneCard(m.getName(), null, m.getContext(), m.getHealthPoints(), m.getCost(), m.getAttackPoints());
                hbox.getChildren().add(card.getGrid());
            } else if(c instanceof Spell){
                Spell m = (Spell)c;
                sceneCard card = new sceneCard(m.getName(), null, m.getContext(), m.getCost());
                hbox.getChildren().add(card.getGrid());
            }
        }

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void newDeck() {
        //NewDeck
    }
    public void editDeck() {
        //EditDeck
    }
    public void backButton() {
        controller.collections();
    }

}
