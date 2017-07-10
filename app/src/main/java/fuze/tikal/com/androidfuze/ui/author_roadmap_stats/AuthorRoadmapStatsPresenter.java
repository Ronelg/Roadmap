package fuze.tikal.com.androidfuze.ui.author_roadmap_stats;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by asafvaron on 10/07/2017.
 */

public class AuthorRoadmapStatsPresenter implements AuthorRoadmapStatsContract.Presenter {
    private final AuthorRoadmapStatsContract.View mView;

    public AuthorRoadmapStatsPresenter(AuthorRoadmapStatsContract.View view) {
        mView = checkNotNull(view, "View must not be null!");
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
