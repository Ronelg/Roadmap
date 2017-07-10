package fuze.tikal.com.androidfuze.ui.author;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.data.Roadmap;

/**
 * Created by asafvaron on 10/07/2017.
 */

public class AuthorFragment extends Fragment implements
        AuthorContract.View,
        View.OnClickListener,
        SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "AuthorFragment";

    private AuthorContract.Presenter mPresenter;

    // Views
    private RecyclerView mRoadMapsList;
    private TextView mMessageText;
    private SwipeRefreshLayout mSwipeLayout;

    public static AuthorFragment newInstance() {
        return new AuthorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_author, container, false);

        mSwipeLayout = v.findViewById(R.id.swipe_refresh_layout);
        mSwipeLayout.setOnRefreshListener(this);
        mMessageText = v.findViewById(R.id.message);
        mRoadMapsList = v.findViewById(R.id.road_maps_list);
        initRecyclerView();
        v.findViewById(R.id.fab_create_new_roadmap).setOnClickListener(this);

        return v;
    }

    private void initRecyclerView() {
        mRoadMapsList.setHasFixedSize(true);
        mRoadMapsList.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setPresenter(AuthorContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setProgressIndicator(boolean active) {
        mSwipeLayout.setRefreshing(active);
    }

    @Override
    public void onRoadMapsLoaded(List<Roadmap> roadmapList) {
        if (roadmapList.size() > 0) {

        } else{
            mMessageText.setText(getString(R.string.no_active_roadmaps));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_create_new_roadmap:
                Log.d(TAG, "onClick: FAB CLICKED");
                break;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.getRoadMaps();
    }
}
