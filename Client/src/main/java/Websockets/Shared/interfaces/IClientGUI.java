package Websockets.Shared.interfaces;

import Models.BoardField.*;
import Models.Card.Card;
import Models.User.Player;
import javafx.scene.Scene;

import java.util.List;

public interface IClientGUI {
    void processRegistrationResponse(boolean resp);
    void processRoundStart(int lobbyId);
    void processPlayerRegisterd(String name);
    void Draw(Scene guiScene);


    void processGameEnd(String winner);

    void processPlayerActionFail();

    void processUpdateBoard(Board board);

    void processUpdatePlayer(Player player);

    void processGetCollection(List<Card> collection);

    void processCardBought();
}
