package fuze.tikal.com.androidfuze.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import fuze.tikal.com.androidfuze.data.source.RoadmapDataSource;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;
import fuze.tikal.com.androidfuze.data.source.local.RoadmapLocalDataSource;
import fuze.tikal.com.androidfuze.data.source.remote.RoadmapRemoteDataSource;
import fuze.tikal.com.androidfuze.di.Local;
import fuze.tikal.com.androidfuze.di.Remote;
import javax.inject.Singleton;

/**
 * This is used by Dagger to inject the required arguments into the {@link RoadmapRepository}.
 */
@Module
public class RoadmapRepositoryModule {

    @Singleton
    @Provides
    @Local
    RoadmapDataSource provideRoadmapLocalDataSource(Context context) {
        return new RoadmapLocalDataSource(context);
    }

    @Singleton
    @Provides
    @Remote
    RoadmapDataSource provideRoadmapRemoteDataSource() {
        return new RoadmapRemoteDataSource();
    }

}