package id_iot.demo;

import java.util.ArrayList;

public class RecipeList {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    private String HTCBucket = "Take a bunch of nails, heat them until 100C and throw them into a bucket.";
    private String HTCChicken = "Take the chicken breast, cut it into medium size slices, cover with seasoning, bake in an omit for 20 minutes.";
    private String HTCBeef = "Take the beef part, cover with seasoning, power-up with salt, bake for 10 minutes.";

    public RecipeList(){
        recipes.add(new Recipe("Bucket of hot nails", "2 ingredients", HTCBucket, R.drawable.bucket_of_nails));
        recipes.add(new Recipe("Chicken", "3 ingredients", HTCChicken, R.drawable.chicken));
        recipes.add(new Recipe("Beef", "5 ingredients", HTCBeef, R.drawable.beef));
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
}