package fuze.tikal.com.androidfuze.data;

public abstract class Step {
    public enum TYPE {MOVIE, QUESTION, ARTICLE}
    private int id;
    private TYPE type;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
