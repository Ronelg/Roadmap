package fuze.tikal.com.androidfuze.data.source;

import android.support.annotation.NonNull;
import fuze.tikal.com.androidfuze.data.Roadmap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;

import static dagger.internal.Preconditions.checkNotNull;

public class RoadmapRepository implements RoadmapDataSource {

    private static RoadmapRepository INSTANCE = null;

    private final RoadmapDataSource mRoadmapRemoteDataSource;

    private final RoadmapDataSource mRoadmapLocalDataSource;

    Map<String, Roadmap> mCachedRoadmaps;

    boolean mCacheIsDirty = false;

    public static RoadmapRepository getInstance(@NonNull RoadmapDataSource roadmapRemoteDataSource,
        @NonNull RoadmapDataSource roadmapLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new RoadmapRepository(roadmapRemoteDataSource, roadmapLocalDataSource);
        }
        return INSTANCE;
    }

    private RoadmapRepository(@NonNull RoadmapDataSource roadmapRemoteDataSource,
        @NonNull RoadmapDataSource roadmapLocalDataSource) {
        mRoadmapRemoteDataSource = checkNotNull(roadmapRemoteDataSource);
        mRoadmapLocalDataSource = checkNotNull(roadmapLocalDataSource);
    }

    @Override
    public Observable<List<Roadmap>> getRoadmaps() {
        // Respond immediately with cache if available and not dirty
        if (mCachedRoadmaps != null && !mCacheIsDirty) {
            return Observable.from(mCachedRoadmaps.values()).toList();
        } else if (mCachedRoadmaps == null) {
            mCachedRoadmaps = new LinkedHashMap<>();
        }

        Observable<List<Roadmap>> remoteRoadmaps = getAndSaveRemoteRoadmaps();

        if (mCacheIsDirty) {
            return remoteRoadmaps;
        } else {
            // Query the local storage if available. If not, query the network.
            Observable<List<Roadmap>> localRoadmaps = getAndCacheLocalRoadmaps();
            return Observable.concat(localRoadmaps, remoteRoadmaps)
                .filter(roadmaps -> !roadmaps.isEmpty())
                .first();
        }
    }

    private Observable<List<Roadmap>> getAndCacheLocalRoadmaps() {
        return mRoadmapLocalDataSource.getRoadmaps()
            .flatMap(roadmaps -> Observable.from(roadmaps)
                .doOnNext(roadmap -> mCachedRoadmaps.put(roadmap.getId(), roadmap))
                .toList());
    }

    private Observable<List<Roadmap>> getAndSaveRemoteRoadmaps() {
        return mRoadmapRemoteDataSource.getRoadmaps()
            .flatMap(roadmaps -> Observable.from(roadmaps)
                .doOnNext(roadmap -> {
                    mRoadmapLocalDataSource.saveRoadmap(roadmap);
                    mCachedRoadmaps.put(roadmap.getId(), roadmap);
                })
                .toList())
            .doOnCompleted(() -> mCacheIsDirty = false);
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
        mRoadmapRemoteDataSource.saveRoadmap(roadmap);
        mRoadmapLocalDataSource.saveRoadmap(roadmap);

        if(mCachedRoadmaps == null) {
            mCachedRoadmaps = new LinkedHashMap<>();
        }

        // Do in memory cache update to keep the app UI up to date
        mCachedRoadmaps.put(roadmap.getId(), roadmap);
    }

    @Override
    public void refreshRoadmaps() {
        mCacheIsDirty = true;
    }
}
