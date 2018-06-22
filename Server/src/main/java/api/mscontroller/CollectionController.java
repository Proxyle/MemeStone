package api.mscontroller;

import api.model.Player;
import api.model.resources.PlayerCard;
import api.msservices.interfaces.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/collection")
public class CollectionController {
    @Autowired
    private ICollectionService collectionService;

    @PostMapping(value = "/update")
    public ResponseEntity<Player> updateCollectionForPlayer(@RequestBody PlayerCard playerCard) {
        if (playerCard == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        collectionService.addCardToCollection(playerCard.getPlayer(), playerCard.getCard());
        return new ResponseEntity<>(playerCard.getPlayer(), HttpStatus.OK);
    }
}
