package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class sceneCollection{
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnNewDeck = new Button("New Deck");
    Button btnEditDeck = new Button("Edit Deck");
    Button btnBack = new Button("Back");

    Scene scene;
    sceneController controller;

    public sceneCollection(sceneController controller){
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define VBox
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);

        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(390, 10, 10, 880));

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(grid);
        layoutPane.setRight(vBox);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(grid);


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


        //TODO Uhm like get some cards up in here somehow

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void newDeck() {

    }
    public void editDeck() {

    }
    public void backButton() {
        controller.collections();
    }

}
