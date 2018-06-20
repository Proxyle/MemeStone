package api.msservices.interfaces;

import api.model.resources.PlayerRank;

import java.util.List;

public interface IRankingService {
    PlayerRank getRankByName(String playerName);
    PlayerRank getRankById(Long playerId);
    List<PlayerRank> getAll();
}
