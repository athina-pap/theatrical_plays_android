package com.example.theatrical_plays.Home;

import android.content.Context;
import android.net.Uri;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.theatrical_plays.R;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AdapterTrailer extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final List<Object> recyclerViewItems;
    private final Context mContext;
    ConstraintLayout expandedView;
    Button arrow;
    CardView cardView;

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
       menuItemHolder.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (menuItemHolder.expandedView.getVisibility() == v.GONE)
                {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    menuItemHolder.expandedView.setVisibility(v.VISIBLE);
                    menuItemHolder.arrow.setBackgroundResource(R.drawable.ic_arrow_up);
                }else
                {
                    TransitionManager.beginDelayedTransition(cardView, new AutoTransition());
                    menuItemHolder.expandedView.setVisibility(v.GONE);
                    menuItemHolder.arrow.setBackgroundResource(R.drawable.ic_arrow_down);
                }
            }
        });




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
        public Button arrow;
        ConstraintLayout expandedView;

        public MenuItemViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            prod = (TextView)itemLayoutView.findViewById(R.id.prod);
            title = (TextView)itemLayoutView.findViewById(R.id.title);
           // trailer = (VideoView)itemLayoutView.findViewById(R.id.trailer);
            trailer =(WebView) itemLayoutView.findViewById(R.id.trailer);
            trailer.getSettings().setJavaScriptEnabled(true);
            trailer.setWebViewClient(new WebViewClient());
            desc = (TextView)itemLayoutView.findViewById(R.id.desc);
            expandedView = (ConstraintLayout) itemLayoutView.findViewById(R.id.expandedView);
            arrow = (Button) itemLayoutView.findViewById(R.id.arrowBtn);
            cardView = (CardView)itemLayoutView.findViewById(R.id.cardView);

        }

    }
}
