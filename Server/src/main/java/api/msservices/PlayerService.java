package api.msservices;

import api.model.Player;
import api.msrepositories.PlayerRepository;
import api.msservices.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player getById(long playerId) {
        Player player;
        try {
            player = playerRepository.findById(playerId).get();
        } catch (Exception e) {
            return null;
        }
        return player;
    }

    @Override
    public Map<String, Object> getPlayerRankByName(String playerName) {
        Player player;
        try {
            player = playerRepository.findByUserName(playerName);
        } catch (Exception e) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("Username", player.getUserName());
        map.put("Rank Points", player.getRankPoints());
        return map;
    }
}
