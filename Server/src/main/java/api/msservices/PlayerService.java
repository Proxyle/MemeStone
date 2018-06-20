package api.msservices;

import api.model.Player;
import api.model.resources.PlayerRank;
import api.msrepositories.PlayerRepository;
import api.msservices.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player login(Player player) {
        Player p;
        try {
            p = playerRepository.findByUserName(player.getUserName());
        } catch (Exception e) {
            return null;
        }

        if (p != null && checkPassword(p.getPassword(), player.getPassword())) {
            return p;
        }
        return null;
    }

    @Override
    public Player register(Player player) {
        try {
            playerRepository.save(player);
        } catch (Exception e) {
            return null;
        }
        return player;
    }

    private boolean checkPassword(String currentPassword, String tryingPassword) {
        return currentPassword.equals(tryingPassword);
    }
}
