package GUI;

import Logic.GameMaster.IGameMaster;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class sceneRegister {
    //Properties
    double buttonWidth = 150;

    //Buttons
    Button btnSignUp = new Button("Sign Up");
    Button btnBack = new Button("Back");
    TextField txtEmail = new TextField();
    TextField txtUsername = new TextField();
    PasswordField txtPassword = new PasswordField();
    Label lblEmail = new Label("Email:");
    Label lblUsername = new Label("Username:");
    Label lblPassword = new Label("Password:");
    Scene scene;
    sceneController controller;
    IGameMaster gameMaster;

    public sceneRegister(sceneController controller, IGameMaster gameMaster){
        scene = makeScene();
        this.controller = controller;
        this.gameMaster = gameMaster;
    }

    private Scene makeScene(){
        //Define grid pane
        HBox hbButtons = new HBox();
        VBox vbForm = new VBox();

        hbButtons.setPadding(new Insets(320,10,10,810));

        // Create the scene
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080);

        root.getChildren().add(vbForm);


        // Button to Sign Up
        Tooltip tooltipSignUp =
                new Tooltip("Sign Up");
        btnSignUp.setTooltip(tooltipSignUp);
        btnSignUp.setMinWidth(buttonWidth);
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                signUp();
            }
        });

        // Button to Sign Back
        Tooltip tooltipBack =
                new Tooltip("Press to view your collection");
        btnBack.setTooltip(tooltipBack);
        btnBack.setMinWidth(buttonWidth);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                back();
            }
        });

        hbButtons.getChildren().addAll(btnSignUp, btnBack);
        vbForm.getChildren().addAll(lblEmail,txtEmail,lblUsername,txtUsername,lblPassword,txtPassword,hbButtons);

        // Define title and assign the scene for main window
        return scene;
    }

    public Scene getScene(){
        return scene;
    }

    public void signUp() {
        gameMaster.signUp(txtUsername.getText(), txtPassword.getText(), txtEmail.getText());
            controller.home();

    }

    public void back(){
        controller.login();
    }

}
