package com.example.convertertabsjava;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    public PagerAdapter(@NonNull FragmentActivity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new TemperatureFragment();
            case 1: return new DistanceFragment();
            default: throw new IllegalStateException("Position invalide : " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}