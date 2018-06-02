package GUI;


import Websockets.Client.ClientMessageGenerator;
import Websockets.Client.GameClient;
import Websockets.Shared.interfaces.IClientGUI;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.*;

public class MemestoneGUI extends Application implements IMemestoneGUI{
    Stage window;
    sceneController controller;

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        controller = new sceneController(this);
        primaryStage.setTitle("Color Clicker");
        controller.login();
        primaryStage.show();
    }

    public void Draw(Scene scene){
        window.setScene(scene);
    }
}
