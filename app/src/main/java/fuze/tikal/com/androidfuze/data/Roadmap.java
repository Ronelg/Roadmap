package fuze.tikal.com.androidfuze.data;


import java.util.List;

/**
 * Created by ronelg on 7/10/17.
 */

public class Roadmap {

    public enum Status {PUBLISHED, DRAFT};

    private int version;
    private Status status;

    private List<Step> steps;

}
