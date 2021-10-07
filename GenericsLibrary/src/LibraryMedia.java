public abstract class LibraryMedia implements Media {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private String name;
    private String borrower;
    private String outDate;
    private String dueDate;

    public LibraryMedia(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String checkOutStatus() {
        String borrower = getBorrower() == null ? "" : getBorrower();
        String outDateStr = getOutDate() == null ? "" : getOutDate();
        String dueDateStr = getDueDate() == null ? "" : getDueDate();

        boolean hasValidDates = (!outDateStr.isEmpty() && !dueDateStr.isEmpty());

        if (!borrower.isEmpty() && hasValidDates) {
            return String.format("Borrower: %s \n Out date: %s \n Due date: %s", borrower, outDateStr, dueDateStr);
        }

        return null;
    }

    /**
     * This interface will check out the media with certain username.
     *
     * @param userName The username of the one who borrowed the media.
     * @param outDate The date where the media was checked out.
     * @param dueDate The return date of the media.
     */
    @Override
    public void checkOutTo(String userName, String outDate, String dueDate) {
        borrower = userName;
        this.outDate = outDate;
        this.dueDate = dueDate;
    }

    /**
     * The checks in the media.
     */
    @Override
    public void checkIn() {
        // this media will be checked in therefore unset the borrower, outDate, and the dueDate.
        borrower = null;
        outDate = null;
        dueDate = null;
    }

    /**
     * The string representation of this media.
     *
     * @return string value
     */
    @Override
    public String toString() {
        return getName();
    }
}
