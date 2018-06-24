package GUI;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class sceneCard{
    //Properties
    String name;
    String imgUrl;
    String summary;
    Integer healthPoints;
    Integer energyPoints;
    Integer attackPoints;

    //Buttons
    Label lblName;
    Label lblHealthPoints;
    Label lblEnergyPoints;
    Label lblAttackPoints;
    Label lblSummary;
    ImageView iIcon = new ImageView();

    public sceneCard(String name, Long imgUrl, String summary, int healthPoints, int energyPoints, int attackPoints) {
        this.name = name;
        this.imgUrl = "resources/images/" + imgUrl + ".jpg";
        this.summary = summary;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
    }

    public sceneCard(String name, String imgUrl, String summary, int energyPoints) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.summary = summary;
        this.energyPoints = energyPoints;
    }

    public GridPane getGrid(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(10));
        grid.prefWidth(120);
        grid.prefHeight(200);

        // Add labels to grid
        lblName = new Label(name);
        grid.add(lblName, 2,1,1,1);

        lblEnergyPoints = new Label(String.valueOf(energyPoints));
        grid.add(lblEnergyPoints, 1,1,1,1);

        if (healthPoints == null) {
            lblHealthPoints = new Label(String.valueOf(healthPoints));
            grid.add(lblHealthPoints, 1, 4, 1, 1);
        }

        if (attackPoints == null) {
            lblAttackPoints = new Label(String.valueOf(attackPoints));
            grid.add(lblAttackPoints, 3, 4, 1, 1);
        }

        lblSummary = new Label(summary);
        lblSummary.setFont(Font.font("Lucida",8));
        lblSummary.setMaxSize(100, 50);
        lblSummary.setWrapText(true);
        //TODO change font size of label so it's readable
        grid.add(lblSummary, 2,3,1,1);

        // Add Icon
        Image imgLoad = new Image(imgUrl);
        iIcon.setImage(imgLoad);
        iIcon.setFitHeight(60);
        iIcon.setFitWidth(80);
        grid.add(iIcon, 2,2 , 1, 1);

        // Define title and assign the scene for main window
        return grid;
    }
}
