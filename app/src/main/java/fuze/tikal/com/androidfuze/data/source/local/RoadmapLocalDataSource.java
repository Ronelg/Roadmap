package fuze.tikal.com.androidfuze.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;
import fuze.tikal.com.androidfuze.data.Roadmap;
import fuze.tikal.com.androidfuze.data.source.RoadmapDataSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

@Singleton
public class RoadmapLocalDataSource implements RoadmapDataSource {

    private static RoadmapLocalDataSource INSTANCE;

    //uid to roadmaps
    private Map<String, Roadmap> roadmaps = new LinkedHashMap<>();


    @Inject
    public RoadmapLocalDataSource(@NonNull Context context) {
    }

    @Override
    public Observable<List<Roadmap>> getRoadmaps() {
        return Observable.from(roadmaps.values()).toList();
    }

    @Override
    public Observable<List<Roadmap>> getRoadmaps(@NonNull String userId) {
        return null;
    }

    @Override
    public void completeRoadmap(@NonNull String roadmapId) {

    }

    @Override
    public void saveRoadmap(@NonNull Roadmap roadmap) {
        roadmaps.put(roadmap.getId(), roadmap);
    }

    @Override
    public void refreshRoadmaps() {
        //no-op
    }
}
