package api.msservices;

import api.model.Card;
import api.model.resources.Collection;
import api.msrepositories.CardRepository;
import api.msrepositories.PlayerRepository;
import api.msservices.interfaces.ICollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService implements ICollectionService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Card> getCollectionByPlayerName(String playerName) {
        Collection collection = new Collection();
        playerRepository.find
    }

    @Override
    public List<Card> getCollectionByPlayerId(Long playerId) {

    }
}
