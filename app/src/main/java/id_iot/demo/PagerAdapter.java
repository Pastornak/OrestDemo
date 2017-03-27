package id_iot.demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter{
    private int mNumOfTabs;
    private final int COLLECTION_SCREEN = 0;
    private final int CHOSEN_RECIPES = 1;
    private final int FAVOURITE_RECIPES = 2;
    private final int CHOSEN_PRODUCTS = 3;

    public PagerAdapter(FragmentManager fragmentManager, int NumOfTabs) {
        super(fragmentManager);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case COLLECTION_SCREEN:
                return new CollectionFragment();
            case CHOSEN_RECIPES:
                return new Fragment();
            case FAVOURITE_RECIPES:
                return new ChosenRecipeFragment();
            case CHOSEN_PRODUCTS:
                return new Fragment();
            default:
                return new CategoryFragment();
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}