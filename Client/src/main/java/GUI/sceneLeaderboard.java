package GUI;

import Models.User.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;

public class sceneLeaderboard{
    //Properties
    ArrayList<Player> leaderboard;
    double buttonWidth = 150;
    Label rank;
    Label name;

    //Buttons
    Button btnBack = new Button("Back");
    TableView tableLeaderboard = new TableView();
    Scene scene;
    sceneController controller;

    public sceneLeaderboard(sceneController controller, ArrayList<Player> leadboard){
        this.leaderboard = leadboard;
        scene = makeScene();
        this.controller = controller;
    }

    public Scene makeScene(){
        //Define grid pane
        GridPane gridLeaderboard = new GridPane();
        gridLeaderboard.setVgap(10);

        //Define scroll pane
        ScrollPane scrollPane = new ScrollPane(gridLeaderboard);
        scrollPane.setMaxWidth(100);

        //Define vbox pane
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        //Overall Pane
        BorderPane layoutPane = new BorderPane();
        layoutPane.setCenter(scrollPane);
        layoutPane.setRight(vbox);

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(layoutPane);


        // Leaderboard
        rank = new Label("Rank");
        gridLeaderboard.add(rank, 1,1);

        name = new Label("Name");
        gridLeaderboard.add(name, 2,1);

        int i = 2;
        if (leaderboard != null) {
            for (Player u : leaderboard) {
                rank = new Label(String.valueOf(u.getRanking()));
                name = new Label(u.getUsername());
                gridLeaderboard.add(rank, 1, i);
                gridLeaderboard.add(name, 2, i);
                i++;
            }
        }


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

        vbox.getChildren().addAll(btnBack);

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
