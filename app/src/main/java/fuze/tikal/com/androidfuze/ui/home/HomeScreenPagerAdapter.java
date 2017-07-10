package fuze.tikal.com.androidfuze.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fuze.tikal.com.androidfuze.ui.author.AuthorTabFragment;
import fuze.tikal.com.androidfuze.ui.student.StudentTabFragment;
import fuze.tikal.com.androidfuze.ui.tutor.TutorTabFragment;

/**
 * Created by motibartov on 10/07/2017.
 */

public class HomeScreenPagerAdapter extends FragmentStatePagerAdapter{


    private final int mNumOfTabs;

    public HomeScreenPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        mNumOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return AuthorTabFragment.newInstance(null, null);
            case 1:

                return TutorTabFragment.newInstance(null, null);
            case 2:

                return StudentTabFragment.newInstance(null, null);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
