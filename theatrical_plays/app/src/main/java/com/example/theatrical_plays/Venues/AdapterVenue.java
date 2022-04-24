package com.example.theatrical_plays.Venues;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.theatrical_plays.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdapterVenue extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<Venue> recyclerViewItems;
    private final Context mContext;
    private CheckedVenue listener;
    public ArrayList<Venue> venuesClicked = new ArrayList<>();
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
        if(recyclerViewItems != null && recyclerViewItems.size()>0)
        {
            menuItemHolder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (menuItemHolder.checkBox.isChecked())
                    {
                        venuesClicked.add(venue);
                        venue.setChecked(true);
                    }
                    else {
                        venuesClicked.remove(venue);
                        venue.setChecked(false);
                    }
                }
            });

            menuItemHolder.checkBox.setChecked(venue.getChecked());


        }

        menuItemHolder.button.setOnClickListener(view -> {
            String address = menuItemHolder.title.getText().toString();
            if (address != "ONLINE")
            {
                List<Address> addressVenue = null;
                Geocoder geocoder = new Geocoder(mContext);
                try {
                    addressVenue = geocoder.getFromLocationName(address, 2);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q="+ Uri.encode(address)));
                Intent chooser = Intent.createChooser(intent, "Launch Maps");
                mContext.startActivity(chooser);
            }



        });



    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public ArrayList<Venue> getRecyclerViewItems() {
        return venuesClicked;
    }

    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView address;
        public Button button;
        CheckBox checkBox;
        MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            button = (Button)itemLayoutView.findViewById(R.id.picker);
            title = (TextView) itemLayoutView.findViewById(R.id.VenueTitle);
            address = (TextView) itemLayoutView.findViewById(R.id.venueAddress);
            checkBox = (CheckBox) itemLayoutView.findViewById(R.id.checkedVenue);
        }
    }
}
