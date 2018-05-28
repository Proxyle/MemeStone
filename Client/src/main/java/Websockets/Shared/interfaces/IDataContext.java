package Websockets.Shared.interfaces;

import Models.User.IUser;
import java.util.List;

public interface IDataContext {
    void addPlayer(IUser item);
    void updatePlayer(IUser item);
    void removePlayer(IUser item);
    List<IUser> getAllPlayers();
    IUser getSinglePlayer(long id);

}
