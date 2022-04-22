class WashingMachine {
    // maxLoad denotes the maximum load in pounds the washing machine can hold.
    private double maxLoad;
    //boolean variable denotes that a washing matching can dry the clothes or not
    private boolean hasDryer;

    //Constructor
    public WashingMachine(double maxLoad, boolean hasDryer){
        setMaxLoad(maxLoad);
        setHasDryer(hasDryer);
    }

    //settings for washing machine
    public double getMaxLoad(){
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad){
        this.maxLoad = maxLoad;
    }

    public boolean hasDryer(){
        return hasDryer;
    }

    public void setHasDryer(boolean hasDryer) {
        this.hasDryer = hasDryer;
    }

    //Load method loads clothes in the washing machine
    public void loadClothes (double load) {
        if (load > this.getMaxLoad()) {
            //If the load is greater than the maxLoad
            System.out.println("You have too many clothes in machine! Max Load: "+maxLoad+" pounds");
        } else {  //Else the clothes are loaded
            System.out.println("Clothes are loaded!");
        }
    }

    //Begin washing clothes
    public void wash() {
        System.out.println("The clothes have been washed!");
    }

    //dry clothes method
    public void dryClothes() {
        //If the hasDryer method is true
        if(this.hasDryer())
            System.out.println("The clothes have been dried!");
        else
            System.out.println("This washing machine has no drying feature, please remove clothes.");
    }
}
