package fuze.tikal.com.androidfuze.data;

import java.util.List;

/**
 * Created by ronelg on 7/10/17.
 */

public class Author {

    private String id;
    private String name;
    private List<Roadmap> roadmaps;
    private List<Tutor> tutors;
    private State state = State.NOT_PUBLISHED;

    enum State {
        PULISHED,
        NOT_PUBLISHED,
        EDIT
    }
}
