package com.example.admin.exam.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Fragment> mFragments;
    private final ArrayList<String> mTitle;

    public MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> title) {
        super(fm);
        mFragments = fragments;
        mTitle = title;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
