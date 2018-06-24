package api.msservices;

import api.model.Card;
import api.model.Player;
import api.msservices.interfaces.IDeckService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeckService implements IDeckService {
    @Override
    public void updateDeck(List<Card> deck, Player player) {
        player.updateDeck(deck);
    }
}
