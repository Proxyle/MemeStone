package model.interfaces;

public interface ICard {
    String getCardById(Long cardId);
    String getCardByName(String cardName);
    String getAllCards();
}
