package api.msservices.interfaces;

import api.model.Player;

import java.util.Map;

public interface IPlayerService {
    Player getById(long playerId);
    Map<String, Object> getPlayerRankByName(String playerName);
}
