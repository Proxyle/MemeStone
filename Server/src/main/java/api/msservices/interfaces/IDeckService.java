package api.msservices.interfaces;

import api.model.Card;
import api.model.Player;

import java.util.List;

public interface IDeckService {
    void updateDeck(List<Card> deck, Player player);
}
