package com.example.theatrical_plays.Home;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.theatrical_plays.R;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterTrailer extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final List<Object> recyclerViewItems;
    private final Context mContext;

    public AdapterTrailer(List<Object> recyclerViewItems, Context mContext) {
        this.recyclerViewItems = recyclerViewItems;
        this.mContext = mContext;
    }

    public RecyclerView.@NotNull ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_trailer, null);
        return new AdapterTrailer.MenuItemViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        AdapterTrailer.MenuItemViewHolder menuItemHolder = (AdapterTrailer.MenuItemViewHolder) holder;
        final Trailer trailer = (Trailer) recyclerViewItems.get(position);
        menuItemHolder.title.setText(trailer.getTitle());
        menuItemHolder.prod.setText(trailer.getProducer());
        menuItemHolder.desc.setText(trailer.getDescription());
        menuItemHolder.trailer.loadUrl(trailer.getUrl());

    }



        //Uri uri = Uri.parse(url);
        //menuItemHolder.trailer.setVideoPath(url);
        //menuItemHolder.trailer.start();

       // menuItemHolder.trailer.setVideoURI(uri);
        //menuItemHolder.trailer.requestFocus();
        //menuItemHolder.trailer.start();



    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    private class MenuItemViewHolder extends RecyclerView.ViewHolder {
        public WebView trailer;
        public TextView desc;
        public TextView prod;
        public TextView title;
        public MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            prod = (TextView)itemLayoutView.findViewById(R.id.prod);
            title = (TextView)itemLayoutView.findViewById(R.id.title);
           // trailer = (VideoView)itemLayoutView.findViewById(R.id.trailer);
            trailer =(WebView) itemLayoutView.findViewById(R.id.trailer);
            trailer.getSettings().setJavaScriptEnabled(true);
            trailer.setWebViewClient(new WebViewClient());
            desc = (TextView)itemLayoutView.findViewById(R.id.desc);
        }

    }
}
