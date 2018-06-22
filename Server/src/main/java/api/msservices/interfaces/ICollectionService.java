package api.msservices.interfaces;

import api.model.Card;
import api.model.Player;

public interface ICollectionService {
    void addCardToCollection(Player player, Card card);
}
