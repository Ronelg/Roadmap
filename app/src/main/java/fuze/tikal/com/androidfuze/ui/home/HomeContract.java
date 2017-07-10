package fuze.tikal.com.androidfuze.ui.home;

import fuze.tikal.com.androidfuze.ui.BasePresenter;
import fuze.tikal.com.androidfuze.ui.BaseView;

/**
 * Created by ronelg on 7/10/17.
 */

public class HomeContract {

    interface View extends BaseView<Presenter> {

        void setProgressIndicator(boolean active);

    }

    interface Presenter extends BasePresenter {

    }

}
