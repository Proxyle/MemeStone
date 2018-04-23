package Models.Quest;

public class Quest {
    private String title;
    private String context;

    public Quest(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }
}
