package Logic;

import Logic.GameServer.IGameServerMain;

public class MatchmakingLoop implements Runnable {

    IGameServerMain gameServer;

    public MatchmakingLoop(IGameServerMain gameServer){
        this.gameServer = gameServer;
    }
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(5000);
                gameServer.matchPlayers();
            }
        }
        catch(Exception e){

        }
    }
}
