package fuze.tikal.com.androidfuze.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import fuze.tikal.com.androidfuze.BuildConfig;
import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.data.source.GithubOauth;
import fuze.tikal.com.androidfuze.data.source.remote.GithubRemote;
import fuze.tikal.com.androidfuze.data.source.remote.GithubRepository;


public class HomeFragment extends Fragment implements HomeContract.View {
    private static final String TAG = "HomeFragment";
    private Button loginButton;
    public Button reposBtn;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    public static final String GITHUB_ID = BuildConfig.GITHUB_ID;
    public static final String GITHUB_SECRET = BuildConfig.GITHUB_SECRET;
    private GithubRemote github;
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
        reposBtn = (Button)v.findViewById(R.id.btnRepos);
        reposBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        List<GithubRepository> repos  = github.repos();
                        for(GithubRepository repo: repos) {
                            Log.d(TAG, repo.getFullName());
                        }
                    }
                }).start();

            }
        });
        github = new GithubRemote();
        github.init(getActivity());

        return v;
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {

    }

    @Override
    public void setProgressIndicator(boolean active) {

    }
}
