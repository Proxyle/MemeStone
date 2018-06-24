package REST.RESTmodels.resources;

public class PlayerRank {
    private Long id;
    private String userName;
    private int rank;

    public PlayerRank(Long id, String userName, int rank) {
        this.id = id;
        this.userName = userName;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getRank() {
        return rank;
    }
}
