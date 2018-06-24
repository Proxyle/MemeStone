package api.mscontroller;

import api.model.Card;
import api.model.resources.PlayerDeck;
import api.msservices.interfaces.IDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/deck/")
public class DeckController {
    @Autowired
    private IDeckService deckService;

    @PostMapping(value = "/update")
    public ResponseEntity<List<Card>> updateDeck(@RequestBody PlayerDeck playerDeck) {
        if (playerDeck == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        deckService.updateDeck(playerDeck.getDeck(), playerDeck.getPlayer());
        return new ResponseEntity<>(playerDeck.getDeck(), HttpStatus.OK);
    }
}
