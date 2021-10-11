// Booking class to store the data of all the bookings
import java.util.ArrayList;

public class Booking {

    //Tutor: suggest to make the variables private since getter() and setter() functions are available.
    String date;
    String bookingId;
    String customerId;
    String customerName;
    String address;
    String serviceName;
    //int serviceCode;
    double servicePrice;
    int totalFee;
    ArrayList<Integer> serviceCodes = new ArrayList<Integer>(); //Tutor: added this declaraction

    //Default Constructor
    public Booking() {
    }

    //Tutor: modified this.
    public Booking(String date, String bookingId, String customerId, String customerName, String address,
                   int serviceCode, String serviceName, double servicePrice) {
        this.date = date;
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.serviceName = serviceName;
        serviceCodes.add(serviceCode);
        this.servicePrice = servicePrice;
        //this.totalFee = totalFee;
    }


    /* Tutor: added this constructor */
    public Booking(String bookingId, String customerId, String date, int totalFee, ArrayList serviceCodes) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.date = date;
        this.totalFee = totalFee;
        this.serviceCodes = serviceCodes;
    }

    public ArrayList<Integer> getServiceCodes() {
        return serviceCodes;
    }

    public void setServiceCodes(ArrayList<Integer> serviceCodes) {
        this.serviceCodes = serviceCodes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public String show() {
        String string = "Booking Detail : \nDate : " + date + "\nBooking ID : " + bookingId
                + "\nCustomer ID : " + customerId + "\nCustomer Name : " + customerName
                + "\nAddress : " + address + "\nService : " + serviceName + "\nService Code : " + serviceCodes.toString() //Tutor: modified to 'serviceCodes'.
                + "\nPrice : " + servicePrice + "\nTotal Fee : " + totalFee + "\n";
        return string;
    }

    public String print() {
        String string = "Booking Detail : \nDate : " + date + "\nBooking ID : " + bookingId
                + "\nCustomer ID : " + customerId + "\nCustomer Name : " + customerName
                + "\nService Code : " + serviceCodes.toString() + "\n"; //Tutor: modified to 'serviceCodes'.
        return string;
    }

    public void changeFeePrice(int newFee) {
        if (newFee >= (totalFee - 0.1 * totalFee) && newFee <= totalFee) {
            setTotalFee(newFee);
        } else {
            System.out.println("This fee price is not valid.");
        }
    }

    @Override
    public String toString() {
        return date + "," + bookingId + "," + customerId + "," + customerName + "," + address + "," + serviceName + "," + serviceCodes.toString() + "," + servicePrice + "," + totalFee;
    }

}