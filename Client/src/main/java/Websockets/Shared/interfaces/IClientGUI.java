package Websockets.Shared.interfaces;

import Models.Card.Card;
import Models.Player;
import javafx.scene.Scene;

import java.util.List;

public interface IClientGUI {
    void processRegistrationResponse(boolean resp);
    void processRoundStart();
    void processPlayerRegisterd(String name);
    void Draw(Scene guiScene);


    void processGameEnd(String winner);

    void processPlayerActionFail();

    void processUpdateBoard(Card[][] board);

    void processUpdatePlayer(Player player);

    void processGetCollection(List<Card> collection);
}
