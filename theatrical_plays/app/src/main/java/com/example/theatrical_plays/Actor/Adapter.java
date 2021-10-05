package com.example.theatrical_plays.Actor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theatrical_plays.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final List<Object> recyclerViewItems;
    private final Context mContext;

    public Adapter(List<Object> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }


    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, null);
        return new MenuItemViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        MenuItemViewHolder menuItemHolder = (MenuItemViewHolder) holder;
        final Bio bio= (Bio) recyclerViewItems.get(position);

        menuItemHolder.title.setText(bio.getTitle());
        menuItemHolder.role.setText(bio.getRole());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }


    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView role;
        public TextView title;

        MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            role = (TextView) itemLayoutView.findViewById(R.id.roles);
            title = (TextView) itemLayoutView.findViewById(R.id.productions);
        }
    }
}


