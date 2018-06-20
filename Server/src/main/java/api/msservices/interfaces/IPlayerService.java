package api.msservices.interfaces;

import api.model.Player;
import api.model.resources.PlayerRank;

public interface IPlayerService {
    Player login(Player player);
    Player register(Player player);
}
