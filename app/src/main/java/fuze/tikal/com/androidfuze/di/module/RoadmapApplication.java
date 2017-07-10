package fuze.tikal.com.androidfuze.di.module;

import android.app.Application;
import fuze.tikal.com.androidfuze.di.component.ApplicationComponent;
import fuze.tikal.com.androidfuze.di.component.DaggerApplicationComponent;
import timber.log.Timber;

/**
 * Created by ronelg on 7/10/17.
 */

public class RoadmapApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        mApplicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .roadmapRepositoryModule(new RoadmapRepositoryModule())
            .build();
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
