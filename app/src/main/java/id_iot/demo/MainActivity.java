package id_iot.demo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecipeList recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recipeList = new RecipeList();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        setUpTabs(tabLayout);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.screen);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpTabs(TabLayout tabLayout){
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.collection));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.list));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.favorite));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.bucket));
    }

    public ArrayList<Recipe> getRecipesList(){
        return this.recipeList.getRecipes();
    }
}