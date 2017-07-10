package fuze.tikal.com.androidfuze.ui.home;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.ui.adapter.VpAdapter;

public class PlayerActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;
    private FragmentStatePagerAdapter mAadapter;
    private VpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_player);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mAadapter);

    }


}
