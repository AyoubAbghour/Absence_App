package com.example.absenceapp.allabsence;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdaptere extends FragmentStateAdapter{


    public ViewPageAdaptere(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0 :
                return new Fragment_16_18();
            case 1:
                return new Fragment_13_16();
            case 2:
                return new Fragment_11_13();
            default:
                return new Fragment_8_11();
        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }
}
