package fuze.tikal.com.androidfuze.data;

public abstract class Step {
    public enum TYPE {MOVIE, QUESTION, ARTICLE}
    private long id;
    private TYPE type;
}
