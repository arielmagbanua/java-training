import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PSDB {
    // Method to read file contents
    ProbeList readFile()
    {
        // Declares an object of class ProbeList
        ProbeList pl = null;

        // Scanner class object declared to read file contents
        Scanner fileRead = null;

        // To count number of records
        int counter = 0;

        // try block begins
        try
        {
            // get the project source directory
            // this is the current directory of the project where this class is located
            String projectSourceDir = Paths.get("src")
                    .toAbsolutePath()
                    .toString();

            // create the path of the file which located in the project source directory
            String firewallFilePath = projectSourceDir + "/firewall.log.txt";

            // Opens the file for reading
            fileRead = new Scanner(new File(firewallFilePath));

            // Loops till end of the file
            while(fileRead.hasNextLine())
            {
                // Reads a record
                fileRead.nextLine();
                // Increase the record counter by one
                counter++;
            }// End of while loop

            // Close the file
            fileRead.close();

            // Creates the object by passing parameter as number of records
            pl = new ProbeList(counter);

            // Opens the file for reading
            fileRead = new Scanner(new File(firewallFilePath));

            // Loops till end of the file
            while(fileRead.hasNextLine())
            {
                // Reads a record
                String record = fileRead.nextLine();
                // Split record with space
                String []each = record.split(" ");

                // Extracts the index position of ":" from destination
                int pos = each[2].lastIndexOf(":");
                // Extracts data from found position next position to end
                // and converts it to integer
                int desport = Integer.parseInt(each[2].substring(pos+1));

                // Extracts IP address from starting to found index position of
                // symbol ":"
                String ip = each[1].substring(0, each[1].lastIndexOf(":"));

                // Extracts the index position of ":" from source
                pos = each[1].lastIndexOf(":");
                // Extracts data from found position next position to end
                // and converts it to integer
                int oriport = Integer.parseInt(each[1].substring(pos+1));

                // Extracts time from found index position of symbol "("
                String time = each[0].substring(each[0].indexOf("("));

                // Creates an object of class Probe using parameterized constructor
                Probe p = new Probe(desport, ip, oriport, time);

                // Calls the method to inserts the object to array
                pl.insertProbe(p);
            }// End of while loop

            // Close the file
            fileRead.close();
        }// End of try

        // Catch block to handle FileNotFoundException
        catch (FileNotFoundException e)
        {
            System.err.println("\n Unable to open the file: firewall.log.txt" +
                    " for reading.");
        }// End of catch

        // Returns the object
        return pl;
    }

    // main method definition
    public static void main(String[] args)
    {
        // Creates an object of class PSDB
        PSDB ps = new PSDB();

        // Calls the object to read file
        ProbeList pl = ps.readFile();

        // Scanner class object to accept data from console
        Scanner sc = new Scanner(System.in);

        // Local variable to store data entered by the user
        String query;
        String ip;
        int count;

        System.out.println("\n Welcome to the Port Scan Database");

        // Loops till "END"
        do
        {
            // Displays menu
            System.out.println("\n Enter IP/DP/PL/IL/END (IP Address/ " +
                    "Destination Port/Port List/IP List/END): ");
            // Accepts query
            query = sc.next();

            // Checks if user entered "END" then come out of the outer
            // do - while loop (ignoring case)
            if(query.equalsIgnoreCase("END"))
                break;

            // Checks if query is equals to "IP" (ignoring case)
            if(query.equalsIgnoreCase("IP"))
            {
                // Loops till user choice is not "END"
                do
                {
                    // Accepts IP
                    System.out.println("\n Enter which IP do you wish to retrive " +
                            "statistics? ");
                    ip = sc.next();

                    // Checks if user entered "END" then come out of the loop (ignoring case)
                    if(ip.equalsIgnoreCase("END"))
                        break;
                    // Otherwise calls the method to count IP
                    count = pl.countProbe(ip);

                    // Checks if count is greater than 0
                    if(count > 0)
                        // Displays result
                        System.out.println("\n There are " + count + " probs from " + ip);
                    else
                        System.out.println("\n There were no probs from that IP address.");
                }while(true);
            }
            // Otherwise checks if query is equals to "DP" (ignoring case)
            else if(query.equalsIgnoreCase("DP"))
            {
                // Loops till user choice is not "END"
                do
                {
                    // Accepts destination port
                    System.out.println("\n Enter which port do you wish to retrive " +
                            "statistics? ");
                    ip = sc.next();

                    // Checks if user entered "END" then come out of the loop (ignoring case)
                    if(ip.equalsIgnoreCase("END"))
                        break;

                    // Otherwise calls the method to count destination IP
                    // passes the parameter after converting to integer
                    count = pl.countProbe(Integer.parseInt(ip));

                    // Checks if count is greater than 0
                    if(count > 0)
                        // Displays result
                        System.out.println("\n There are " + count + " probs of port "
                                + ip);
                    else
                        System.out.println("\n There were no probs of port " + ip);
                }while(true);
            }
            // Otherwise checks if query is equals to "PL" (ignoring case)
            else if(query.equalsIgnoreCase("PL"))
            {
                // Loops till user choice is not "END"
                do
                {
                    // Accepts source IP
                    System.out.println("\n Enter a source IP address to see a list of " +
                            "ports that it scanner");
                    ip = sc.next();

                    // Checks if user entered "END" then come out of the loop (ignoring case)
                    if(ip.equalsIgnoreCase("END"))
                        break;

                    // Otherwise calls the method to stores return result
                    ArrayList<Probe> result = pl.getProbes(ip);

                    // Checks if count is greater than 0
                    if(result.size() > 0)
                        // Loops till number of results
                        for(int c = 0; c < result.size(); c++)
                            // Displays result
                            System.out.println(result.get(c));
                    else
                        System.out.println("\n Empty list.");
                }while(true);
            }
            // Otherwise checks if query is equals to "IL" (ignoring case)
            else if(query.equalsIgnoreCase("IL"))
            {
                // Loops till user choice is not "END"
                do
                {
                    // Accepts source IP
                    System.out.println("\n For which port do you wish to retrive" +
                            " statistics? ");
                    ip = sc.next();

                    // Checks if user entered "END" then come out of the loop (ignoring case)
                    if(ip.equalsIgnoreCase("END"))
                        break;

                    // Otherwise calls the method to stores return result
                    ArrayList<String> result = pl.getProbes(Integer.parseInt(ip));

                    // Checks if count is greater than 0
                    if(result.size() > 0)
                        // Loops till number of results
                        for(int c = 0; c < result.size(); c++)
                            // Displays result
                            System.out.println(result.get(c));
                    else
                        System.out.println("\n Empty list.");
                }while(true);
            }
            else
                System.out.println("\n Invalid Query.");
        }while(true);
    }
}
