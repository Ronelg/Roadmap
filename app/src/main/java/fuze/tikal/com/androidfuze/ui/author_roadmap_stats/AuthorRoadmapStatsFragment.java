package fuze.tikal.com.androidfuze.ui.author_roadmap_stats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import fuze.tikal.com.androidfuze.R;

/**
 * Created by asafvaron on 10/07/2017.
 */

public class AuthorRoadmapStatsFragment extends Fragment
        implements AuthorRoadmapStatsContract.View {

    private static final String KEY_ROADMAP_ID = "roadmap_id";
    private TextView mName;
    private TextView mDescription;
    private TextView mState;
    private TextView mNumOfStudents;
    private TextView mNumOfGraduates;
    private RatingBar mRatingBar;

    private AuthorRoadmapStatsContract.Presenter mPresenter;

    public static AuthorRoadmapStatsFragment newInstance(int roadmapId) {
        AuthorRoadmapStatsFragment frag = new AuthorRoadmapStatsFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_ROADMAP_ID, roadmapId);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_author_roadmap_stats, container, false);

        mName = v.findViewById(R.id.name);
        mDescription = v.findViewById(R.id.description);
        mState = v.findViewById(R.id.state);
        mNumOfStudents = v.findViewById(R.id.num_of_students);
        mNumOfGraduates = v.findViewById(R.id.num_of_graduates);
        mRatingBar = v.findViewById(R.id.ratingBar);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        // TODO: 10/07/2017 get the roadmap data
    }

    @Override
    public void setPresenter(AuthorRoadmapStatsContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
