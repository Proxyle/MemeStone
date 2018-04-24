package msservices;

import model.Card;
import msrepositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        cardRepository.findAll().forEach(c -> cards.add(c));
        return cards;
    }

    @Override
    public Card getCardById(long cardId) {
        Card card = cardRepository.findById(cardId).get();
        return card;
    }

    @Override
    public Card getCardByName(String cardName) {
        Card card = cardRepository.findByName(cardName);
        return card;
    }
}
