import java.util.*;
public class main { //class main
    public static String conversion(String value, int sourceB, int destB)
    {
        return Integer.toString(Integer.parseInt(value, sourceB), destB);
    }

    public static void main(String[] args)
    {
        Scanner input= new Scanner(System.in);

        System.out.print("***Welcome to conversion Base program***\n\n");
        System.out.print("Enter an alphanumeric or numeric value to be converted : ");
        String value= input.nextLine();

        try
        {
            if ( value.matches("[A-Za-z0-9]+"))
            {
                System.out.print("\n*** Choose the base Source ***\n Base 2\n Base 8\n Base 10\n Base 16\n\nEnter : ");
                int sourceB = input.nextInt();

                System.out.print("\n*** Choose the base destination ***\n Base 2\n Base 8\n Base 10\n Base 16\n\nEnter : ");
                int destB = input.nextInt();

                if((sourceB==2 || sourceB==8 || sourceB==10 || sourceB==16) & (destB==2 || destB==8 || destB==10 || destB==16))
                {
                    System.out.println("\nConverted Base value: "+ conversion(value, sourceB, destB)+"\n\n");
                    main(null);
                }
                else
                {
                    System.out.println("\nError ! Destination Base ∈ {2, 8, 10, 16} !");
                }

            }
            else if (Integer.parseInt(value)<0 )
            {
                System.out.println("\nDo NOT enter negative or floating-point numbers !");
            }

        }
        catch(Exception e)
        {
            System.out.println("\nError formating Number ! Check the inputs & retry  !");
        }

    }
}