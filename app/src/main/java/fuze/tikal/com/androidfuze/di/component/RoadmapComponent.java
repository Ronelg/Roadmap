package fuze.tikal.com.androidfuze.di.component;

import dagger.Component;
import fuze.tikal.com.androidfuze.di.module.RoadmapApplication;
import fuze.tikal.com.androidfuze.di.module.RoadmapRepositoryModule;
import fuze.tikal.com.androidfuze.di.scope.FragmentScoped;
import fuze.tikal.com.androidfuze.ui.home.HomeActivity;

/**
 * This is a Dagger component. Refer to {@link RoadmapApplication} for the list of Dagger components
 * used in this application.
 * <P>
 * Because this component depends on the {@link RoadmapRepositoryComponent}, which is a singleton, a
 * scope must be specified. All fragment components use a custom scope for this purpose.
 */
@FragmentScoped
@Component(dependencies = RoadmapRepositoryComponent.class, modules = RoadmapRepositoryModule.class)
public interface RoadmapComponent {

    void inject(HomeActivity activity);
}