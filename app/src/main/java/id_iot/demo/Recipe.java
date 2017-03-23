package id_iot.demo;

public class Recipe {
    private String recipeName;
    private String recipeDetail;
    private String recipeHowToCook;
    private int recipePhoto;
    private boolean favorite = false;

    public Recipe(String name, String detail, String howToCook, int photo){
        this.recipeName = name;
        this.recipeDetail = detail;
        this.recipeHowToCook = howToCook;
        this.recipePhoto = photo;
    }

    public String getRecipeName(){
        return this.recipeName;
    }

    public String getRecipeDetail(){
        return this.recipeDetail;
    }

    public String getRecipeHowToCook(){ return this.recipeHowToCook; }

    public int getRecipePhoto(){
        return this.recipePhoto;
    }

    public boolean getFavorite(){
        return this.favorite;
    }

    public void changeFavorite(){
        if (this.favorite == false) {
            this.favorite = true;
        }
        else{
            this.favorite = false;
        }
    }
}