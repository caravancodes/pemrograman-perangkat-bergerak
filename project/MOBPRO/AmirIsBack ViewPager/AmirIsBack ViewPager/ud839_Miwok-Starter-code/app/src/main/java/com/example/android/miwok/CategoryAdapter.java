package com.example.android.miwok;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Praktikan on 15/03/2018.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context context;


    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new NumberFragment();
            case 1 :
                return new FamilyFragment();
            case 2 :
                return new ColorFragment();
            case 3 :
                return new PhrasesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return context.getString(R.string.category_numbers);
            case 1 :
                return context.getString(R.string.category_family);
            case 2 :
                return context.getString(R.string.category_colors);
            case 3 :
                return context.getString(R.string.category_phrases);
            default:
                return null;
        }

    }



}
