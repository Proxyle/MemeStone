package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneLogin  extends Application {
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnSignIn = new Button("Sign In");
    Button btnSignUp = new Button("Sign Up");
    TextField txtUsername = new TextField();
    TextField txtPassword = new TextField();
    Label lblUsername = new Label("Username:");
    Label lblPassword = new Label("Password:");

    public void start(Stage primaryStage) throws Exception{
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(390, 10, 10, 815));

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(grid);


        // Button to start game
        Tooltip tooltipStartGame =
                new Tooltip("Sign In to MemeStone");
        btnSignIn.setTooltip(tooltipStartGame);
        btnSignIn.setMinWidth(buttonWidth);
        btnSignIn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signIn();
            }
        });
        grid.add(btnSignIn, 1,5,1,1);

        // Button to open collection
        Tooltip tooltipCollection =
                new Tooltip("Press to view your collection");
        btnSignUp.setTooltip(tooltipCollection);
        btnSignUp.setMinWidth(buttonWidth);
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signUp();
            }
        });
        grid.add(btnSignUp, 2,5,1,1);

        // Username label and textfield
        grid.add(lblUsername, 1,1,1,1);
        grid.add(txtUsername, 1,2,2,1);

        // Password label and textfield
        grid.add(lblPassword, 1,3,1,1);
        grid.add(txtPassword, 1,4,2,1);

        // Define title and assign the scene for main window
        primaryStage.setTitle("MemeStone");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void signIn(){

    }

    public void signUp() {

    }

}
