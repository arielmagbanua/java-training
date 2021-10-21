public class Student {
    private String name;
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * This method is used for comparing other student object.
     * This compares the mark.
     *
     *
     * @param o The other student object.
     * @return if current student and the other student has same mark then return true, otherwise return false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return mark == student.mark;
    }

    @Override
    public int hashCode() {
        return mark;
    }
}
