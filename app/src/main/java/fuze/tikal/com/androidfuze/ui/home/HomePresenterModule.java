package fuze.tikal.com.androidfuze.ui.home;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ronelg on 7/10/17.
 */
@Module
public class HomePresenterModule {

    private final HomeContract.View mView;

    public HomePresenterModule(HomeContract.View view) {
        mView = view;
    }

    @Provides
    HomeContract.View provideHomesContractView() {
        return mView;
    }

}
