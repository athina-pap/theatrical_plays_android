package com.example.theatrical_plays.Productions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatrical_plays.R;
import com.example.theatrical_plays.Venues.Venue;

import java.util.List;

public class AdapterProduction extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final List<Production> recyclerViewItems;
    private final Context mContext;

    public AdapterProduction(List<Production> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.productions_layout, null);
        return new AdapterProduction.MenuItemViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        AdapterProduction.MenuItemViewHolder menuItemHolder = (AdapterProduction.MenuItemViewHolder) holder;
        final Production production = (Production) recyclerViewItems.get(position);
        menuItemHolder.title.setText(production.getTitle());
        menuItemHolder.duration.setText(production.getDuration());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView duration;
        public MenuItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ProductionTitle);
            duration = (TextView) itemView.findViewById(R.id.duration);
        }
    }
}
