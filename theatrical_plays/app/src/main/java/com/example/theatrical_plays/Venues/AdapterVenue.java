package com.example.theatrical_plays.Venues;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.theatrical_plays.R;
import java.util.List;

public class AdapterVenue extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Venue> recyclerViewItems;
    private final Context mContext;
    //ActorFragment fragmentactor;

    public AdapterVenue(List<Venue> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.venue_layout, null);
        return new AdapterVenue.MenuItemViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdapterVenue.MenuItemViewHolder menuItemHolder = (AdapterVenue.MenuItemViewHolder) holder;
        final Venue venue = (Venue) recyclerViewItems.get(position);

        menuItemHolder.title.setText(venue.getTitle());
        menuItemHolder.address.setText(venue.getAddress());


        //((AdapterVenue.MenuItemViewHolder) holder)..setOnClickListener(v -> listener.onClickData(actor.getImageUrl(), actor.getName(), actor.getId()));

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView address;

        MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            title = (TextView) itemLayoutView.findViewById(R.id.VenueTitle);
            address = (TextView) itemLayoutView.findViewById(R.id.venueAddress);
        }
    }
}
