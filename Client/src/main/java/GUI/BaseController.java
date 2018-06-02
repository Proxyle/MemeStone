package GUI;

import Websockets.Client.IGameClient;

public abstract class BaseController {
    public IGameClient getGameClient() {
        return gameClient;
    }

    private IGameClient gameClient;

    public BaseController(IMemestoneGUI gui)
    {
        this.gameClient = gameClient;
    }

}
