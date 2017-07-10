package fuze.tikal.com.androidfuze.ui.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.data.Step;
import fuze.tikal.com.androidfuze.ui.fragments.StepFragment;

/**
 * Created by tamirnoach on 10/07/2017.
 */

public class VpAdapter extends FragmentStatePagerAdapter {

    private List<StepFragment> fragmentArrayList = null;
    public VpAdapter(FragmentManager fm, List<StepFragment> steps) {
        super(fm);
        fragmentArrayList = steps;
    }

    @Override
    public Fragment getItem(int i) {
        if (fragmentArrayList != null ){
            return fragmentArrayList.get (i);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size ();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "OBJECT " + (position + 1);
    }
}
