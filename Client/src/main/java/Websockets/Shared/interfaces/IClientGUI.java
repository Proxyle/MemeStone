package Websockets.Shared.interfaces;

import Models.Card.Card;
import Models.User.User;
import javafx.scene.Scene;

public interface IClientGUI {
    void processRegistrationResponse(boolean resp);
    void processRoundStart();
    void processPlayerRegisterd(String name);
    void Draw(Scene guiScene);


    void processGameEnd(String winner);

    void processPlayerActionFail();

    void processUpdateBoard(Card[][] board);

    void processUpdatePlayer(User player);
}
