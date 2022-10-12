package com.example.theatrical_plays;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatrical_plays.Actor.Adapter;
import com.example.theatrical_plays.Actor.Bio;
import com.example.theatrical_plays.Actor.ClickListener;
import com.example.theatrical_plays.Productions.Events;

import java.util.List;

public class AdapterEvent extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    @NonNull
    private final List<Events> recyclerViewItems;
    private final Context mContext;
    private ClickListener listener;

    public AdapterEvent(@NonNull List<Events> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;

    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_events_per_production, null);
        return new MenuItemViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
        final Events events= (Events) recyclerViewItems.get(position);

        menuItemHolder.title.setText(events.getTitle());
        menuItemHolder.address.setText(events.getAddress());
        menuItemHolder.price.setText(events.getPriceRange());
        if(getItemCount() == 0)
        {
            menuItemHolder.title.setText("Δεν υπάρχουν διοργανώσεις για αυτή την παράσταση");
        }

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView address;
        public TextView price;

        MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            title = (TextView) itemLayoutView.findViewById(R.id.eventTitle);
            address = (TextView) itemLayoutView.findViewById(R.id.eventAddress);
            price = (TextView) itemLayoutView.findViewById(R.id.eventPrices);
        }
    }
}
