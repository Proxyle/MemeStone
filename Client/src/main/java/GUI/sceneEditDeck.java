package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneEditDeck {
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnSaveDeck = new Button("Save Deck");
    Button btnDeleteDeck = new Button("Delete Deck");
    Button btnBack = new Button("Back");

    Scene scene;
    sceneController controller;

    public sceneEditDeck(sceneController controller){
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(390, 10, 10, 880));

        // Create the scene
        Group root = new Group();
        root.getChildren().add(grid);
        Scene scene = new Scene(root, 1920, 1080);



        // Button to save deck
        Tooltip tooltipSaveDeck =
                new Tooltip("Press to save deck");
        btnSaveDeck.setTooltip(tooltipSaveDeck);
        btnSaveDeck.setMinWidth(buttonWidth);
        btnSaveDeck.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                deleteDeck();
            }
        });
        grid.add(btnSaveDeck, 1,1,1,1);

        // Button to delete deck
        Tooltip tooltipDeleteDeck =
                new Tooltip("Press to delete deck");
        btnDeleteDeck.setTooltip(tooltipDeleteDeck);
        btnDeleteDeck.setMinWidth(buttonWidth);
        btnDeleteDeck.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                saveDeck();
            }
        });
        grid.add(btnDeleteDeck, 1,2,1,1);

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
        grid.add(btnBack, 1,3,1,1);

        //TODO Uhm like get some cards up in here somehow but now twice

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void deleteDeck() {

    }

    public void saveDeck() {

    }

    public void backButton() {
        controller.collections();
    }

}
