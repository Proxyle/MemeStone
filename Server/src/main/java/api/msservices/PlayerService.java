package api.msservices;

import api.model.Player;
import api.msrepositories.PlayerRepository;
import api.msservices.interfaces.IPlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.monitorjbl.json.JsonView;
import com.monitorjbl.json.JsonViewSerializer;
import static com.monitorjbl.json.Match.match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String getPlayerRankByName(String playerName) {
        Player player;
        try {
            player = playerRepository.findByUserName(playerName);
        } catch (Exception e) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(JsonView.class, new JsonViewSerializer());
        mapper.registerModule(module);

        String json;
        try {
            json = mapper.writeValueAsString(JsonView.with(player)
                    .onClass(Player.class, match()
                            .exclude("*")
                            .include("userName", "rankPoints")));
        } catch (Exception e) {
            return null;
        }
        return json;
    }
}
