package Final_MAIN;

public class Ingredient_MAIN {
    private String nameOfIngredient;
    private String unitMeasurement;
    private float ingredientAmount;
    private int numberOfCaloriesPerUnit;
    private int numberOfCups;
    private double totalCalories;

    /**
     *
     * @param name
     * @param unit
     * @param amount
     * @param caloriesPerUnit
     * @param totCalories
     */

    public Ingredient_MAIN(String name, String unit, float amount, int caloriesPerUnit, double totCalories){
        nameOfIngredient = name;
        unitMeasurement = unit;
        ingredientAmount = amount;
        numberOfCaloriesPerUnit = caloriesPerUnit;
        totalCalories = totCalories;
    }
//Operations: Public Methods

    //Mutators and Accessors: Set Values at the this. Index and Return the Value

    //Set and Return Name of Ingredient
    /**
     *@param nameOfIngredient to set
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }
    /**
     *@return nameOfIngredient
     */
    public String getNameOfIngredient() {
        return nameOfIngredient;
    }
    /**
     *
     * @param numberOfcups
     */

    public void setNumberOfCups(int numberOfcups) {
        this.numberOfCups = numberOfCups;
    }
    /**
     *
     * @return numberOfCups
     */
    public int getNumberOfCups() {
        return numberOfCups;
    }



    //Set and Return Unit Measurement
    /**
     * @param unitMeasurement  unitMeasurement to set
     */
    public void setUnitMeasurement (String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }
    /**
     @return unitMeasurment
     */
    public String getUnitMeasurement () {
        return unitMeasurement;
    }

    //Set and Return Ingredient Amount
    /**
     *@param ingredientAmount the ingredientAmount to set
     */
    public void setIngredientAmount(float ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    /**
     * @return ingredientAmount
     */
    public float getIngredientAmount() {
        return ingredientAmount;
    }

    //Set and Return Number of Calories per Unit
    /**
     *
     * @param numberCaloriesPerUnit
     */
    public void setNumberCaloriesPerUnit(int numberCaloriesPerUnit) {
        this.numberOfCaloriesPerUnit = numberCaloriesPerUnit;
    }
    /**
     *
     * @return numberOfCaloriesPerUnit
     */

    public int getNumberCaloriesPerUnit() {
        return numberOfCaloriesPerUnit;

    }

    //Set and Return Total Calories
    /**
     *
     * @param totalCalories
     */
    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     *
     * @return totalCalories
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    @Override
    public String toString() {
        return nameOfIngredient;
    }
}
