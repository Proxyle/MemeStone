package Websockets.Shared.interfaces;

import Models.User.IPlayer;
import java.util.List;

public interface IDataContext {
    void addPlayer(IPlayer item);
    void updatePlayer(IPlayer item);
    void removePlayer(IPlayer item);
    List<IPlayer> getAllPlayers();
    IPlayer getSinglePlayer(long id);

}
