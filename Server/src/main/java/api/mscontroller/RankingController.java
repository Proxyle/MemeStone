package api.mscontroller;

import api.model.resources.PlayerRank;
import api.msservices.interfaces.IRankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@RestController
@RequestMapping(value="/rank")
public class RankingController {
    @Autowired
    private IRankingService rankingService;

    @GetMapping(value = "/")
    public ResponseEntity<List<PlayerRank>> getAll() {
        List<PlayerRank> playerRanks = rankingService.getAll();
        if (playerRanks == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerRanks, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{playerName}")
    public ResponseEntity<PlayerRank> getPlayerRankByName(@PathVariable("playerName") String playerName) {
        PlayerRank playerRank = rankingService.getRankByName(playerName);
        if (playerRank == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerRank, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{playerId}")
    public ResponseEntity<PlayerRank> getPlayerRankById(@PathVariable("playerId") long playerId) {
        PlayerRank playerRank = rankingService.getRankById(playerId);
        if (playerRank == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(playerRank, HttpStatus.OK);
    }
}
