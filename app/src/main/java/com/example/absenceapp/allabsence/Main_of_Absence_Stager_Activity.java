package com.example.absenceapp.allabsence;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.absenceapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class Main_of_Absence_Stager_Activity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ViewPageAdaptere myViewPagerAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_of_absence_stager);

        tabLayout = findViewById(R.id.table_layout);
        viewPager2 = findViewById(R.id.view_page);
        myViewPagerAdapter = new ViewPageAdaptere(getSupportFragmentManager(),getLifecycle());
        viewPager2.setAdapter(myViewPagerAdapter);

        // Set up tab layout with view pager
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });
    }
}
