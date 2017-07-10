package fuze.tikal.com.androidfuze.di.component;

import android.app.Application;
import android.content.Context;
import dagger.Component;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;
import fuze.tikal.com.androidfuze.di.module.ApplicationModule;
import fuze.tikal.com.androidfuze.di.module.RoadmapApplication;
import fuze.tikal.com.androidfuze.di.module.RoadmapRepositoryModule;
import javax.inject.Singleton;

/**
 * Created by ronelg on 7/10/17.
 */

@Singleton
@Component(modules = { ApplicationModule.class, RoadmapRepositoryModule.class})
public interface ApplicationComponent {

    void inject(RoadmapApplication app);

    Context provideContext();

    Application provideApplication();

    RoadmapRepository getRoadmapRepository();
}
