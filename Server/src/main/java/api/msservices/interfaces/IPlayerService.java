package api.msservices.interfaces;

import api.model.Player;

public interface IPlayerService {
    Player getById(long playerId);
    String getPlayerRankByName(String playerName);
}
