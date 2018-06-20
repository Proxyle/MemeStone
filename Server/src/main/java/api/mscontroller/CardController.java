package api.mscontroller;

import api.model.Card;
import api.msservices.interfaces.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/card")
public class CardController {
    @Autowired
    private ICardService cardService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        if (cards == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping(value = "/name/{cardName}")
    public ResponseEntity<Card> getCardByName(@PathVariable("cardName") String cardName) {
        Card card = cardService.getCardByName(cardName);
        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable("cardId") long cardId) {
        Card card = cardService.getCardById(cardId);
        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping(value = "/minion")
    public ResponseEntity<List<Card>> getAllMinionCards() {
        List<Card> minions = cardService.getAllMinionCards();
        if (minions == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(minions, HttpStatus.OK);
    }

    @GetMapping(value = "/spell")
    public ResponseEntity<List<Card>> getAllSpellCards() {
        List<Card> spells = cardService.getAllSpellCards();
        if (spells == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(spells, HttpStatus.OK);
    }
}
