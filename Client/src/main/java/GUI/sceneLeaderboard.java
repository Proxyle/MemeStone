package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class sceneLeaderboard{
    //Properties
    ArrayList<?> users;
    double buttonWidth = 150;

    //Buttons
    Button btnBack = new Button("Back");
    TableView tableLeaderboard = new TableView();
    Scene scene;
    sceneController controller;

    public sceneLeaderboard(sceneController controller){
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        //grid.setPadding(new Insets(390, 10, 10, 880));

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(grid);


        // Leaderboard
        TableColumn colRank = new TableColumn("Rank");
        TableColumn colName = new TableColumn("Name");
        TableColumn colElo = new TableColumn("Elo");

        //TODO Add data to table
        //Use this link to fill the table https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
        tableLeaderboard.getColumns().addAll(colRank, colName, colElo);


        grid.add(tableLeaderboard, 1,1,1,1);

        // Button to go back to sceneHomeScreen
        Tooltip tooltipCollection =
                new Tooltip("Press to go back");
        btnBack.setTooltip(tooltipCollection);
        btnBack.setMinWidth(buttonWidth);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                backButton();
            }
        });
        grid.add(btnBack, 2,5,1,1);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void backButton() {
        controller.home("erik");
    }
}
