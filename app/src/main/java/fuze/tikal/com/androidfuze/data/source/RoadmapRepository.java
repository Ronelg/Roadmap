package fuze.tikal.com.androidfuze.data.source;


import java.util.HashMap;
import java.util.Map;

import fuze.tikal.com.androidfuze.data.Roadmap;
import fuze.tikal.com.androidfuze.data.Student;

public class RoadmapRepository implements RoadmapDataSource {

    private Map<Integer, Roadmap> roadmaps;
    private Map<Integer, Student> students;
    protected RoadmapRepository() {
        roadmaps = new HashMap<>();
        students = new HashMap<>();
    }

    /**
     *
     * @param r
     * @return true is addition was successful, false otherwise
     */
    public boolean addRoadmap(Roadmap r) {
        roadmaps.put(r.getId(), r);
        return true;
    }


    public Roadmap getRoadmap(int id) {
        return roadmaps.get(id);
    }

    public int getNumStudents() {
        return students.size();
    }

    public void addStudent(Student s) {
        students.put(s.getId(), s);
    }
}
