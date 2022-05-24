package classwork.day20;

import java.util.List;

public class Recipe {

    private String recipename;
    private List<Ingredient> ingredlist;
    private int preptime;

    public Recipe(String recipename, List<Ingredient> ingredlist, int preptime) {
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

    public List<Ingredient> getIngredlist() {
        return ingredlist;
    }

    public void setIngredlist(List<Ingredient> ingredlist) {
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
                ", ingredlist=" + ingredlist +
                ", preptime=" + preptime +
                '}';
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
