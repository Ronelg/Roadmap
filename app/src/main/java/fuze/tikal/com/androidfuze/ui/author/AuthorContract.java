package fuze.tikal.com.androidfuze.ui.author;

import java.util.List;

import fuze.tikal.com.androidfuze.data.Roadmap;
import fuze.tikal.com.androidfuze.ui.BasePresenter;
import fuze.tikal.com.androidfuze.ui.BaseView;

/**
 * Created by asafvaron on 10/07/2017.
 */

interface AuthorContract {

    interface View extends BaseView<Presenter> {
        void setProgressIndicator(boolean active);

        void onRoadMapsLoaded(List<Roadmap> roadmapList);
    }

    interface Presenter extends BasePresenter {

        void getRoadMaps();
    }
}
