package fuze.tikal.com.androidfuze.ui.author;

import java.util.ArrayList;
import java.util.List;

import fuze.tikal.com.androidfuze.data.Roadmap;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Created by asafvaron on 10/07/2017.
 */

public class AuthorPresenter implements AuthorContract.Presenter {


    private final AuthorContract.View mView;

    public AuthorPresenter(AuthorContract.View view) {
        mView = checkNotNull(view, "VIEW MUST NOT BE NULL!");
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getRoadMaps() {
        List<Roadmap> roadmapList = new ArrayList<>();


    }
}
