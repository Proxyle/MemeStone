package api.msservices.interfaces;

import api.model.Card;

import java.util.List;

public interface ICollectionService {
    List<Card> getCollectionByPlayerName(String playerName);
    List<Card> getCollectionByPlayerId(Long palyerId);
}
