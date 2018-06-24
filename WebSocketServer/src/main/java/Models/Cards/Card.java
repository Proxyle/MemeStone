package Models.Cards;

import Logic.GameLogic.IGameLogic;

public abstract class Card {

    Long id;
    private String name;
    private String context;
    private int cost;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public int getCost() {
        return cost;
    }

    public Card(Long id, String name, String context, int cost){
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
