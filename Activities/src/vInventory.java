import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class vInventory {
    private int vcode;
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    private ArrayList<vInventory> vInventorylist;

    public vInventory() {
        vInventorylist = new ArrayList<>();
    }

    public vInventory(int vcode, String make, String model, String color, int year, int mileage) {
        this.vcode = vcode;
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public static void main(String[] args) {
        vInventory vInventory = new vInventory();

        try (Scanner userInput = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n*****MENU OPTIONS*****");
                System.out.println("To add a car to the inventory, enter 1");
                System.out.println("To update a cars information, enter 2");
                System.out.println("To remove a car from the inventory, enter 3");
                System.out.println("To see cars in the inventory, enter 4");
                System.out.println("To exit, press 5");
                System.out.print("Selected Option: ");
                int option = userInput.nextInt();
                userInput.nextLine();

                if (option == 1) {
                    System.out.println("\nAdd vehicle to inventory ");
                    System.out.print("What is the vcode? ");

                    // get the vcode and trim all trailing spaces
                    String vCodeStr = userInput.nextLine().trim();
                    // convert the vcode string to int and store in the variable
                    int vcode = Integer.parseInt(vCodeStr);

                    System.out.print("Vehicle make: ");
                    String make = userInput.nextLine();

                    System.out.print("Vehicle model: ");
                    String model = userInput.nextLine();

                    System.out.print("Color: ");
                    String color = userInput.nextLine();

                    System.out.print("Enter the car's year: ");
                    // get the car year and trim all trailing spaces
                    String carYear = userInput.nextLine().trim();
                    // convert the string to int and store in the variable
                    int year = Integer.parseInt(carYear);

                    System.out.print("Mileage: ");
                    String mileageStr = userInput.nextLine().trim();
                    int mileage = Integer.parseInt(mileageStr);

                    vInventory vehicle = new vInventory(vcode, make, model, color, year, mileage);
                    vInventory.addVehicle(vehicle);

                } else if (option == 2) {
                    System.out.println("\nUpdate Vehicle Info:");
                    System.out.print("Enter the vcode: ");
                    int vcodeOld = userInput.nextInt();

                    System.out.print("Vehicle make: ");
                    String MakeOld = userInput.nextLine();

                    System.out.print("Vehicle model: ");
                    String modelOld = userInput.nextLine();

                    System.out.print("Color: ");
                    String colorOld = userInput.nextLine();

                    System.out.print("Vehicle year: ");
                    int yearOld = userInput.nextInt();
                    userInput.nextLine();

                    System.out.print("Mileage: ");
                    int mileageOld = userInput.nextInt();
                    userInput.nextLine();


                    System.out.println("\nUpdate vehicle information");
                    System.out.print("Enter vcode to update: ");
                    int vcodeNew = userInput.nextInt();
                    userInput.nextLine();

                    System.out.print("Make: ");
                    String makeNew = userInput.nextLine();

                    System.out.print("Model: ");
                    String modelNew = userInput.nextLine();

                    System.out.print("Color: ");
                    String colorNew = userInput.nextLine();

                    System.out.print("Vehicle year: ");
                    int yearNew = userInput.nextInt();
                    userInput.nextLine();

                    System.out.print("Mileage: ");
                    int mileageNew = userInput.nextInt();
                    userInput.nextLine();

                    vInventory.updateVehicle(vcodeOld, MakeOld, modelOld, colorOld, yearOld, mileageOld,
                            vcodeNew, makeNew, modelNew, colorNew, yearNew, mileageNew);

                } else if (option == 3) {
                    System.out.println("\nRemove vehicle from inventory");
                    System.out.println("Enter vcode: ");
                    int vcode = userInput.nextInt();
                    userInput.nextLine();

                    System.out.print("Vehicle make: ");
                    String make = userInput.nextLine();

                    System.out.print("Vehicle model: ");
                    String model = userInput.nextLine();

                    System.out.print("Color: ");
                    String color = userInput.nextLine();

                    System.out.print("Vehicle year: ");
                    int year = userInput.nextInt();
                    userInput.nextLine();

                    System.out.print("Mileage: ");
                    int mileage = userInput.nextInt();
                    userInput.nextLine();

                    vInventory.deleteVehicle(vcode, make, model, color, year, mileage);

                } else if (option == 4) {
                    vInventory.Display();
                }
            }
        }
    }

    public int getvcode() {
        return vcode;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getcolor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setVcode(int vcode) {
        this.vcode = vcode;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public void addVehicle(vInventory vehicle) {
        vInventorylist.add(vehicle);
    }

    public void deleteVehicle(int vcode, String make, String model, String color, int year, int mileage) {
        for (int i = 0; i < vInventorylist.size(); i++) {
            vInventory vehicle = vInventorylist.get(i);
            if (vehicle.getvcode() == vcode
                    && vehicle.getYear() == year
                    && vehicle.getMake().equalsIgnoreCase(make)
                    && vehicle.getModel().equalsIgnoreCase(model)
                    && vehicle.getMileage() == mileage
                    && vehicle.getcolor().equalsIgnoreCase(color)) {
                vInventorylist.remove(vehicle);
            }
        }
    }

    public void updateVehicle(
            int vcodeOld,
            String makeOld,
            String modelOld,
            String colorOld,
            int yearOld,
            int mileageOld,
            int vcodeNew,
            String makeNew,
            String modelNew,
            String colorNew,
            int yearNew,
            int mileageNew
    ) {
        for (int i = 0; i < vInventorylist.size(); i++) {
            vInventory vehicle = vInventorylist.get(i);
            if (vehicle.getvcode() == vcodeOld
                    && vehicle.getYear() == yearOld
                    && vehicle.getMake().equalsIgnoreCase(makeOld)
                    && vehicle.getMileage() == mileageOld
                    && vehicle.getcolor().equalsIgnoreCase(colorOld)) {

                vehicle.setVcode(vcodeNew);
                vehicle.setMake(makeNew);
                vehicle.setModel(modelNew);
                vehicle.setcolor(colorNew);
                vehicle.setYear(yearNew);
                vehicle.setMileage(mileageNew);
            }
        }
    }

    public void Display() {
        BufferedWriter bwrt = null;
        try {
            FileWriter fwrt = new FileWriter("vInventory_output.txt");
            bwrt = new BufferedWriter(fwrt);
            System.out.println("\nVvehicles attributes:\n");

            for (int i = 0; i < vInventorylist.size(); i++) {
                vInventory vehicle = vInventorylist.get(i);

                System.out.println("VCode: " + vehicle.getvcode());
                bwrt.write("Vcode: " + vehicle.getvcode());
                bwrt.newLine();

                System.out.println("Make: " + vehicle.getMake());
                bwrt.write("Make: " + vehicle.getMake());
                bwrt.newLine();

                System.out.println("Model: " + vehicle.getModel());
                bwrt.write("Model: " + vehicle.getModel());
                bwrt.newLine();

                System.out.println("Color: " + vehicle.getModel());
                bwrt.write("Color: " + vehicle.getModel());
                bwrt.newLine();

                System.out.println("Year: " + vehicle.getYear());
                bwrt.write("Year: " + vehicle.getYear());
                bwrt.newLine();

                System.out.println("Mileage: " + vehicle.getMileage());
                bwrt.write("Mileage: " + vehicle.getMileage());
                bwrt.newLine();

                System.out.println();
            }

            bwrt.flush();
        } catch (FileNotFoundException e) {
        } catch (IOException ioe) {
        } catch (Exception e) {
        } finally {
            try {
                if (bwrt != null) {
                    bwrt.close();
                }
            } catch (IOException e) {
            }
        }
    }
}
