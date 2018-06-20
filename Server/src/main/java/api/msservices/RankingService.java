package api.msservices;

import api.model.Player;
import api.model.resources.PlayerRank;
import api.msrepositories.PlayerRepository;
import api.msservices.interfaces.IRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankingService implements IRankingService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public PlayerRank getRankByName(String playerName) {
        Player player;
        try {
            player = playerRepository.findByUserName(playerName);
        } catch (Exception e) {
            return null;
        }
        return new PlayerRank(player.getId(), player.getUserName(), player.getRankPoints());
    }

    @Override
    public PlayerRank getRankById(Long playerId) {
        Player player;
        try {
            player = playerRepository.findById(playerId).get();
        } catch (Exception e) {
            return null;
        }
        return new PlayerRank(player.getId(), player.getUserName(), player.getRankPoints());
    }

    @Override
    public List<PlayerRank> getAll() {
        List<Player> players = new ArrayList<>();
        try {
            playerRepository.findAll().forEach(p -> players.add(p));
        } catch (Exception e) {
            return null;
        }
        return refactorPlayerToPlayerRank(players);
    }

    private List<PlayerRank> refactorPlayerToPlayerRank(List<Player> players) {
        List<PlayerRank> playerRanks = new ArrayList<>();
        players.forEach(player -> playerRanks.add(new PlayerRank(player.getId(), player.getUserName(), player.getRankPoints())));
        return playerRanks;
    }
}
