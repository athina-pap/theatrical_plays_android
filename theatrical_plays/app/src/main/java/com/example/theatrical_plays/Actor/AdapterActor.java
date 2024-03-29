package com.example.theatrical_plays.Actor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatrical_plays.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AdapterActor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Actor> recyclerViewItems;
    private ClickListener listener;
    public List<Actor> recyclerViewItemsCopy ;
    Context context;


    public AdapterActor( List<Actor> recyclerViewItems, ClickListener listener) {
        this.recyclerViewItems = recyclerViewItems;
        this.listener = listener;
        recyclerViewItemsCopy = new ArrayList<>(recyclerViewItems);

    }
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(context);
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.actor_layout, null);

        return new MenuItemViewHolder(itemLayoutView);
    }


    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder holder, int position) {
        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
        final Actor actor = (Actor) recyclerViewItems.get(position);
        menuItemHolder.name.setText(actor.getName());
        String url = actor.getImageUrl();
        if(!(url.equals(""))) {
            Picasso.get().load(url).placeholder(R.drawable.ic_actor).into(menuItemHolder.imageUrl);
        }
        else {
            menuItemHolder.imageUrl.setImageResource(R.drawable.ic_actor);
        }

        //((MenuItemViewHolder) holder).imageUrl.setOnClickListener(v -> listener.onClickData(actor.getImageUrl(), actor.getName(), actor.getId()));

        ((MenuItemViewHolder) holder).imageUrl.setOnClickListener(v -> listener.onClickData(actor.getImageUrl(), actor.getName(), actor.getId()));
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }


//    public Filter getFilter() {
//        return actorFilter;
//    }
//
//    private Filter actorFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<Actor> filteredList = new ArrayList<>();
//
//            if(constraint == null || constraint.length() == 0)
//            {
//                   filteredList.addAll(recyclerViewItemsCopy);
//            }else
//                {
//                   String filTerPattern = constraint.toString().toLowerCase().trim();
//
//                    for (Actor item : recyclerViewItemsCopy)
//                    {
//                        if (item.getName().toLowerCase().contains(filTerPattern))
//                        {
//
//                            filteredList.add(item);
//                        }
//                    }
//                }
//            FilterResults results = new FilterResults();
//            results.values = filteredList;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            recyclerViewItems.clear();
//            recyclerViewItems.addAll((List) results.values);
//            notifyDataSetChanged();
//
//        }
//    };

    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imageUrl;

        MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            name = (TextView) itemLayoutView.findViewById(R.id.name);
            imageUrl = (ImageView) itemLayoutView.findViewById(R.id.image);
        }
    }
}
