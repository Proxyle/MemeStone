package api.mscontroller;

import api.model.Player;
import api.model.resources.PlayerRank;
import api.msservices.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/player")
public class PlayerController {
    @Autowired
    private IPlayerService playerService;

    @PostMapping(value = "/login")
    public ResponseEntity<Player> login(@RequestBody Player p) {
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Player player = playerService.login(p);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Player> register(@RequestBody Player p) {
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Player player = playerService.register(p);
        if (player == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(player, HttpStatus.OK);
    }
}
