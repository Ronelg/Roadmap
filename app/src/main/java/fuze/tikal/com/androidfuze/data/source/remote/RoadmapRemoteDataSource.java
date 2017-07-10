package fuze.tikal.com.androidfuze.data.source.remote;

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
public class RoadmapRemoteDataSource implements RoadmapDataSource {

    private static final int SERVICE_LATENCY_IN_MILLIS = 5000;

    private final static Map<String, Roadmap> ROADMAPS_SERVICE_DATA;

    static {
        ROADMAPS_SERVICE_DATA = new LinkedHashMap<>(2);
    }

    public RoadmapRemoteDataSource() {}

    @Override
    public Observable<List<Roadmap>> getRoadmaps() {
        return Observable.from(ROADMAPS_SERVICE_DATA.values()).toList();
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
        //no-op
    }

    @Override
    public void refreshRoadmaps() {

    }
}
