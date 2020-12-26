package com.example.pcs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.pcs.helperclass.featuredAdpater;
import com.example.pcs.helperclass.featuredhelperclass;
import com.example.pcs.helperclass.mostview;
import com.example.pcs.helperclass.mostviewAdpter;

import java.util.ArrayList;

public class userdashboard extends AppCompatActivity {
     RecyclerView featuredRecycler,mostviewRecycler;
     RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userdashboard);
        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostviewRecycler = findViewById(R.id.mostview_Recycle);

        mostviewRecycler();
        featuredRecycler();
    }

    private void mostviewRecycler() {
        mostviewRecycler.setHasFixedSize(true);
        mostviewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<mostview> mostviewsLocation = new ArrayList<>();
        mostviewsLocation.add(new mostview(R.drawable.banner1));
        mostviewsLocation.add(new mostview(R.drawable.banner42));
        mostviewsLocation.add(new mostview(R.drawable.baner));

        adapter = new mostviewAdpter(mostviewsLocation);
        mostviewRecycler.setAdapter(adapter);

    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<featuredhelperclass> featuredLocation = new ArrayList<>();


        featuredLocation.add(new featuredhelperclass(R.drawable.termite,"Termite","We provide the best termite solution to kill termite"));
        featuredLocation.add(new featuredhelperclass(R.drawable.lizardicon,"Lizard","We provide the best Lizard solution to kill rdf"));
        featuredLocation.add(new featuredhelperclass(R.drawable.rdf,"rdf","We provide the best rdf solution to kill rdff"));
        featuredLocation.add(new featuredhelperclass(R.drawable.gold,"gold","We provide the best gold solution to kill gold"));
        featuredLocation.add(new featuredhelperclass(R.drawable.redntwed,"redntwed","We provide the best redntwed solution to kill redntwed"));

        adapter = new featuredAdpater(featuredLocation);
        featuredRecycler.setAdapter(adapter);




    }
}