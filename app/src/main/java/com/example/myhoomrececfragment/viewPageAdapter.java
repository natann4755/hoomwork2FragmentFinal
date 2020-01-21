package com.example.myhoomrececfragment;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class viewPageAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentsList;

    public viewPageAdapter(FragmentManager fm, List<Fragment> myList) {
        super(fm);
        fragmentsList=myList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
