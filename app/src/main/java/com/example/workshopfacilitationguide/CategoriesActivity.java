package com.example.workshopfacilitationguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;

import java.util.Objects;

public class CategoriesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private CardView workshop101;
    private CardView agile;
    private CardView innovationanddesign;
    private CardView unconference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        //Navigation Drawer hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolBar);

        //Toolbar set as action bar
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Workshop Themes");
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //navigation clickable
        navigationView.setNavigationItemSelectedListener(this);
        //Set home screen information on start
        navigationView.setCheckedItem(R.id.nav_categories);

        workshop101 = findViewById(R.id.workshop101);
        agile = findViewById(R.id.agile);
        innovationanddesign = findViewById(R.id.innovation_design);
        unconference = findViewById(R.id.unconference);

        workshop101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Workshop101.class);
                startActivity(intent);
            }
        });



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_categories:
                break;
            case R.id.nav_information:
                Intent intent = new Intent(CategoriesActivity.this, Information3.class);
                startActivity(intent);
                break;
            case R.id.nav_lists:
                intent = new Intent(CategoriesActivity.this, ListsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_settings:
                intent = new Intent(CategoriesActivity.this, Settings.class);
                startActivity(intent);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
