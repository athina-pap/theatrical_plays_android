package com.example.theatrical_plays.Productions;

import static java.lang.Integer.parseInt;

import android.content.Context;
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
import com.example.theatrical_plays.R;
import com.example.theatrical_plays.Venues.Venue;

import java.util.ArrayList;
import java.util.List;

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
//
                    if(!item.getDuration().equals( "Not found")) {
                        if (parseInt(item.getDuration()) <= Integer.parseInt(duration.toString())) {

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
