package fuze.tikal.com.androidfuze.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ronelg on 7/10/17.
 */

public class Student {
    private int id;

    private String firstName;
    private String secondName;
    private List<StudentRoadmap> roadmaps = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<StudentRoadmap> getRoadmaps() {
        return Collections.unmodifiableList(roadmaps);
    }

    public void adRoadmap(StudentRoadmap r) {
        roadmaps.add(r);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
