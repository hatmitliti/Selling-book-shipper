package com.example.book.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.book.Screen.HomePageActivity;
import com.example.book.Screen.ProfileActivity;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomePageActivity();
            case 1:
                return new ProfileActivity();
            default:
                return new HomePageActivity();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
