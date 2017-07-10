package fuze.tikal.com.androidfuze.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.data.source.RoadmapRepository;
import fuze.tikal.com.androidfuze.di.component.DaggerActivityComponent;
import fuze.tikal.com.androidfuze.di.module.RoadmapApplication;
import fuze.tikal.com.androidfuze.utils.ActivityUtils;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class HomeActivity extends AppCompatActivity {

    @Inject RoadmapRepository roadmapRepository;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment =
            (HomeFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (homeFragment == null) {
            // Create the fragment
            homeFragment = HomeFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                getSupportFragmentManager(), homeFragment, R.id.container);
        }

        DaggerActivityComponent.builder()
            .applicationComponent(((RoadmapApplication)getApplication()).getComponent())
            .build().inject(this);

        roadmapRepository.getRoadmaps()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(roadmaps -> {
                Timber.i(roadmaps.size()+"");
            }, err -> {
                Timber.i(err);
            });
    }
}
