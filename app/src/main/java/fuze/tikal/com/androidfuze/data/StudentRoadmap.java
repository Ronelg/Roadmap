package fuze.tikal.com.androidfuze.data;

import java.net.URL;
import java.util.Map;

/**
 * Created by kirill on 10/07/2017.
 */

public class StudentRoadmap {
    private Roadmap baseRoadmap;
    private URL repoUrl;
    private Tutor tutor;
    /**
     * key: Roadmap stage from baseRoadmap.steps
     * value: true is completed
     */
    private Map<String, Boolean> roadmapProgress;
}
