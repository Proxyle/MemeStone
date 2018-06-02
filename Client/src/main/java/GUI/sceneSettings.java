package GUI;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneSettings{
    //Properties
    double buttonWidth = 150;

    //Buttons
    ObservableList<String> resolutions = FXCollections.observableArrayList("1920x1080","1280x720","640x480");
    Label lblResolution = new Label("Resolution");
    ComboBox<String> cbResolution = new ComboBox<String>();
    Label lblVolume = new Label("Volume");
    Slider sAudio = new Slider();
    Button btnApplyChanges = new Button("Apply Changes");
    Button btnBack = new Button("Back");
    Scene scene;
    sceneController controller;

    public sceneSettings(sceneController controller){
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(390, 10, 10, 815));

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(grid);


        // Button to apply changes
        Tooltip tooltipStartGame =
                new Tooltip("Sign In to MemeStone");
        btnApplyChanges.setTooltip(tooltipStartGame);
        btnApplyChanges.setMinWidth(buttonWidth);
        btnApplyChanges.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                applyChanges();
            }
        });
        grid.add(btnApplyChanges, 1,5,1,1);

        // Button to go back to sceneHomeScreen
        Tooltip tooltipCollection =
                new Tooltip("Press to view your collection");
        btnBack.setTooltip(tooltipCollection);
        btnBack.setMinWidth(buttonWidth);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                backButton();
            }
        });
        grid.add(btnBack, 2,5,1,1);

        // Resolution label and combobox
        cbResolution.setItems(resolutions);
        grid.add(lblResolution, 1,1,1,1);
        grid.add(cbResolution, 1,2,1,1);

        // Volume label and slider
        grid.add(lblVolume, 1,3,1,1);
        grid.add(sAudio, 1,4,2,1);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void backButton() {
        controller.home("erik");
    }

    public void applyChanges() {

    }

}
