package id_iot.demo;

import java.util.ArrayList;

public class RecipeList {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public RecipeList(){
        recipes.add(new Recipe("Bucket of hot nails", "2 ingredients", R.drawable.bucket_of_nails));
        recipes.add(new Recipe("Chicken", "3 ingredients", R.drawable.chicken));
        recipes.add(new Recipe("Beef", "5 ingredients", R.drawable.beef));
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
}