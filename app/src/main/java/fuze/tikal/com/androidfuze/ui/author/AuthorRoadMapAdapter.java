package fuze.tikal.com.androidfuze.ui.author;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by asafvaron on 10/07/2017.
 */

public class AuthorRoadMapAdapter extends RecyclerView.Adapter<AuthorRoadMapAdapter.RoadMapCardViewHolder>{


    @Override
    public RoadMapCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RoadMapCardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RoadMapCardViewHolder extends RecyclerView.ViewHolder {

        public RoadMapCardViewHolder(View itemView) {
            super(itemView);
        }
    }
}
