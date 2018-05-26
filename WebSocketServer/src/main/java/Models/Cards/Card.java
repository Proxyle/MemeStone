package Models.Cards;

import Logic.GameLobby.IGameLogic;

public abstract class Card {

    private String name;
    private String context;
    private int cost;

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public int getCost() {
        return cost;
    }

    public Card(String name, String context, int cost){
        this.name = name;
        this.context = context;
        this.cost = cost;
    }

    public abstract boolean play(IGameLogic gameLogic, int[] location);

    @Override
    public String toString() {
        return name + ", " + context + ", cost: " + cost;
    }
}
