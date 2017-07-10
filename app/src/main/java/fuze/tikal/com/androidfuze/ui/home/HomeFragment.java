package fuze.tikal.com.androidfuze.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import fuze.tikal.com.androidfuze.R;

public class HomeFragment extends Fragment implements HomeContract.View {


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public HomeFragment() {
        // Requires empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        return v;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void setProgressIndicator(boolean active) {

    }
}
