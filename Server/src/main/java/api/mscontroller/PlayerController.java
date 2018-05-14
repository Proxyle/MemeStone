package api.mscontroller;

import api.model.Player;
import api.msservices.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @GetMapping(value = "/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable("playerId") long playerId) {
        Player player = playerService.getById(playerId);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping(value = "/{playerName}/rank")
    public ResponseEntity<Object> getPlayerRankByName(@PathVariable("playerName") String playerName) {
        Map<String, Object> map = playerService.getPlayerRankByName(playerName);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
