package fuze.tikal.com.androidfuze.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.utils.ActivityUtils;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    HomeScreenPagerAdapter mPagerAdapter;
    ViewPager mViewPager;
    TabLayout mTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();

    }

    private void setViews() {

        mViewPager = (ViewPager) findViewById(R.id.homePager);
        mTabs = (TabLayout) findViewById(R.id.tabs);
        mTabs.addTab(mTabs.newTab().setText("Author"));
        mTabs.addTab(mTabs.newTab().setText("Tutor"));
        mTabs.addTab(mTabs.newTab().setText("Student"));
        mTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
        mPagerAdapter = new HomeScreenPagerAdapter(getSupportFragmentManager(),mTabs.getTabCount());

        mTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.setAdapter(mPagerAdapter);

    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void setProgressIndicator(boolean active) {

    }
}
