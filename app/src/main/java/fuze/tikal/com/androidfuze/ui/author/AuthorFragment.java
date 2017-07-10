package fuze.tikal.com.androidfuze.ui.author;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fuze.tikal.com.androidfuze.R;

/**
 * Created by asafvaron on 10/07/2017.
 */

public class AuthorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_author, container, false);

        return v;
    }
}
