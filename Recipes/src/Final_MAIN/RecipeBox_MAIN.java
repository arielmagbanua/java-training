package Final_MAIN;
import java.util.*;
/**
 *
 * @author ahmad
 */
public class RecipeBox_MAIN {
    ArrayList<Recipe_MAIN> listOfRecipes = new ArrayList<>();
    /**
     *
     * @param listOfRecipes
     */
    public void setListOfRecipes(ArrayList<Recipe_MAIN> listOfRecipes) {
        this.listOfRecipes = listOfRecipes;
    }
    /**
     *
     * @return
     */
    public ArrayList<Recipe_MAIN> setListOfRecipes() {
        return listOfRecipes;
    }

    //Constructors

    public void RecipeBox_MAIN(){
        this.listOfRecipes = listOfRecipes;
    }
    /**
     *
     * @param listOfRecipes
     */
    public void RecipeBox_MAIN(ArrayList<Recipe_MAIN> listOfRecipes) {
        listOfRecipes = listOfRecipes;
    }


    // User Defined Method
    public void printAllRecipeNames() {

        for (int i = 0; i < listOfRecipes.size(); i++) {
            System.out.println(listOfRecipes.get(i));
        }
    }

    public void printAllRecipeDetails() {

        for (int j = 0; j < listOfRecipes.size(); j++) {

            Recipe_MAIN tempRecipe = new Recipe_MAIN();

            tempRecipe = listOfRecipes.get(j);

            tempRecipe.printRecipe();

        }
    }


    public void addNewRecipe() {

        Recipe_MAIN tempRecipe2 = new Recipe_MAIN();

        listOfRecipes.add(tempRecipe2.addNewRecipe());

    }

    // Method to delete a recipe
    public void deleteRecipe() {

        Scanner deleteScnr = new Scanner(System.in);

        // added a prompt message, delete this if not needed
        System.out.println("Please enter the name of the recipe to delete:");
        // get the line which contain the name of the recipe and strip for trailing spaces
        String recipeToDelete = deleteScnr.nextLine().trim();

        for(int k = 0; k < listOfRecipes.size(); k++) {

            if (listOfRecipes.get(k).recipeName.equals(recipeToDelete)) {

                listOfRecipes.remove(k);
                break;
            }
        }
    }
    /**
     *
     * @param recipeName
     */
    void addInstructionToRecipeName(String recipeName){
        for (Recipe_MAIN recipe_MAIN : listOfRecipes){
            if (recipeName.equalsIgnoreCase(recipe_MAIN.getRecipeName())){
                recipe_MAIN.addInstructions();
                return;
            }
        }
        System.out.println("Recipe with that name cannot be found");
    }

    /**
     * Prints all instructions of the given recipe name
     *
     * @param recipeName The name of the recipe
     */
    public void printRecipeInstructions(String recipeName) {
        for (Recipe_MAIN recipe_MAIN : listOfRecipes){
            if (recipeName.equalsIgnoreCase(recipe_MAIN.getRecipeName())){
                // print each instruction
                for (String instruction : recipe_MAIN.getRecipeInstructions()) {
                    System.out.println(instruction);
                }

                return;
            }
        }

        System.out.println("Recipe with that name cannot be found");
    }
}