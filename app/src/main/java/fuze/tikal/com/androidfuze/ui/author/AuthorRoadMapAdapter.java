package fuze.tikal.com.androidfuze.ui.author;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fuze.tikal.com.androidfuze.R;
import fuze.tikal.com.androidfuze.data.Roadmap;


public class AuthorRoadMapAdapter extends RecyclerView.Adapter<AuthorRoadMapAdapter.RoadMapCardViewHolder> {


    private final List<Roadmap> mData;
    private final ClickListener mListener;

    interface ClickListener {
        void onRoadMapClicked(Roadmap roadmap);
    }

    public AuthorRoadMapAdapter(List<Roadmap> data, ClickListener listener) {
        mListener = listener;
        mData = data;
    }

    @Override
    public RoadMapCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RoadMapCardViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.roadmap_card_item, null));
    }

    @Override
    public void onBindViewHolder(RoadMapCardViewHolder holder, int position) {
        final Roadmap roadmap = mData.get(position);
        holder.bind(roadmap);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onRoadMapClicked(roadmap);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class RoadMapCardViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView description;
        TextView state;

        RoadMapCardViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            state = itemView.findViewById(R.id.state);
        }

        void bind(Roadmap roadmap) {
            // TODO: 10/07/2017
        }
    }
}
