package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneCard{
    //Properties
    String name;
    String imgUrl;
    String summary;
    int healthPoints;
    int energyPoints;
    int attackPoints;

    //Buttons
    Label lblName;
    Label lblHealthPoints;
    Label lblEnergyPoints;
    Label lblAttackPoints;
    Label lblSummary;
    ImageView iIcon = new ImageView();

    /*public sceneCard(String name, String imgUrl, String summary, int healthPoints, int energyPoints, int attackPoints) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.summary = summary;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
    }*/

    public GridPane getGrid(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 120, 200);

        root.getChildren().add(grid);

        // Add labels to grid
        lblName = new Label("Good Guy Greg");
        grid.add(lblName, 2,1,1,1);

        lblEnergyPoints = new Label(String.valueOf(1));
        grid.add(lblEnergyPoints, 1,1,1,1);

        lblHealthPoints = new Label(String.valueOf(10));
        grid.add(lblHealthPoints, 1,4,1,1);

        lblAttackPoints = new Label(String.valueOf(5));
        grid.add(lblAttackPoints, 3,4,1,1);

        lblSummary = new Label("Good Guy Greg (GGG) is an advice animal image macro series featuring a photo of a square-jawed man smiling at the camera with a marijuana cigarette in his mouth.");
        lblSummary.setMaxSize(100, 50);
        lblSummary.setWrapText(true);
        //TODO change font size of label so it's readable
        grid.add(lblSummary, 2,3,1,1);

        // Add Icon
        Image imgLoad = new Image("file:C:\\Test\\MemestonePicas\\ggg.jpg");
        iIcon.setImage(imgLoad);
        iIcon.setFitHeight(60);
        iIcon.setFitWidth(80);
        grid.add(iIcon, 2,2 , 1, 1);

        // Define title and assign the scene for main window
        return grid;
    }

    public void newDeck() {

    }
    public void editDeck() {

    }
}
