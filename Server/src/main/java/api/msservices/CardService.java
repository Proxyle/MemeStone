package api.msservices;

import api.model.Card;
import api.msrepositories.CardRepository;
import api.msrepositories.MinionRepository;
import api.msrepositories.SpellRepository;
import api.msservices.interfaces.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService implements ICardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private MinionRepository minionRepository;
    @Autowired
    private SpellRepository spellRepository;

    @Override
    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        try {
            cardRepository.findAll().forEach(c -> cards.add(c));
        } catch (Exception e) {
            return null;
        }
        return cards;
    }

    @Override
    public Card getCardById(long cardId) {
        Card card;
        try {
            card = cardRepository.findById(cardId).get();
        } catch (Exception e) {
            return null;
        }
        return card;
    }

    @Override
    public Card getCardByName(String cardName) {
        Card card;
        try {
            card = cardRepository.findByName(cardName);
        } catch (Exception e) {
            return null;
        }
        return card;
    }

    @Override
    public List<Card> getAllMinionCards() {
        List<Card> minions = new ArrayList<>();
        try {
            minionRepository.findAll().forEach(m -> minions.add(m));
        } catch (Exception e) {
            return null;
        }
        return minions;
    }

    @Override
    public List<Card> getAllSpellCards() {
        List<Card> spells = new ArrayList<>();
        try {
            spellRepository.findAll().forEach(s -> spells.add(s));
        } catch (Exception e) {
            return null;
        }
        return spells;
    }
}
