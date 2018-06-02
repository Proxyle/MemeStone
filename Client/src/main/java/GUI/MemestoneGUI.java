package GUI;


import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.*;

public class MemestoneGUI extends Application implements IMemestoneGUI{
    Stage window;
    sceneController controller;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        controller = new sceneController(this);
        primaryStage.setTitle("Memestone");
        controller.login();
        primaryStage.show();
    }

    public void Draw(Scene scene){
        window.setScene(scene);
    }
}
