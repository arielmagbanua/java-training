import java.util.Scanner;

public class TexasShelter {
    public static void main(String[] args) {
        int dogsCount = getIntegerInput("Please, enter the number of dogs in the shelter (Max 100): ");

        if (dogsCount <= 0 || dogsCount > 100) {
            // invalid count
            System.out.print("Invalid number of dogs");
            // return immediately to stop the code execution further
            return;
        }

        // create the dogs array
        Dog[] dogs = new Dog[dogsCount];

        // initialize all dogs
        for (int i = 0; i < dogsCount; i++) {
            dogs[i] = new Dog();
        }

        // infinite while loop, only break the loop if user wishes to exit
        while (true) {
            System.out.println("MAIN MENU");
            System.out.println("0 - Exit, 1 - Report, 2 - Assign/Modify dogs, 3 - (Ex)Change Dog, 4 - Close shelter, 5 - List");
            int option = getIntegerInput("Select an option: ");

            if (option == 0) {
                // user wants to exit, so break the loop
                break;
            }

            switch (option) {
                case 1: // Report
                    // declare the dog weight count variables
                    int xlargeCount = 0;
                    int largeCount = 0;
                    int mediumCount = 0;
                    int smallCount = 0;
                    int xSmallCount = 0;

                    // iterate over all dogs and increment the counters base on the weight range
                    for (int i = 0; i < dogs.length; i++) {
                        // get the weight of the current dog
                        double weight = dogs[i].getWeight();

                        if (weight >= 1.0 && weight <= 20) {
                            // extra small
                            ++xSmallCount;
                        } else if (weight >= 21 && weight <= 30) {
                            // small
                            ++smallCount;
                        } else if (weight >= 31 && weight <= 50) {
                            // medium
                            ++mediumCount;
                        } else if (weight >= 51 && weight <= 80) {
                            // large
                            ++largeCount;
                        } else if (weight >= 81) {
                            ++xlargeCount;
                        }
                    }

                    // print the report
                    System.out.println("DOGS' REPORT");
                    System.out.println("Xlarge: " + xlargeCount);
                    System.out.println("Large: " + largeCount);
                    System.out.println("Medium: " + mediumCount);
                    System.out.println("Small: " + smallCount);
                    System.out.println("Xsmall: " + xSmallCount);

                    break;
                case 2: // Assign/Modify
                    // get the index of the dog to assign and modify
                    int index = getIntegerFromRange(String.format("Enter the index (0 to %d): ", dogsCount - 1), 0, dogsCount - 1);

                    // get the dog
                    Dog selectedDog = dogs[index];

                    // current weight of the dog message to be printed
                    String currentWeightMessage = String.format("the current weight of the dog at %d is: %.2f\n", index, selectedDog.getWeight());

                    // get the new weight of the dog
                    double weight = getDoubleFromRange(currentWeightMessage + "Enter the weight of the new dog (0.00 - 100.00): ", 0.0, 100.0);

                    // set the new weight
                    selectedDog.setWeight(weight);
                    break;
                case 3: // Exchange dog
                    // get the first position
                    int firstPosition = getIntegerFromRange(String.format("Enter the position from (0 to %d): ", dogsCount - 1), 0, dogsCount - 1);
                    // initialize second position
                    int secondPosition = -1;
                    // ask the user for the second position other than second position, continually ask until the user gives the correct position
                    while (true) {
                        secondPosition = getIntegerFromRange(
                                String.format("Enter the position from (0 to %d) that is not %d: ", dogsCount - 1, firstPosition),
                                0,
                                dogsCount - 1
                        );

                        if (secondPosition != firstPosition) {
                            // the position is valid so break the loop
                            break;
                        }

                        // invalid
                        System.out.println("Value out of range, please, try again");
                    }

                    // swap the dogs
                    Dog tempDog = dogs[firstPosition];
                    dogs[firstPosition] = dogs[secondPosition];
                    dogs[secondPosition] = tempDog;
                    break;
                case 4: // Close shelter
                    // user closed the shelter therefore reset the all dogs weight to zero
                    for (Dog dog : dogs) {
                        dog.setWeight(0.0);
                    }
                    break;
                case 5: // List
                    for (int i = 0; i < dogs.length; i++) {
                        System.out.printf("Dog[%d]: %.2f\n", i, dogs[i].getWeight());
                    }

                    break;
                default:
                    // wrong option input
                    System.out.println("Value out of range, please, try again");
            }
        }
    }

    public static int getIntegerFromRange(String prompt, int from, int to) {
        // continually ask user until the user gives the correct integer
        while (true) {
            int input = getIntegerInput(prompt);

            if (input >= from && input <= to) {
                // input within the range
                return input;
            }

            // at this point the input is not in the valid range
            System.out.println("Value out of range, please, try again");
        }
    }

    public static double getDoubleFromRange(String prompt, double from, double to) {
        // continually ask user until the user gives the correct integer
        while (true) {
            double input = getDoubleInput(prompt);

            if (input >= from && input <= to) {
                // input within the range
                return input;
            }

            // at this point the input is not in the valid range
            System.out.println("Value out of range, please, try again");
        }
    }

    public static int getIntegerInput(String prompt) {
        // scanner for input
        Scanner scanner = new Scanner(System.in);

        // use infinite while loop, to continually ask user for integer input until the user gives an integer
        while (true) {
            // print prompt
            System.out.print(prompt);

            try {
                // get integer from the user, trim it, convert to int, and return it
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // the user did not input an integer, so ignore it to continue the loop
            }
        }
    }

    public static double getDoubleInput(String prompt) {
        // scanner for input
        Scanner scanner = new Scanner(System.in);

        // use infinite while loop, to continually ask user for integer input until the user gives an integer
        while (true) {
            // print prompt
            System.out.print(prompt);

            try {
                // get integer from the user, trim it, convert to int, and return it
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                // the user did not input an integer, so ignore it to continue the loop
            }
        }
    }
}
