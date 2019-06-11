package com.conformidade.petrobras.apco.categoria;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.conformidade.petrobras.apco.R;
import com.conformidade.petrobras.apco.helper.CustomTabLayout;

public class CategoriaActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private CustomTabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);

        //Configura Toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Categorias");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);

        //Configura Menu / TabLayout
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Menu 4"));

        //final ViewPager viewPager = findViewById(R.id.viewPager);
        //final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        //viewPager.setAdapter(adapter);
        //viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new CustomTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(CustomTabLayout.Tab tab) {
                //int totalTabs = tabLayout.getTabCount();
            }

            @Override
            public void onTabUnselected(CustomTabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(CustomTabLayout.Tab tab) {

            }
        });
    }
}
