package Websockets.Shared.messages;

import Models.Card.Card;

import java.util.List;

public class GetCollectionMessage {
    List<Card> collection;

    public GetCollectionMessage(List<Card> collection) {
        this.collection = collection;
    }

    public List<Card> getCollection() {
        return collection;
    }
}
