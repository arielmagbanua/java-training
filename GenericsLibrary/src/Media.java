interface Media {
    String checkOutStatus();
    void checkOutTo(String userName , String outDate, String dueDate);
    void checkIn();
}
