package fuze.tikal.com.androidfuze.di.component;

import dagger.Component;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;
import fuze.tikal.com.androidfuze.di.PerActivity;
import fuze.tikal.com.androidfuze.di.module.ActivityModule;
import fuze.tikal.com.androidfuze.ui.home.HomeActivity;

/**
 * Created by ronelg on 7/10/17.
 */

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(HomeActivity activity);

    RoadmapRepository provideRoadmapRepository();

}
