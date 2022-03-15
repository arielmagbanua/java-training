package Final_MAIN;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class Recipe_MAIN {

    public String recipeName;
    private int servings;
    ArrayList<Ingredient_MAIN> recipeIngredients = new ArrayList();
    ArrayList<String> recipeInstructions = new ArrayList();
    private double totalRecipeCalories;

    // Creating accessors and mutators for the instance variables
    /**
     *
     * @param recipeName
     */
    public void setRecipeName(String recipeName){
        this.recipeName = recipeName;
    }
    /**
     *
     * @return recipeName
     */
    public String getRecipeName(){
        return recipeName;
    }
    /**
     *
     * @param servings
     */

    public void setServings(int servings){
        this.servings = servings;
    }
    /**
     *
     * @return servings
     */
    public int getServings(){
        return servings;
    }
    /**
     *
     * @param recipeIngredients
     */

    public void setRecipeIngredients(ArrayList<Ingredient_MAIN> recipeIngredients){
        this.recipeIngredients = recipeIngredients;
    }
    /**
     *
     * @return
     */
    public ArrayList<Ingredient_MAIN> getRecipeIngredients(){
        return recipeIngredients;
    }
    /**
     *
     * @param recipeInstructions
     */
    public void setRecipeInstructions(ArrayList<String> recipeInstructions) {
        this.recipeInstructions = recipeInstructions;
    }
    /**
     *
     * @return
     */
    public ArrayList<String> getRecipeInstructions() {
        return recipeInstructions;
    }
    /**
     *
     * @param totalRecipeCalories
     */

    public void setTotalRecipeCalories(int totalRecipeCalories){
        this.totalRecipeCalories = totalRecipeCalories;
    }
    public double getTotalRecipeCalories(){
        return totalRecipeCalories;
    }

    // Now we build the constructors one to create a new object and one to overload the constructor

    public Recipe_MAIN(){
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList();
        this.recipeInstructions = new ArrayList();
        this.totalRecipeCalories = 0;

    }
    /**
     *
     * @param recipeName
     * @param servings
     * @param recipeInstructions
     * @param recipeIngredients
     * @param totalRecipeCalories
     */


    public Recipe_MAIN(String recipeName, int servings,ArrayList<String> recipeInstructions, ArrayList<Ingredient_MAIN> recipeIngredients, double totalRecipeCalories){
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstructions = recipeInstructions;
        this.totalRecipeCalories = totalRecipeCalories;
    }

    public void addInstructions() {

        String instruction = "";

        boolean addMoreInstructions = true;

        Scanner scnr = new Scanner(System.in);

        do {
            System.out.println("Please enter an instruction or type 'end' if you are finished entering instructions: ");
            instruction = scnr.nextLine();

            if (instruction.toLowerCase().equals("end")) {

                addMoreInstructions = false;

            }
            else {
                recipeInstructions.add(instruction);

                addMoreInstructions = true;
            }

        } while (addMoreInstructions == true);
    }


    // Print recipe method
    public void printRecipe(){
        double singleServingCalories = (totalRecipeCalories / servings);
        System.out.println("Here is the information associated with you recipe: ");
        System.out.println("Recipe: "+ recipeName);
        System.out.println("This recipe serves: "+ servings);
        System.out.println("These are the ingredients you entered: "+ recipeIngredients);
        System.out.println("These are instructions for your recipe entered: ");
        System.out.println( recipeInstructions );


        for (int i = 0; i < recipeIngredients.size(); i++) {  //For loop to print each array member
            Ingredient_MAIN ingredient = recipeIngredients.get(i);
            System.out.println(ingredient.getNameOfIngredient());
        }
        System.out.println("Each Serving Has " + singleServingCalories + " Calories.");

    }
    /**
     *
     * @return
     */

    public Recipe_MAIN addNewRecipe(){
        double totalRecipeCalories = 0;
        ArrayList<Ingredient_MAIN> recipeIngredients = new ArrayList();


        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter the name of the recipe: ");
        String recipeName = scnr.nextLine();

        System.out.println("Please enter the number of servings for this recipe: ");
        int servings = Integer.parseInt(scnr.nextLine());


        // Using a While loop to add more ingreadients


        while(true){

            System.out.println("Please enter the ingredient name or type 'end' if you are finished: ");
            String ingredientName = scnr.nextLine();


            if(ingredientName.toLowerCase().equals("end")){
                //addMoreIngredients = false;
                break;
            } else {
                System.out.println("Please Enter the Unit of measurement for this Ingredient, Please only select from the following options: ");
                System.out.println("Cups, Tbsp, Tsp, Grams");
                String unitMeasurement = "";
                while(true){
                    unitMeasurement = scnr.nextLine();
                    if ((unitMeasurement.equalsIgnoreCase("Cups")) || (unitMeasurement.equalsIgnoreCase("Tbsp")) || (unitMeasurement.equalsIgnoreCase("Tsp")) || (unitMeasurement.equalsIgnoreCase("Grams"))){
                        System.out.println("You have selected " + unitMeasurement);
                        break;
                    } else {
                        System.out.println("Please enter one of the preceding options.");
                    }
                }

                System.out.println("Please enter the number of " + unitMeasurement + " of " + ingredientName + " required (between 1 and 100): ");

                float ingredientAmount;
                while(true){
                    ingredientAmount = Float.parseFloat(scnr.nextLine());

                    if ((ingredientAmount >= 1)&& (ingredientAmount <= 100)){
                        System.out.println("The amount you entered " + ingredientAmount + " is a valid amount!");
                        break;
                    } else if (ingredientAmount < 1) {
                        System.out.println(ingredientAmount + " is less than 1, sorry you are out of attempts.");
                    } else {
                        System.out.println(ingredientAmount + " is greater than 100, sorry you are out of attempts.");
                    }
                }


                System.out.println("Please enter the calories per unit of the ingredient " + ingredientName + " (between 1 and 2000 calories): ");
                int numberOfCaloriesPerUnit;
                while(true){
                    numberOfCaloriesPerUnit = Integer.parseInt(scnr.nextLine());

                    if ((numberOfCaloriesPerUnit >=1 )&& (numberOfCaloriesPerUnit <= 2000)){
                        System.out.println(numberOfCaloriesPerUnit + " is a valid number of calories!");
                        break;
                    } else if (numberOfCaloriesPerUnit < 1){
                        System.out.println(numberOfCaloriesPerUnit + " is less than 1. Sorry, you are out of attempts.");
                    } else {
                        System.out.println(numberOfCaloriesPerUnit + " is greater than 2000. Sorry, you are out of attempts.");
                    }
                }

                float totalCalories = ingredientAmount * numberOfCaloriesPerUnit;

                System.out.print(ingredientName + " uses " + ingredientAmount + " number of " + unitMeasurement + "'s" + " which contains " + totalCalories + " total calories.");
                System.out.println("Ingredient has been successfully added.");

                Ingredient_MAIN ing = new Ingredient_MAIN(ingredientName, unitMeasurement,ingredientAmount, numberOfCaloriesPerUnit, totalCalories);
                recipeIngredients.add(ing);
                totalRecipeCalories += totalCalories;
            }




        }


        Recipe_MAIN recipe1 = new Recipe_MAIN(recipeName,servings,recipeInstructions,recipeIngredients,totalRecipeCalories);
        recipe1.printRecipe();
        recipe1.addInstructions();
        return recipe1;


    }

    @Override
    public String toString() {
        return recipeName;
    }
}
