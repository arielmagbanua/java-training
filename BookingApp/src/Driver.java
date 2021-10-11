import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Driver {
    static String path = "C:\\booking\\";
    static ArrayList<Booking> bookings = new ArrayList<>();
    static ArrayList<Customers> customers = new ArrayList<>();
    static ArrayList<Service> services = new ArrayList<>();
    static int nextBookingId; //Tutor: Just assume that the bookingId is an incremental integer value.
    public static ArrayList<Booking> getAllBookings() throws IOException {
        /*Tutor: Extracting all data from Booking files */
        String[] filedir;
        File files = new File(path); //Tutor: get all files in the source folder
        FilenameFilter filter = new FilenameFilter() {  //Tutor: set filter for the filenames to be read.
            public boolean accept(File dir, String fname) {
                String prefixName = fname.substring(0, 9);
                String extension = fname.substring(fname.lastIndexOf("."));
                if (prefixName.equalsIgnoreCase("bookings-") == true) { //Tutor: all files starts with the word 'bookings-'
                    if (extension.equalsIgnoreCase(".txt") == true) { //Tutor: ...and are .txt format
                        return true;
                    }
                }
                return false;
            }
        };
        filedir = files.list(filter);
        ArrayList<Booking> bookings = new ArrayList<Booking>();
        for (String fname : filedir) { //Tutor: read the content per file.
            FileReader fr = new FileReader(path + fname);
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String bookingId = line.split(",")[0];
                String customerId = line.split(",")[1];
                String date = line.split(",")[2];
                int totalFee;
                ArrayList<Integer> serviceCodes = new ArrayList<Integer>();
                try {
                    totalFee = Integer.parseInt(line.split(",")[3]);
                } catch (NumberFormatException ex) {
                    totalFee = 0;
                }
                int index = 3;
                String serviceCode = "";
                do {
                    try {
                        index++;
                        serviceCode = line.split(",")[index];
                        serviceCodes.add(Integer.parseInt(serviceCode));  //Tutor: store all service codes in a list
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        break;
                    }
                }
                while (true);
                if (bookingId.substring(0, 2).matches("-?\\d+(\\.\\d+)?") == false){ //Tutor: this is to handle the special character that is generated by readline() in the first line of every booking file.
                    bookingId = bookingId.substring(1, bookingId.length());
                    nextBookingId = Integer.parseInt(bookingId) + 1;
                } else {
                    nextBookingId = Integer.parseInt(bookingId) + 1;
                }
                // System.out.println("Booking Id = "+ bookingId +"\tnext = "+ nextBookingId);
                Booking b = new Booking(bookingId, customerId, date, totalFee, serviceCodes);
                bookings.add(b);
            }
            br.close();
        }
        return bookings;
    }
    public static ArrayList<Customers> getAllCustomers() throws IOException { //Tutor: moved Customer extraction out.
        ArrayList<Customers> customers = new ArrayList<Customers>();
        FileReader fr = new FileReader(path + "Customers.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null) {
            Customers c = new Customers(line.split(",")[0], line.split(",")[2], line.split(",")[1], line.split(",")[3], line.split(",")[4] + line.split(",")[5] + line.split(",")[6]);
            customers.add(c);
        }
        br.close();
        return customers;
    }
    public static ArrayList<Service> getAllServices() throws IOException { //Tutor: created this for the services.
        ArrayList<Service> service = new ArrayList<Service>();
        FileReader fr = new FileReader(path + "Services.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null) {
            Service s = new Service(Integer.parseInt(line.split(",")[0]), line.split(",")[1], line.split(",")[2], Double.parseDouble(line.split(",")[3]));
            service.add(s);
        }
        br.close();
        return service;
    }
    public static void main(String[] args) throws IOException {

        customers = getAllCustomers();
        bookings = getAllBookings();
        services = getAllServices();
        Scanner scanner = new Scanner(System.in);   // For user input
        int choice = 0;
        // Menu
        do {
            System.out.println("_________MENU_________");
            System.out.println("1. Display Bookings ");
            System.out.println("2. Make a booking ");
            System.out.println("3. Exit Program ");
            System.out.print("Enter any number from (1-3) : ");
            choice = scanner.nextInt();
            // On selecting option 1 from Menu
            if (choice == 1) {
                int ch = 0;
                Calendar cal = Calendar.getInstance();    // Calendar class is used to get the current time of the system
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // To convert the format of the date
                String stringDate = dateFormat.format(cal.getTime());  // Converted date
                System.out.println("\nBookings of Today(" + stringDate + ") : ");
                // For searching the date in the arraylist of objects
                String search = stringDate;
                int length = bookings.size();
                int count = 0;
                for (int i = 0; i < length; i++) {
                    if (bookings.get(i).date.contains(search)) {
                        String details = bookings.get(i).print();
                        System.out.println("\n" + details);
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("No bookings for Date : " + stringDate);
                }
                //Sub Menu
                //Tutor: indent sub-menu.
                System.out.println("\n\t_________SUB MENU_________");
                System.out.println("\t1. Display Booking Detail ");
                System.out.println("\t2. Change Display Date");
                System.out.println("\t3. Set Fee");
                System.out.println("\t4. Exit Sub menu");
                ch = scanner.nextInt();
                // On selecting option 1 from Sub menu
                if (ch == 1) {
                    System.out.println("Enter a Booking ID");
                    String b_id = scanner.next();
                    // For searching the bookings of the user entered booking ID
                    String s = b_id;
                    int len = bookings.size();
                    int counter = 0;
                    for (int i = 0; i < len; i++) {
                        if (bookings.get(i).bookingId.contains(s)) {
                            String bookingDetails = bookings.get(i).show();
                            System.out.println("\n" + bookingDetails);
                            counter++;
                            break;
                        }
                    }
                    if (counter == 0) {
                        System.out.println("No bookings for Booking ID : " + b_id);
                    }
                }
                // On selecting option 2 from Sub menu
                if (ch == 2) {
                    System.out.print("Enter a newly chosen date (dd/mm/yyyy): ");
                    String userDate = scanner.next();
                    for (int i = 0; i < length; i++) {
                        if (bookings.get(i).date.contains(userDate)) { //Tutor: set the search variable to 'userDate' instead of  'search'
                            bookings.get(i).date = userDate;
                            String details = bookings.get(i).print();
                            System.out.println("\n" + details);
                            count++;
                        }
                    }
                }
                // On selecting option 3 from Sub menu
                if (ch == 3) {
                    System.out.print("Enter the Booking ID of the booking for Fee changes : ");
                    String bID = scanner.next();
                    String s = bID;
                    int len = bookings.size();
                    int index = 0;
                    for (int i = 0; i < len; i++) {
                        if (bookings.get(i).bookingId.contains(s)) {
                            String bookingDetails = bookings.get(i).show();
                            index = i;
                            System.out.println("\n" + bookingDetails);
                        }
                    }
                    System.out.print("Enter a valid fee that is to be changed : ");
                    int fee = scanner.nextInt();
                    bookings.get(index).changeFeePrice(fee);
                    String str = bookings.get(index).show();
                    System.out.println(str);
                }
            }
            // On selecting option 2 from Menu
            if (choice == 2) {
                Booking booking = new Booking();
                System.out.println("\tSub Menu.");
                System.out.println("\t1. By Phone Number");
                System.out.println("\t2. By Surname");
                System.out.println("\t3. Exit Sub Menu");
                int ch = scanner.nextInt();
                scanner.nextLine();
                switch (ch) {
                    case 1:
                        System.out.println("Enter phone number.");
                        String phone = scanner.nextLine();
                        Customers cust = null;
                        for (Customers c : customers) {
                            if (c.getPhone().equals(phone)) {
                                cust = c;
                                break;
                            }
                        }
                        addBooking(cust);
                        break;
                    case 2:
                        System.out.println("Enter Surname");
                        String lastName = scanner.nextLine();
                        Customers custumer = null;
                        for (Customers c : customers) {
                            if (c.getLastName().equals(lastName)) {
                                custumer = c;
                                break;
                            }
                        }
                        addBooking(custumer);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Please choose correct option.");
                }
            }
        } while (choice != 3);
        scanner.close();
    }
    /* Tutor: Re-created this part because I'm not sure if this is correct based on the document provided
    private static void addBooking(Customers cust) {
        Scanner scanner = new Scanner(System.in);
        if (cust == null) {
            System.out.println("Customer with the phone number you have entered is not exist. Please try again");
        } else {
            System.out.print("Enter the date of booking(dd/mm/yyyy) : ");
            String date = scanner.nextLine();
            boolean booking_available = true;
            for (Booking b : bookings) {
                if (b.getDate().equals(date)) {
                    booking_available = false;
                    break;
                }
            }
            if (booking_available) {
         //services.txt file
                if (service == 1) {
                    Service s = new Service(101, "Repair", 1000);
                    Booking b = new Booking(date, "AZ" + cust.getCustomerID(), cust.getCustomerID(), cust.getFirstName() + " " + cust.getLastName(), cust.getAddress(), s.getName(), s.getId(), s.getPrice(), s.getPrice());
                    bookings.add(b);
                   System.out.println("Booking done for customer : " + cust.getFirstName() + " " + cust.getLastName());
                } else if (service == 2) {
                    Service s = new Service(102, "Service", 500);
                    Booking b = new Booking(date, "AZ" + cust.getCustomerID(), cust.getCustomerID(), cust.getFirstName() + " " + cust.getLastName(), cust.getAddress(), s.getName(), s.getId(), s.getPrice(), s.getPrice());
                    bookings.add(b);
                   System.out.println("Booking done for customer : " + cust.getFirstName() + " " + cust.getLastName());
                } else if (service == 3) {
                    Service s = new Service(103, "Installation", 1500);
                    Booking b = new Booking(date, "AZ" + cust.getCustomerID(), cust.getCustomerID(), cust.getFirstName() + " " + cust.getLastName(), cust.getAddress(), s.getName(), s.getId(), s.getPrice(), s.getPrice());
                    bookings.add(b);
                   System.out.println("Booking done for customer : " + cust.getFirstName() + " " + cust.getLastName());
                }
            } else {
               System.out.println("Booking not available for this date.");
            }
        }
   }
     */
    private static void addBooking(Customers cust) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (cust == null) {
            System.out.println("Customer with the phone number you have entered is not exist. Please try again");
        } else {
            System.out.print("Enter the date of booking(dd/mm/yyyy) : ");
            String date = scanner.nextLine();
            boolean booking_available = true;
            int booked = 0;
            for (Booking b : bookings) {
                if (b.getDate().equals(date) == true) { //Tutor: if booking date is available
                    booked++;
                    if (booked >= 5) //Tutor: ...and booked services are more than 5.
                    {
                        booking_available = false;
                        break;
                    }
                }
            }
            if (booking_available == true) { //Tutor: check if booking date is not weekend.
                Calendar c = Calendar.getInstance();
                String[] dateArr = date.split("/");
                c.set(Integer.parseInt(dateArr[2]), Integer.parseInt(dateArr[1]) - 1, Integer.parseInt(dateArr[0])); //Tutor: set new date
                String day = new SimpleDateFormat("EE", Locale.ENGLISH).format(c.getTime());
                if (day.equalsIgnoreCase("Sat") | day.equalsIgnoreCase("Fri")) {
                    booking_available = false;
                }
            }
            if (booking_available) {

                /*Tutor: Diplay service options for the user.*/
                for (int i = 0; i < services.size(); ++i) {
                    System.out.println("[" + (i + 1) + "] " + services.get(i).toString());
                }
                System.out.println("\nEnter type of service");
                int choice = scanner.nextInt(); //Tutor: added this part
                double price = 0;
                int s_id = 0;
                String name = null;
                if ((choice > 0) & (choice < (services.size() + 1))) {
                    price = services.get(choice - 1).price;
                    s_id = services.get(choice - 1).getId();
                    name = services.get(choice - 1).getName() + " - " + services.get(choice - 1).getDesc();
                    Booking b = new Booking(date, nextBookingId + "", cust.getCustomerID(), cust.getFirstName() + " " + cust.getLastName(), cust.getAddress(), s_id, name, price);
                    bookings.add(b);
                    updateBooking(date, b.customerId, price, s_id);
                    System.out.println("Booking done for customer : " + cust.getFirstName() + " " + cust.getLastName());
                } else {
                    System.err.println("Service not available");
                }
            } else {
                System.out.println("Booking not available for this date.");
            }
        }
    }
    public static void updateBooking(String date, String custId, double totalFee, int serviceCode) {
        try {
            String[] dateArr = date.split("/");
            FileWriter fw = new FileWriter(path + "Bookings-" + dateArr[2] + "-" + dateArr[1] + "-" + dateArr[0] + ".txt", true); //tutor: modify this to set an update is to be executed.
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nextBookingId + "," + custId + "," + (dateArr[0] + "/" + dateArr[1] + "/" + dateArr[2]) + "," + totalFee + "," + serviceCode);
            bw.newLine();
            bw.close();
            nextBookingId = nextBookingId + 1;
        } catch (Exception ex) {
            System.err.println("Unable to update file. " + ex.getMessage());
        }
    }
}