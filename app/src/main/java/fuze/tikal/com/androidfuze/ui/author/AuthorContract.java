package fuze.tikal.com.androidfuze.ui.author;

import fuze.tikal.com.androidfuze.ui.BasePresenter;
import fuze.tikal.com.androidfuze.ui.BaseView;

/**
 * Created by asafvaron on 10/07/2017.
 */

interface AuthorContract {

    interface View extends BaseView<Presenter> {
        void setProgressIndicator(boolean active);

    }

    interface Presenter extends BasePresenter {

    }
}
