package Models.Card;

public abstract class Card {

    private Long id;
    private Rarity rarity;

    private String name;
    private String context;
    private int cost;


    public Card(Rarity rarity, String name, String context, int cost, Long id) {
        this.rarity = rarity;
        this.name = name;
        this.context = context;
        this.cost = cost;
        this.id = id;
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


    public Long getId() {
        return id;
    }

    public Card(String name, String context, int cost){
        this.name = name;
        this.context = context;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return name + ", " + context + ", cost: " + cost;

    }
}
