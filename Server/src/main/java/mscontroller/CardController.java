package mscontroller;

import model.Card;
import msservices.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    private ICardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        List<Card> cards = cardService.getAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<Card> getCardById(@PathVariable("cardId") long cardId){
        Card card = cardService.getCardById(cardId);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping("/{cardName}")
    public ResponseEntity<Card> getCardByName(@PathVariable("cardName") String cardName){
        Card card = cardService.getCardByName(cardName);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }
}
