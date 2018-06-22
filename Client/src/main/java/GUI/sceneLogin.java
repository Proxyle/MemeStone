package GUI;

import Logic.GameMaster.IGameMaster;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sceneLogin{
    //Properties
    double buttonWidth = 150;
    IGameMaster gameMaster;

    //Buttons
    Button btnSignIn = new Button("Sign In");
    Button btnSignUp = new Button("Sign Up");
    TextField txtUsername = new TextField();
    PasswordField txtPassword = new PasswordField();
    Label lblUsername = new Label("Username:");
    Label lblPassword = new Label("Password:");
    Scene scene;
    sceneController controller;

    public sceneLogin(sceneController controller, IGameMaster gameMaster){
        this.gameMaster = gameMaster;
        scene = makeScene();
        this.controller = controller;
    }

    private Scene makeScene(){
        //Define grid pane
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(320,10,10,810));

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(grid);


        // Button to Sign In
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

        // Button to Sign Up
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
        return scene;
    }

    public Scene getScene(){
        return scene;
    }

    public void signIn(){
        if(gameMaster.logIn(txtUsername.getText(), txtPassword.getText())){
            controller.home();
        }
    }

    public void signUp() {

    }

}
