package classwork.day20;

import java.util.Arrays;

public class Recipe {

    public String recipename;
    public Ingredient[] ingredlist;
    public int preptime;

    public Recipe(String recipename, Ingredient[] ingredlist, int preptime) {
        this.recipename = recipename;
        this.ingredlist = ingredlist;
        this.preptime = preptime;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public Ingredient[] getIngredlist() {
        return ingredlist;
    }

    public void setIngredlist(Ingredient[] ingredlist) {
        this.ingredlist = ingredlist;
    }

    public int getPreptime() {
        return preptime;
    }

    public void setPreptime(int preptime) {
        this.preptime = preptime;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipename='" + recipename + '\'' +
                ", ingredlist=" + Arrays.toString(ingredlist) +
                ", preptime=" + preptime +
                '}';
    }
}
