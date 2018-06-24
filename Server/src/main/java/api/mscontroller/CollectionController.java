package api.mscontroller;

import api.model.resources.Collection;
import api.msservices.interfaces.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
@RequestMapping(value="/collection")
public class CollectionController {
    @Autowired
    private ICollectionService collectionService;

    @GetMapping(value = "/id/{playerId}")
    public ResponseEntity<Collection> getCollectionById(@PathVariable long playerId) {
        /*
        Collection collection = collectionService.getCollectionByPlayerId(playerId);
        if (collection == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
        */
        return null;
    }

    @GetMapping(value = "/name/{playerName}")
    public ResponseEntity<Collection> getCollectionByName(@PathVariable String playerName) {
        /*
        Collection collection = collectionService.getCollectionByPlayerName(playerName);
        if (collection == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(collection, HttpStatus.OK);
        */
        return null;
    }
}
