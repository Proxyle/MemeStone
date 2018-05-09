package api.msservices;

import api.model.Card;

import java.util.List;

public interface ICardService {
    List<Card> getAllCards();
    Card getCardById(long cardId);
    Card getCardByName(String cardName);
}
