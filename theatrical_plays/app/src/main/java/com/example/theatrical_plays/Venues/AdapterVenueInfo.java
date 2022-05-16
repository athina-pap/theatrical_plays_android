package com.example.theatrical_plays.Venues;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatrical_plays.ProductionInfo;
import com.example.theatrical_plays.Productions.AdapterProduction;
import com.example.theatrical_plays.Productions.Production;
import com.example.theatrical_plays.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterVenueInfo extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    @NonNull
    private final List<Production> recyclerViewItems;
    private List<Production> recyclerViewItemsCopy;
    private final Context mContext;
    public ArrayList<Production> productionsClicked = new ArrayList<>();

    public AdapterVenueInfo(@NonNull List<Production> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_theaters_info, null);
        return new MenuItemViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
        final Production production = (Production) recyclerViewItems.get(position);
        menuItemHolder.title.setText(production.getTitle());
        menuItemHolder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(mContext, ProductionInfo.class);
                int_detail.putExtra("desc",production.getDesc());
                int_detail.putExtra("id",production.getId());
                int_detail.putExtra("title", production.getTitle());
                int_detail.putExtra("producer", production.getProducer());
                int_detail.putExtra("url", production.getUrl());
                mContext.startActivity(int_detail);
            }
        });
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
