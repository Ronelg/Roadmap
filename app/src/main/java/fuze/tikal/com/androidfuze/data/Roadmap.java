package fuze.tikal.com.androidfuze.data;


import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ronelg on 7/10/17.
 */

public class Roadmap {
    private int id;
    private URL baseRepoUrl;

    private String version;
    private String status;

    /**
     * key: stage name
     * value: content of the stage, can be free text description, video URL or other content
     */
    private Map<Integer, Step> steps = new HashMap<>();
    private String title;
    private String desctiprion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public URL getBaseRepoUrl() {
        return baseRepoUrl;
    }

    public void setBaseRepoUrl(URL baseRepoUrl) {
        this.baseRepoUrl = baseRepoUrl;
    }

    public Collection<Step> getSteps() {
        return steps.values();
    }

    public void adStep(Step content) {
        steps.put(content.getId(), content);
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

    public void setStatus(String status) {
        this.status = status;
    }
}
