package fuze.tikal.com.androidfuze.data;


<<<<<<< HEAD
import java.util.List;
=======
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
>>>>>>> master

/**
 * Created by ronelg on 7/10/17.
 */

public class Roadmap {
    private URL baseRepoUrl;

    private String version;
    private String status;

    /**
     * key: stage name
     * value: content of the stage, can be free text description, video URL or other content
     */
    private Map<String, RoadmapStepContent> steps = new HashMap<>();
    private String title;
    private String desctiprion;

    public URL getBaseRepoUrl() {
        return baseRepoUrl;
    }

    public void setBaseRepoUrl(URL baseRepoUrl) {
        this.baseRepoUrl = baseRepoUrl;
    }

    public Set<String> getSteps() {
        return steps.keySet();
    }

    public void adStep(String name, RoadmapStepContent content) {
        steps.put(name, content);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesctiprion() {
        return desctiprion;
    }

    public void setDesctiprion(String desctiprion) {
        this.desctiprion = desctiprion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

<<<<<<< HEAD
    public enum Status {PUBLISHED, DRAFT};

    private int version;
    private Status status;

    private List<Step> steps;

=======
    public void setStatus(String status) {
        this.status = status;
    }
>>>>>>> master
}
