package Logic.Card;

public abstract class Card {
    private Rarity rarity;
    private String name;
    private String context;
    private int cost;

    public Card(Rarity rarity, String name, String context, int cost) {
        this.rarity = rarity;
        this.name = name;
        this.context = context;
        this.cost = cost;
    }

    public Card() {
    }

    public Rarity getRarity() {
        return rarity;
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
}
