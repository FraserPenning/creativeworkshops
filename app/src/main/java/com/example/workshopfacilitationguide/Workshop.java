package com.example.workshopfacilitationguide;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.workshopfacilitationguide.ui.main.SectionsPagerAdapter;

public class Workshop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        Toolbar toolbar = findViewById(R.id.backToolBar);
        setSupportActionBar(toolbar);

        //Parcelable dat from ExampleItem
        Intent intent = getIntent();
        ExampleItem exampleItem = intent.getParcelableExtra("Example_Item");
//        int imageRes = exampleItem.getImageResource();
        String Text1 = exampleItem.getText1();
//        String Text2 = exampleItem.getText2();
        String Text3 = exampleItem.getText3();

//        ImageView imageView = findViewById(R.id.imageView);
        TextView workshoptitle = findViewById(R.id.workshoptitle);
        workshoptitle.setText(Text1);
        TextView timing = findViewById(R.id.timing);
        timing.setText(Text3);


        Drawable drawable= ResourcesCompat.getDrawable(this.getResources(), R.drawable.ic_arrow, null);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(drawable);
        actionBar.setTitle("Techniques");
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}