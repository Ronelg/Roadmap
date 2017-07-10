package fuze.tikal.com.androidfuze.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.utils.ActivityUtils;

public class HomeActivity extends AppCompatActivity implements HomeContract.View{

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
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void setProgressIndicator(boolean active) {

    }
}
