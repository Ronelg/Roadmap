package fuze.tikal.com.androidfuze.data.source;

import android.support.annotation.NonNull;
import fuze.tikal.com.androidfuze.data.Roadmap;
import java.util.List;
import rx.Observable;

public interface RoadmapDataSource {

    Observable<List<Roadmap>> getRoadmaps();

    Observable<List<Roadmap>> getRoadmaps(@NonNull String userId);

    void completeRoadmap(@NonNull String roadmapId);

    void saveRoadmap(@NonNull Roadmap roadmap);

    void refreshRoadmaps();
}
