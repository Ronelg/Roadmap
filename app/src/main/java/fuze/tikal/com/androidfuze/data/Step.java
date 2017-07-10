package fuze.tikal.com.androidfuze.data;

public abstract class Step {
    public enum TYPE {MOVIE, QUESTION, ARTICLE}
    private long id;
    private TYPE type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }
}
