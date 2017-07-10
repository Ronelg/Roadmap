package fuze.tikal.com.androidfuze.data.source.local;

import fuze.tikal.com.androidfuze.data.Roadmap;
import fuze.tikal.com.androidfuze.data.Student;
import fuze.tikal.com.androidfuze.data.StudentRoadmap;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;

public class MockRoadmapRepository extends RoadmapRepository {
    private static RoadmapRepository instance;

    private MockRoadmapRepository() {
        super();

        mockRoadmaps();
        mockStudents();
    }

    public static RoadmapRepository get() {
        if (instance == null) {
            instance = new MockRoadmapRepository();
        }

        return instance;
    }


    private void mockStudents() {
        StudentRoadmap studentRoadmap = new StudentRoadmap();
        Student student = new Student();
        studentRoadmap.setBaseRoadmap(getRoadmap(1));
        studentRoadmap.setId(3);
        student.setId(4);
        student.adRoadmap(studentRoadmap);

        addStudent(student);
    }

    private void mockRoadmaps() {
        Roadmap mockRoadmap = new Roadmap();

        mockRoadmap.setId(1);
        mockRoadmap.setTitle("Kotlin");
        mockRoadmap.setDesctiprion("Develop Android application in Kotlin");

        addRoadmap(mockRoadmap);

        mockRoadmap.setId(2);
        mockRoadmap.setTitle("Data Binding");
        mockRoadmap.setDesctiprion("Refactor Android application to use Data Binding");

        addRoadmap(mockRoadmap);
    }

}
