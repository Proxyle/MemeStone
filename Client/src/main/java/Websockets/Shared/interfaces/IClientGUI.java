package Websockets.Shared.interfaces;

import javafx.scene.Scene;

public interface IClientGUI {
    void processRegistrationResponse(boolean resp);
    void processRoundStart();
    void processPlayerRegisterd();
    void Draw(Scene guiScene);


}
