package fuze.tikal.com.androidfuze.data;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirill on 10/07/2017.
 */

public class StudentRoadmap {
    private Roadmap baseRoadmap;

    private int id;
    private URL repoUrl;
    private Tutor tutor;
    /**
     * key: Roadmap stage from baseRoadmap.steps
     * value: true is completed
     */
    private Map<String, Boolean> roadmapProgress = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Roadmap getBaseRoadmap() {
        return baseRoadmap;
    }

    public void setBaseRoadmap(Roadmap baseRoadmap) {
        this.baseRoadmap = baseRoadmap;
    }

    public URL getRepoUrl() {
        return repoUrl;
    }

    public void setRepoUrl(URL repoUrl) {
        this.repoUrl = repoUrl;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
