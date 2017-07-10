package fuze.tikal.com.androidfuze.ui.home;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.ui.adapter.VpAdapter;
import fuze.tikal.com.androidfuze.ui.fragments.StepFragment;

public class PlayerActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;
    private VpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_player);

        mViewPager = (ViewPager) findViewById(R.id.pager);

        //TODO pass the Steps tp the adapter.
        adapter = new VpAdapter (getSupportFragmentManager (),new ArrayList<StepFragment> ());

        mViewPager.setAdapter(adapter);
    }


}
