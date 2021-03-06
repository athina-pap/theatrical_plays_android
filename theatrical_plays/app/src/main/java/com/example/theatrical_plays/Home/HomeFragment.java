package com.example.theatrical_plays.Home;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.theatrical_plays.Actor.Activity_bio;
import com.example.theatrical_plays.MainActivity;
import com.example.theatrical_plays.ProductionInfo;
import com.example.theatrical_plays.R;
import com.example.theatrical_plays.Venues.TheatersInfo;
import com.squareup.picasso.Picasso;
public class HomeFragment extends Fragment {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    TextView actorn;
    TextView actor2;
    TextView actor3;
    Button moreactors;

    public static HomeFragment newInstance()
    {
        HomeFragment fragmentHome = new HomeFragment();
        return fragmentHome;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        image1 = rootView.findViewById(R.id.image1);
        Picasso.get().load("https://image.tmdb.org/t/p/w300/nv5TR9NiELEGPJUQqVLEqZzcGZb.jpg").into(image1);
        image2 = rootView.findViewById(R.id.image2);
        Picasso.get().load("https://image.tmdb.org/t/p/w300/mR3QlGx3y68uVZriNzoOLOnwPy.jpg").into(image2);
        image3 = rootView.findViewById(R.id.image3);
        Picasso.get().load("https://image.tmdb.org/t/p/w300/oiectxNJB7ctBwRKY45ChonEbjw.jpg").into(image3);
        moreactors = rootView.findViewById(R.id.moreActors);
        actorn = rootView.findViewById(R.id.actorN);
        actor2 = rootView.findViewById(R.id.actor2);
        actor3 = rootView.findViewById(R.id.actor3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), Activity_bio.class);
                int_detail.putExtra("id",6911);
                int_detail.putExtra("fullName", actorn.getText());
                getActivity().startActivity(int_detail);
            }
        });


        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), Activity_bio.class);
                int_detail.putExtra("id",5044);
                int_detail.putExtra("fullName", actor2.getText());
                getActivity().startActivity(int_detail);
            }
        });


        image3.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent int_detail = new Intent(getContext(), Activity_bio.class);
                                          int_detail.putExtra("id", 7544);
                                          int_detail.putExtra("fullName", actor3.getText());
                                          getActivity().startActivity(int_detail);
                                      }
                                  });


       moreactors.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent int_detail = new Intent(getContext(), MainActivity.class);
               int_detail.putExtra("prod", 1);
               getActivity().startActivity(int_detail);
           }
       });

        ImageView prod1 = rootView.findViewById(R.id.imageprod1);
        ImageView prod2 = rootView.findViewById(R.id.imageprod2);
        ImageView prod3 = rootView.findViewById(R.id.imageprod3);

        prod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), ProductionInfo.class);
                int_detail.putExtra("desc", "???? ???????????????? ??????????????????, ???? ?????????? ????????????????????, ?????? ???????????? ???????????????????????? ?????? ???????????? ?????????? ???? ?????? ?????????????????? ??????????????????????????, ?????? ?????????????????????? ?? ?????????????? ????????????????????????, ?? ?????????????? ???????????? ?????? ?? ?????????? ??????????????????????.\\n \\n?????????????? 30/1 ?????? ?????????????? 31/1/2021 & extra ?????????????????? ???????? ?????????????? ?????????????? ?????????????? 1/2\\n?? ?????????????????? ?????? ??????????????, ???? ???????? ?????? 8?? ?????????????????????? ?????? 150.000 ????????????!!!\\n17 ???????????????? ????????????????, 37 ?????????????????? ???? 12???????? ?????????????? ????????????????, 24?????????? ?????????????? & 1.000 ?????????????????? ?????? ???????????? ?????? 300 ????????????????!\\n \\n???????????? ?????? ?????? ???????????????? ??????????????, ???????????????? ???????????? ???????? ?????? ??????????????, ???? ?????????????????? ?????? 2019, ?? ????????-????????????????, ??????? ???????? ?????? ???????????????, ???? ???????????????? ?????????????????? ???? ?????? ???????????????? ?????? ?????????????????????? ?????????????? ?????? ?????????????? ?????????????????? ???????????? ???????????????????????? ?????? ???????????? ?????????? ?????? ?????? ?????????????????????? ?????????????????????? ?????? ???????? ??????????????????????, ??????????????, ?????? ?????????? ????????, ???????? online streaming*, ?????? ???? ???????????????? ???????????? ??????????, ???????? ???????????? ??????!\\n?? ???????????????????????????? ??????????????????, ?????? ?????????? ??????????, ???????????????????? - ?????????????????????? ???????? ???? ???????? - ?????? ???? ????????????, ?????? ?????? ?????????? ?????? ?????????????? ??????, ?????? ???????????? ?????? ???????????? ?????????????????? ????????????????????????????, ???????? ?????? ???? studio ?????? ?????????? ????????!\\n?? ???????????? ????????????????????????, ?? ???????????????? ??????????, ?? ???????????? ????????????????, ?? ???????????? ????????????, ?? ???????????????? ??????????, ?? ?????????? ??????????????, ?? ?????????????? ??????????????????, ?? ???????????? ??????????????????, ?? ?????????????? ??????????????????, ?? ?????????????? ????????????, ?? ?????????????? ????????????????????, ?? ?????????????????? ????????????, ?? ?????????????? ????????????????, ?? ?????????????? ????????????, ?? ???????????????? ?????????????? ?????? ???? ?????????????????????? ???????????? ?? ???????????????? ????????????????, ?? ?????????? ?????????????????????? ?????? ?? ?????????????? ???????????????????????? ?????????? ?????????????? ???? ???????????? ???????? ???????????????? ?????? ???????????? ??????, ???????? 30 & 31/1/2021, ?????? ?????? ???????????? ?????????? ?????? ?????? ???????????????????????? ?????????????? ?????????????? ?????? ????????????.\\n?????????????????????? ??????????????????, ?????????????? ??????????????????, ?????????? ?????? 1.000 ??????????????????, ???????? ???? ?????? ???????????????????? ??????????????, ???? ???????????? ?????????????????? ?????????????????? ???????? ?????? ?????? ???????? ???????????????????? ??????????????????????, ???????????? ???? ???????????? ?????? ????????????????????.\\n??????? ???????? ?????? ???????????????, ?????????? ?? ?????????????? ?????????????? ?????????????????????? ?????? ???????????????? ?????????????? ???? 1955 ???????? ?????? ?????????????? ?? ???????????? ???????????? ?????? ????????????????????????????, ???????? ?????? ???????????? ???????? ?????? ?????????????????? ?????? '60 ?????? ???????????????????? ?????? ?????????? ?????? ???????????? ?????? ???????????????? ?????? '70.\\n???? ??????????????????, ??????????????, ?????????????????????? ???????? ?????? ?????????????????? ?????? ???????????????? ?????? ?????????? ?????? ???????????? ???????????????? ?????? ?????????????????????? ???? ??????????????. ??????? ???????? ?????? ??????????????? ?????????? ?????? ???????????? ?????? ?????????? ?????????? ?????? ???????????? ?????????? ?????????????????? ????????????????????????????.\\n??????? ???????? ?????? ???????????????, ???? ???????????????????? ?????? ?????????????????? ??????????????????, ?????????????? ?????????????????? ?????? ?????????? ?????????????? ???????? ???????? ?????? ???? ?????????? ??????, ?????????????????????????? ???? ???????????? ?????? ?????????????? ????????????, ?????? ?????????? ?????? ?????? ???????????????? ?????? ?????????????????? ???????????????????????????? ???????? ?????? ?????? ???????? ?????????????? ?????????????????????????? ?????? ????????????????????????????.\\n?????? ???????????????? ?????? MK GROUP, ?????? ???????? ?????????????????? ?????? ?????????????? ????????????????.\\n*H ?????????????????????????????? ???????? ?????????? ???? ?????? ???????????????????? ?????? ?????????????? ???????????? ?????????????????? ???? ?????????????? full hd ?????? ???? ?????? ???????????? ?????? ?????? ????????????????????, ?????????????????????????? ?????? ???????????????? ???????????? at-home ?????? ????????????, tablets,  ?????????????????????? ?????? smart TV.\\n \\nINFO:\\nONLINE STREAMING - ???????????? ??????????\\n????????????????????: ?????????????? 30/1 & ?????????????? 31/1/21\\n???????????????? ????????????????????: 2???????? ????????\\n???????? ????????????????????: 15 ??? \\n \\n???????? ?????????? ?????? ???? ???????? ???\\nO ???????????? (???????????? ????????????????????????) ?????????? ?????????????????????????? ?????? ?????????????? ?????? ?????????? ?????? ???????????? ?????? ?????????????? ?????? ???????????????? ?????? ???50. ?????????? ?????????????????????? ???? ?????? ?????????????? (???????????????? ??????????) ?? ?????????? ?????????? ???????? ?????? ?????????????? ?????? ???????????????????? ???? ???????????? ???????? ?????????? ?????? ?????????????? ?????????????? ?????? ???? ???????????? ??????????????. ?? ??????????????  ???????? ?????? ???????? ?????? ?????? ?????????????????????? ???????? ??????, ?????? ?????????? (?????????????? ????????????).\\n?? ?????????? (???????????????? ??????????) ?????????? ?????? ???????????????????? ?????????????????????????? ?????? ???????? ???????????????? ?????? '50 ?????????? ???????????? ???? ?????????????? ?????? ?????????? ??????, ?????????????? (???????????? ????????????) ?????? ?????????? ?????????????????????????? ?????? ????????????????????.\\n???????? ?? ???????????? ?????? ?? ?????????? ?????????????????????????? ?????? ?????????? ???????? ???? ?????? ???????????? ?????? ?????????????? ?????????????? ?????? ?????????????? ???? ????????????, ??????????????????????????, ???????????????????? ?????? ????????????????????.\\n?? ?????????????? ???????? ?????????????? ?????????? ???? ??77 ?????? ???????????? ?????? ???????????????? ?? ???????????????????????? ?????????? ?????? ???????? ?????????? ?????????? ?? ?????????????? ?????? ???????????? ?????????????????? ????????????????????????????. ???????? ?????? ???????? ???? ?????????????? ?????????????? ?????????????????????????? ???????? ?????????????????? ???????????? ?????? ?????????????????????? ?????? ???????? ?????? ???????????????????? ?????? ???????????????? ?????? ?????????? ????????.\\n?? ???????????? (???????????? ????????????????) ?????????? ?? ???????????????????? ?????? ?????????????????? ?????? ????????????.\\n?? ???????????????????? (?????????? ??????????????????????) ?????????? ?? ???????????? ?????? ????????????.\\n?? ???????????? (?????????????? ????????????????????????) ?????? ?? ?????????? (???????????????? ????????????????) ?????????? ?????????????? ???????????? ???????????????? ?????? ???? ???????????????????? ?????? ?????????? ?????? ?????????? ?????? ?????????? ?????? ?????? ?????????? (?????????????? ??????????????????), ?????? ???????????????? ?????? ???????????????? ?????? ??????????.\\n?? ???????????????? (?????????? ??????????????) ?????????? ?????????????????????? ?????? ???????????? ?????????????? ?????? ????????????, ???????? ?????? ?? ???????????? (?????????????? ??????????????????) ?? ???????????? ?????????? ?????????????????????? ???? ?????? ?????????????? ?????? ???????? (???????????? ??????????????????).\\n?????? ?????? ?????????????????????? ?????????????????????? ?????????????????? ???? ???????????????????? ?????????????? ?? ????????????????. ?????????? ???? ?????????????????????? ???????????? ?????????????? ???????? ???????????? ?????? ???????????? ???????????????? ?????? ???????????????????? ?????? ?????? ???????????????????? ?????? ?????? ???????? ?????? ?????? ???????????? ?????? ?????? ?????????????????? ???? ???????????????? ??????????????????, ?????????????? ?????????????????? ?????? ???????????? ???? ???????? ???????????????????????????? ?????? ???????????????????????? ?????? ???????? ?????????????????? ?????? ?????? ???? 12???????? ?????????????? ????????????????. ???????????????????? 24?????????? ??????????????.\\n \\n???????????????????????? ????????!");
                int_detail.putExtra("id",509);
                int_detail.putExtra("title", "???? ???????? ?????? ????????????");
                int_detail.putExtra("producer", "?????????? ???????????? ?????? ?????????? ??.??.??");
                int_detail.putExtra("url", "https://www.viva.gr/tickets/getattachment/d8b548e8-490c-488f-9939-afd8ed7e821c/%ce%a4%ce%9f-%ce%94%ce%99%ce%9a%ce%9f-%ce%9c%ce%91%ce%a3-%ce%a3%ce%99%ce%9d%ce%95%ce%9c%ce%91---Online-Streaminfc370b491-a9e4.png");
                getActivity().startActivity(int_detail);
            }
        });


        prod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), ProductionInfo.class);
                int_detail.putExtra("desc", "?? ???????????? ???????????????? ?????????????? ?????? CHRISTMAS THEATER!\\n???? ?????????? ?????? ????????????\\n40.000 ???????????? ?????????????????? ?????? ???????????? ???????????????? ???????? ???????????? ??????????????????????! ?? ???????????????? ?????????????????????? ?????? Christmas Theater! ?????????? ???? ???????? ???????? ?????????????????????? ?????????? ?????? ??????????????!\\n?????????????????????? 211 7701700 www.ct.gr\\nCHRISTMAS THEATER \\n???????? ?????? ???????????? ???????????????? ???????? ?????????????????????? ?????????? ?????? 30 ????????????????!!\\n?????? ???????????? ?????????????????????? ?????????????????? ?????????????????????? ?????????? ?????? ???????????????????? ???????????? ?????? ????????????. ?? ?????????????????? ???????????? ?????? ?????????????? ???????????? ????????????????, ?? ???????????????? ?????????????????? ?????? ???? ???????????????????? ???????? ???????????????? ?????? Christmas Theater ?????? ???? ?????? ???????????????????????? ?????? ?????????????????? ???? ?????????? ?????? ????????????. ?? ???????????? ???????????????? ?????? ?? ???????????????? ?????????????????? ???? ?????? ?????? ?????????????????????? ?????????? ???????? ?????? ???? ?????????????????????? ??????????????, ?????????????????? ?????? ???????????? ?????? ?????? ????????????????????????????, ???????????????????? ?????? ?????????????? ???????????????????????? ?????????????????????? ?????? Christmas Theater ?????? ???????????????????????? ?????? ?????? ?????? ???????? ???????????? ?????? ???????????? ???? ?????? ???????????????? ?????????????????? ?????? ?????? ?????? ????????????????????. \\n?????? ?????????????????? ?????? ?????? ???????????? ?????? ??????????????, ?????????? ???????? ???????????? ?????? ???? ?????????????? ??????????????: ?????? ?????????????? ???????????? ?????????????? ??????? ?????????? ?????? ???? ??????????????????????.\\n?????????????????????? ?????????? ?? ???????????????????????? ?????? ???????? ?????????????????? ??????????????. ?????????????????? ???????? ???? ?????? ???????? ?????????????? ?????? ?????? ???????? ?????? ???? ?????? ?????? ???????? ???????? ???? ???????????? ???? ?????????????????????? ?????? ???????? ???????????? ?????? ????????????, ?????? ???????? ?????? ??????????, ?????? ???? ???????? ???????????? ?????? ???????????? ???????? ?????????????? ???? ?? ?????? ?????????????????? ?????? ???????????????? ?????????? ?????? ????????????????????????. ???????? ??????? ???????? ?????? ?????????????????? ???? ???????????? ???? ?????????? ?????? ???????????????? ???? ??????????????????????????????:\\n- ???? ?????????????? ?????? ????????\\n- ???? ?????? ??????\\n- ???????? ???????????? ??????\\n- ?????? ?????????????????? ?????? ???????????????????? ????????????\\n- ???? ???????????? ??????\\n- ?????? ?????????? ???? ???????????????? ?????? ???????? ???????????? ???????? ???? ?????????????????????? ???????? ?????? ?????????? ?????? ???? ?????????? ?????????????? ?????????? ???????????? ?????????? ???????? ???? ????????????.\\n???? ???????????????? ?????????????? ?????? ?????????????????? ?????????????????? ?? ???????????????? ??????????????????. ???? ?????????????? ?????? ???? ???????????????????? ?????????????????? ?? ???????????? ????????????????, ???? ???? ???????????????? ?????? ?????????????? ???? ?????????????? ?????? ???????????? ???????? ?????????????? ?????? ?????????? ?????? ???? ????????????. ?????????? ?????? ???????????? ???? ?????????????????????????? ???????? ?????????? ?????? ???? ?????? ?????????? ?????? ???????? ???????????? ???????? ?????????? ????????????!\\n?????????????? ??? ????????????????????: ???????????? ????????????????\\n?????????????? ??? ??????????????????:     ???????????????? ??????????????????\\n?????????????????????? ??? ???????????? ??? ????????????????: ???????????? ??????????????\\n?????????????? ??? Video Art : ?????????????? ????????????????????\\n???????????? ????????????????????: ?????????????? ????????????????????\\n???????????????????? ??? ???????????????????? ????????????????????: ?????????? ????????????????????\\n????????????????????????:  ???????????????????????? ?????????????????????? \\n???????????? ?????????????????? ??? ???????????????????????? ????????????????????: ?????????? ??????????????\\n \\n \\n????????????????:\\n?????????????? ????????????????\\n?????????????? ??????????????????????\\n?????????????? ??????????\\n???????? ??????????????????????????????\\n???????????? ????????????????????\\n?????????? ??????????????????\\n???????????? ??????????????????????\\n?????????????? ??????????????\\n???????????? ????????????????\\n?????????? ????????????????\\n?????????????????????? ??????????????????????\\n???????????????? ??????????????????\\n \\n???? ?????????? ?????? ???????????? ?????? ???????????? ????????????????\\n?????? ???? ?????????????? 9 ?????????????????? 2021\\nCHRISTMAS THEATER\\n???????????? 137, ??????????????\\n???????? ??????????????????????:\\n?????????? 4 ???????????????????? ???????? 15 ?????? ???????? 19.30\\n???????????? 6 ???????????????????? ???????? 15.00 ?????? ???????? 19.30\\n?????????????? 16 ???????????????? ???????? 15.00 ?????? ???????? 19.30\\n?????????????? 17 ???????????????? ???????? 12.00 ?????? ???????? 17.00\\n?????????????? 30 ???????????????? ???????? 15.00 ?????? ???????? 19.30\\n \\n?????????? ????????????????????:\\n?????????????? ?????? ?????????????? (???????????????? ??????????????????)\\nVIP: 24 ????????\\n?? ????????: 20 ????????\\n?? ????????: 16 ????????\\n?????????????? (?????????????????? ????????????????)\\n?? ????????: 13 ????????\\n?? ????????: 10 ????????\\n?? ????????: 5 ????????\\n????????: 5 ????????, ??????????????: 10 ???????? (???????? ???? ???????????????????? ?????????????? ?????? 211 7701700 ?? ?????? ???????????? ?????? CHRISTMAS THEATER)\\n?????????????? ?????????????? ?????????? ?????? ?????????????? ??????????????????, ?????????????????????? 211 77 01 700\\n \\n");
                int_detail.putExtra("id",506);
                int_detail.putExtra("title", "???? ?????????? ?????? ????????????");
                int_detail.putExtra("producer", "WE PRODUCTION ?????????????? ?????????????????? ?????? ?????? ????");
                int_detail.putExtra("url", "https://www.viva.gr/tickets/getattachment/4e365d06-7ac9-405e-b9d6-7b9b58ef1546/%ce%9f%ce%99-%ce%91%ce%98%ce%9b%ce%9f%ce%99-%ce%a4%ce%9f%ce%a5-%ce%97%ce%a1%ce%91%ce%9a%ce%9b%ce%97-%cf%84%ce%b7%cf%82-%ce%9a%ce%b1%cf%81%ce%bc%ce%b5%ce%bd-%ce%a1%ce%bf%cf%85%ce%b3%ce%b3%ce%b5%cf%81%ce%b7b91bdad8-83.png");
                getActivity().startActivity(int_detail);
            }
        });


        prod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), ProductionInfo.class);
                int_detail.putExtra("desc", "???? ????????????????????????????\\n?????? ???????????? ???????????? ???? ???????????????????? ???????????? ????????????\\r\\n \\n?? HAPPY PRODUCTIONS ?????????????????????? ???????? ?????? ??????????????, ???? ?????? ???????????? ???????????????? ???? 8 ?????????????????????? ?????????????????????????? ?????? ?????????????? ??????, ???? ?????????????? ???????? ?????????????????? ?????? ???????????? ???????????? ??????????????O??????????????, ???? ???????????????????????? ???????? ???????? ?????????????? ?????? ???????????????????? ?????????????? (???????????????? ?????????????? ?????? West End ?????? ??o 1952 ?????? ????????????), ???? ?????? ?????? ???????????????????? \\\"??????????????\\\"!\\nH ?????????????????? ???????????????????? ?????????? ??????????????????, ???????? ???? ????????????, ?????? ?????????????? ?????? ???? ???????????????? ???? ?????????????? ?????? ?????????? ?????? ???????? ?????? 8 ??????????????????. ???????? ?? ?????????????? ???? ????????????????, ?????????????? ?????? ???????????????????????? ???????????????? ?????? ?????????? ?????? ?????????????? ?????? ?????????????? ???????????? ?????? ?????????????? ?????? ?????????? ???????? ?????????? ??????????????????.\\n?? ???????????? ?????? ????????????, ???? 1947, ???????? ??????????????????????, ?????????????????? ?????? ??????????????????????, ????????, ?????????????? ?????? ???????????? ???????????? ???? ?????????? \\\"???????? ?????????? ????????????????\\\". ?????? ?????????? \\\"??????????????????????????\\\" ?????? ?????????????????????? ?????? ???? ???????????????? ???????? ?????? ???????????? ?? ?????????? ?????? ?????????????? ???????? ?????? ?????????????? ?????? ???? ???????????????? ?????? ?????????? ?????? ?????????????? ?????? ?????? ?????????????? ??????. ????????????, ????????????, ?????? ???????????? ???????? ?????? ????????????, ?????????????????????? ?????? ???????????????????????? ??????????????????????, ?????????????????????? ???? ?????????????????? ???????? ?????????????? ?????? ???? ?????????? ?????? ?????? ?????? ??????????????. ???? ???????? ?? ???????????????? ?????? ???????????? ?????? ?????????? ?????????????? ????????????...\\n???????? ?????????? ?????? ?????? ?????????????? ?????? ??????????:\\n?? ?????????????? ?????? ?????????? ???????????????????????? ???? ?????? ?????????????????????? ?????????????? ???????? ????????????????, ?????? ?????? ?????? ???? ?????????? ???????????? ??????????. ???????? ??????????, ?????? ???????? ???????? ?????????????? ?????? ??????????????, ???????????????????? ?????????????????????? ???? ?????????????? ???????????????? ?????? ???????????????????? ????????????.\\n?? ?????????? ???????? ???????????????? ?????? ???????? ?????????????????? ?????????????????? ?????????????? ????????. ?????? ?????????????? ?????????????????? ???? ???????????????????????????? ??????????????????, ???????????? ???????????????????? ?????? ?????? ?????????????????????????? ?????? ?????????????????? ???? ?????????????? ???????? ??????!\\n?????? ?????? ???????????????????? ?????? ??????????, ???? ???????????????????? ?????? ?????????????????????????? ?????????????????????? ???????????? ????????????, ?????? ?????????? ???????? ?????????????????????????? (?????????? ??????????????????????, ?????????????? ????????????, ?????????? ??????????????, ?????????? ??????????????????????, ?????????? ????????????????????, ?????????? ??????????????????????, ?????????????? ??????????????????????, ?????????????????? ????????????????), ?????????????????????? ?????????? ???????? ?????????? ?????? ?????????????????? ?????? '90, ???????????? ?????????? ???? ???????????? ???????????????? ???????? ???????? ??????, ???? ?????? ?????????????? ?????? ?????????????????? ????????????????.\\n???.?? ???????????????? ?????? ???????????? ???????? ?????? ??????????????!\\n???.?????? ???????????????????????????? ?????? ???????????????????? ???? ?????????? ???? ????????????!\\n????????????????: Happy Productions Hellas\\n???????? ????????????????: ?????????????????? & ?????????????????????? 17, ?????????? ????????????????????????\\n???????????????? ????????????????????????: 210 3625119 & 210 0080900\\n??????????????????????:\\n\\n?????????????? 20:00\\n?????????? 21:00\\n?????????????? 18:00\\n?????????????? 21:00\\n?????????????? 18:00\\n\\n???????????????? ????????????????????: 1 ?????? ?????? 35 ??????????\\n?????????? ????????????????????:\\n\\n??????????????-??????????????: ???????? ??: 20??? / ???????? ??: 18??? / ???????? ??: 15???\\n??????????: ???????????? ?????????????? 15???\\n??????????????-??????????????: ???????? ??: 22??? / ???????? ??: 20??? / ???????? ??: 15???\\n\\n??????????????, ????????????????????, ????????, ?????????????? ????????, 65 ????????, ????????????????: 15??? (?????????? ????????????????/????????????????)\\n?????????????? ?????????? ?????? ???????????????? ?????????????????? ?????? ?????? 15 ???????????? (?????? ???????????????? 210 0080900)\\n?? ???????? ????????????????, ???????????? ???????????????????????????? (2019), ???????????????? ?????????????????????????? ?????????????? ????????????????????, ?????????? ?????? ?????????????????? ???? ???????????? ?????????? ???????? ?????????? ???????????? ?????? ??????????????. ?????????????????? ?????????? ?????????????? ?????? ???? ???????????????????? ???????????????????????? ????????????????????, ???? ?????????????? ?????? ?????????????????? ???????????? & ????????????????????.\\n?????????????????? ????????????????????:\\n??. ??????????????????????:\\n\\nwww.viva.gr\\nneosakadimos.gr\\n\\n??. ????????????????????:\\n\\n210 0080900: ?????????????? ?????? ?????????????????? 09:00-19:00 & ?????????????? 09:00-17:00\\n210 3625119: ?????????????? ?????? ?????????????? 10:00-21:00\\n\\n??. ?????? ???????????? ?????? ???????? ????????????????: ?????????????????? & ?????????????????????? 17 (?????????????? ?????? ?????????????? 14:00-22:00)\\n??. ?????? ?????????????? ?????? Happy Productions: ?????????????????? 326, ???????? ?????????????????? (?????????????? ?????? ?????????????????? 09:00-19:00 & ?????????????? 09:00-17:00)\\n??. ?????? ???????????? ???????????????????????? VIVA (www.vivapayments.com/el-gr/network)\\nemail: info@happyproductions.gr\\nWeb: www.neosakadimos.gr\\nFacebook 1: www.facebook.com/neosakadimos\\nFacebook 2: www.facebook.com/pontikopagida\\nInstagram 1: www.instagram.com/neosakadimos\\nInstagram 2: www.instagram.com/pontikopagida_2020\\nYou Tube: www.youtube.com/channel/UCt3LXDqOhYhrrxUhu-T01qg\\n#neosakadimos #pontikopagida");
                int_detail.putExtra("id",507);
                int_detail.putExtra("title", "??????????????????????????");
                int_detail.putExtra("producer", "Happy Productions IKE");
                int_detail.putExtra("url", "https://www.viva.gr/tickets/getattachment/74515bee-24f3-4145-b283-08311e71b95c/%ce%a0%ce%bf%ce%bd%cf%84%ce%b9%ce%ba%ce%bf%cf%80%ce%b1%ce%b3%ce%b9%ce%b4%ce%b14ca3d290-df96-42f4-81b3-cd17191138e8.png");
                getActivity().startActivity(int_detail);
            }
        });

        Button moreProductions = rootView.findViewById(R.id.moreProductions);
        moreProductions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), MainActivity.class);
                int_detail.putExtra("prod", 2);
                getActivity().startActivity(int_detail);
            }
        });


        ImageView venue1 = rootView.findViewById(R.id.imageVenue1);
        ImageView venue2 = rootView.findViewById(R.id.imageVenue2);
        ImageView venue3 = rootView.findViewById(R.id.imageVenue3);

        venue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), TheatersInfo.class);
                int_detail.putExtra("id", 302);
                int_detail.putExtra("title","???????? ????????????????");
                int_detail.putExtra("address", "Athens, ????????????");
                getActivity().startActivity(int_detail);
            }
        });


        venue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), TheatersInfo.class);
                int_detail.putExtra("id", 303);
                int_detail.putExtra("title","???????????? ?????????? ????????");
                int_detail.putExtra("address", "????????????????, ????????????");
                getActivity().startActivity(int_detail);
            }
        });


        venue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), TheatersInfo.class);
                int_detail.putExtra("id", 305);
                int_detail.putExtra("title","???????????????? ????????????");
                int_detail.putExtra("address", "????????????????????, ????????????");
                getActivity().startActivity(int_detail);
            }
        });

        Button moreVenues = rootView.findViewById(R.id.moreVenues);
        moreVenues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), MainActivity.class);
                int_detail.putExtra("prod", 3);
                getActivity().startActivity(int_detail);
            }
        });
        return rootView;
    }
}