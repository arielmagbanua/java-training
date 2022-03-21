import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem24 {

    public static void main(String[] args)  throws java.io.IOException{

        java.io.File file = new java.io.File("Problem24.txt");

        if (file.exists()) {
            System.out.println("file already exists");
            System.exit(1);
        }
        try (java.io.PrintWriter output = new java.io.PrintWriter(file);) {

            ArrayList <String> stringArrList = new ArrayList<String>();
            ArrayList <Integer> intArrList = new ArrayList<Integer>();

            Scanner userInput = new Scanner (System.in);

            String stringEntered;
            int intEntered;

            System.out.println("Please enter a product (hit enter), then type the quantity of the product as an integer." +
                    " When you are done, please type end to create your input into the file.");

            while(true) {

                stringEntered = userInput.next();
                if(stringEntered.equalsIgnoreCase("END")) {
                    break;
                }

                boolean isFound = false;
                int itemIndex;
                for (int i = 0; i < stringArrList.size(); i++) {
                    if(stringEntered.equals(stringArrList.get(i))) {
                        isFound = true;
                        intEntered = userInput.nextInt();
                        intArrList.set(i, intArrList.get(i) + intEntered);
                    }
                }
                // if isFound is false --> new to add new string and int
                if(isFound == false) {
                    stringArrList.add(stringEntered);
                    intEntered = userInput.nextInt();
                    intArrList.add(intEntered);
                }
            }

            for (int i = 0; i < stringArrList.size() -1; i++) {
                output.print(stringArrList.get(i) + ", ");

            }
            output.print(stringArrList.get(stringArrList.size()-1) + "\n");

            for (int i = 0; i < intArrList.size() -1; i++) {
                output.print(intArrList.get(i) + ", ");
            }
            output.print(intArrList.get(intArrList.size()-1) + "\n");


            userInput.close();
            output.close();
        }
        catch(InputMismatchException ex) {
            System.out.println("Not an integer, please enter an integer");
        }
    }

}