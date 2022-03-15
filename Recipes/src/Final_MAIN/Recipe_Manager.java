package Final_MAIN;
import java.util.*;
/**
 *
 * @author ahmad
 */
public class Recipe_Manager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecipeBox_MAIN finalRecipeBox = new RecipeBox_MAIN();

        Scanner menuScnr = new Scanner(System.in);

        /**
         * Print a menu for the user to select one of three menu options.
         */

        System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "5. Print recipe instructions\n");

        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {

            int input = Integer.parseInt(menuScnr.nextLine());
            //System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n" + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "5. Print recipe instructions\n");
            if (input == 1) {

                finalRecipeBox.addNewRecipe();
            }

            else if (input == 2) {

                finalRecipeBox.printAllRecipeDetails();
            }

            else if (input == 3) {

                finalRecipeBox.printAllRecipeNames();
            }

            else if (input == 4) {
                finalRecipeBox.deleteRecipe();
            }
            else if (input == 5){
                System.out.println("Please select which recipe you woud like to view the instructions: ");
                String recipeName = menuScnr.nextLine();
                // finalRecipeBox.addInstructionToRecipeName(recipeName);

                // print all instructions
                finalRecipeBox.printRecipeInstructions(recipeName);
            }

            System.out.println("Menu\n" + "1. Add Recipe\n" + "2. Print All Recipe Details\n"
                    + "3. Print All Recipe Names\n" + "4. Delete a Recipe\n" + "5. Print recipe instructions\n");


        }

    }
}
