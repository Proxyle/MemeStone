package api.msservices;

import api.model.Card;
import api.model.Player;
import api.msservices.interfaces.ICollectionService;
import org.springframework.stereotype.Service;

@Service
public class CollectionService implements ICollectionService {
    @Override
    public void addCardToCollection(Player player, Card card) {
        player.addCardToCollection(card);
    }
}
