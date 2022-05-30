package com.example.theatrical_plays.Productions;

import static java.lang.Integer.parseInt;

import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatrical_plays.Actor.Actor;
import com.example.theatrical_plays.Actor.Adapter;
import com.example.theatrical_plays.ProductionInfo;
import com.example.theatrical_plays.R;
import com.example.theatrical_plays.Venues.Venue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class AdapterProduction extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {
    private final List<Production> recyclerViewItems;
    private List<Production> recyclerViewItemsCopy;
    private final Context mContext;
    public ArrayList<Production> productionsClicked = new ArrayList<>();
    private boolean checked;

    public AdapterProduction(List<Production> recyclerViewItems, Context mContext, boolean checked) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
        recyclerViewItemsCopy = new ArrayList<>(recyclerViewItems);
        this.checked = checked;
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
        if(checked) {
            recyclerViewItemsCopy.clear();
            recyclerViewItemsCopy.addAll(recyclerViewItems);
        }
        if(recyclerViewItems != null && recyclerViewItems.size()>0) {
            menuItemHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (menuItemHolder.checkBox.isChecked()) {
                        productionsClicked.add(production);
                        production.setChecked(true);
                    } else {
                        productionsClicked.remove(production);
                        production.setChecked(false);
                    }
                }
            });

            menuItemHolder.checkBox.setChecked(production.isChecked());
        }
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    @Override
    public Filter getFilter() {
        return ProductionFilter;
    }
    private Filter ProductionFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence duration) {
            List<Production> filteredList = new ArrayList<>();

            if(duration.equals("300"))
            {
                filteredList.addAll(recyclerViewItems);
            }else
            {
                for (Production item : recyclerViewItems)
                {
                    if(!item.getDuration().equals( "Not found") && !item.getDuration().equals("")) {
                        String[] p =  item.getDuration().split("'");
                        String[] p2 = p[0].split(":");
                        int t1 = parseInt(p2[0]) * 60;
                        int t2 = t1 + parseInt(p2[1]);
                        if (t2 < parseInt(String.valueOf(duration))) {
                            filteredList.add(item);
                        }
                    }

                }

            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence duration, FilterResults filterResults) {
            recyclerViewItems.clear();
            recyclerViewItems.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView duration;
        public CheckBox checkBox;
        public MenuItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ProductionTitle);
            duration = (TextView) itemView.findViewById(R.id.duration);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkedProduction);
        }
    }
}
