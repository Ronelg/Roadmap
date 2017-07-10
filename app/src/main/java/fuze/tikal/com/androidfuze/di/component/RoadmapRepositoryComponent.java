package fuze.tikal.com.androidfuze.di.component;

import dagger.Component;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;
import fuze.tikal.com.androidfuze.di.module.RoadmapApplication;
import fuze.tikal.com.androidfuze.di.module.RoadmapRepositoryModule;
import fuze.tikal.com.androidfuze.di.module.ApplicationModule;
import javax.inject.Singleton;

/**
 * This is a Dagger component. Refer to {@link RoadmapApplication} for the list of Dagger components
 * used in this application.
 * <P>
 * Even though Dagger allows annotating a {@link Component @Component} as a singleton, the code
 * itself must ensure only one instance of the class is created. This is done in {@link
 * RoadmapApplication}.
 */
@Singleton
@Component(modules = {RoadmapRepositoryModule.class, ApplicationModule.class})
public interface RoadmapRepositoryComponent {

    RoadmapRepository getRoadmapRepository();
}