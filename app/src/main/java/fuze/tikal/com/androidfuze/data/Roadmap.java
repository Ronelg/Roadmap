package fuze.tikal.com.androidfuze.data;


import java.util.List;

/**
 * Created by ronelg on 7/10/17.
 */

public class Roadmap {

    public enum Status {PUBLISHED, DRAFT};

    private String id;
    private int version;
    private Status status;

    private List<Step> steps;

    public String getId() {
        return id;
    }

    public int getVersion() {
        return version;
    }

    public Status getStatus() {
        return status;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
