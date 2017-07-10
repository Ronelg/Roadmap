package fuze.tikal.com.androidfuze.data.source.remote;

import android.support.annotation.NonNull;
import fuze.tikal.com.androidfuze.data.Roadmap;
import fuze.tikal.com.androidfuze.data.source.RoadmapDataSource;
import java.util.List;
import javax.inject.Singleton;
import rx.Observable;

@Singleton
public class RoadmapRemoteDataSource implements RoadmapDataSource {

    private static RoadmapRemoteDataSource INSTANCE;

    public static RoadmapRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RoadmapRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private RoadmapRemoteDataSource() {}

    @Override
    public Observable<List<Roadmap>> getRoadmaps() {
        return null;
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
