package com.example.pcs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.pcs.helperclass.featuredAdpater;
import com.example.pcs.helperclass.featuredhelperclass;
import com.example.pcs.helperclass.mostview;
import com.example.pcs.helperclass.mostviewAdpter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class userdashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // variable
    static final float END_SCALE=0.7f;
    RecyclerView featuredRecycler,mostviewRecycler;
    RecyclerView.Adapter adapter;
     ImageView meunIcon;
     LinearLayout contentView;

     //draer Menu
  DrawerLayout drawerLayout;
  NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_userdashboard);
        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostviewRecycler = findViewById(R.id.mostview_Recycle);
        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nagvat_view);
        meunIcon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);



       naviagtionDrawer();


        mostviewRecycler();
        featuredRecycler();
    }

    private void naviagtionDrawer() {

        // NAVIAGTION ITEAM
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);
        navigationView.setCheckedItem(R.id.nav_home);

        meunIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        animateNaviagtionDrawer();
    }

    private void animateNaviagtionDrawer() {
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }


     

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return true;
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