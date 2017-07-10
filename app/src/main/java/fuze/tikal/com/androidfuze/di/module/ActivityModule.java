package fuze.tikal.com.androidfuze.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;

/**
 * Created by ronelg on 7/10/17.
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }
}
