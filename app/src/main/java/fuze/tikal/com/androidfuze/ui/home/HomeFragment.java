package fuze.tikal.com.androidfuze.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fuze.tikal.com.androidfuze.BuildConfig;
import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.data.source.GithubOauth;


public class HomeFragment extends Fragment implements HomeContract.View {
    private Button loginButton;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    public static final String GITHUB_ID = BuildConfig.GITHUB_ID;
    public static final String GITHUB_SECRET = BuildConfig.GITHUB_SECRET;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        loginButton = (Button)v.findViewById(R.id.btnLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GithubOauth
                        .Builder()
                        .withClientId(GITHUB_ID)
                        .withClientSecret(GITHUB_SECRET)
                        .withContext(getActivity())
                        .packageName("fuze.tikal.com.androidfuze")
                        .nextActivity("fuze.tikal.com.androidfuze.ui.home.HomeActivity")
                        .debug(true)
                        .execute();
            }
        });
        return v;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void setProgressIndicator(boolean active) {

    }
}
