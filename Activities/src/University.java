import java.util.*;


/**
 * Represents a University with students and courses.
 * The university class will maintain an index of students and courses using Maps.
 *   - The keys for the students' map is the Student's ID
 *   - The keys for the courses' map is the Course's Code
 *
 * Your task in this class is to finish the constructor and implement the methods flagged with TODO.
 * I've moved all methods already implemented under the ones you have to implement.
 * You can re-organize the code if you want.
 */
public class University {
    private Map<Integer, SchoolStudent> studentBody;
    private Map<String, Course> availableCourses;
    private String universityName;
    private String universityMotto;


    public University(String universityName, String universityMotto) {
        this.universityName = universityName;
        this.universityMotto = universityMotto;
        studentBody = new HashMap<>();
        availableCourses = new HashMap<>();
    }

    /**
     * Adds a student to the university roster. Student's cannot be added twice.
     * @param schoolStudent the student to be added
     * @return true if the student was added, false if the student was already on the map
     */
    public boolean addStudent(SchoolStudent schoolStudent){
        if (this.studentBody.containsKey(schoolStudent.getIdNumber())) {
            // student already on the map therefore return false
            return false;
        }

        // add the student
        this.studentBody.put(schoolStudent.getIdNumber(), schoolStudent);
        return  true;
    }

    /**
     * Gets a student from the university
     * @param idNumber the student's ID.
     * @return the student object or null if not found
     */
    public SchoolStudent getStudent(int idNumber){
        return this.studentBody.get(idNumber);
    }

    /**
     * Returns a list containing all students from the university
     * You will have to work with maps and lists on this method.
     * Referer to the document on how to ITERATE over maps. You CANNOT use foreach directly with maps
     * What is the best List type to use? ArrayList or LinkedList? Why?
     *
     * @return A list of all students (the list will be empty if the university is empty)
     */
    public List<SchoolStudent> getStudents(){
        // Prepare the list of student. Use ArrayList since it provides constant time for search operation.
        // So generally it is faster or better at searching, storing, and accessing data.
        List<SchoolStudent> schoolStudents = new ArrayList<>();

        // Iterate over the map and add each student to the list
        for (Map.Entry<Integer, SchoolStudent> set : this.studentBody.entrySet()) {
            SchoolStudent schoolStudent = set.getValue();
            schoolStudents.add(schoolStudent);
        }

        return schoolStudents;
    }

    /**
     * Add a course to the courses offered by the university
     * @param course the course object to be added
     * @return true if the course was added, false if the course was already on the university
     */
    public boolean addCourse(Course course){
        if (this.availableCourses.containsKey(course.getCourseCode())) {
            // course was added already so return false
            return false;
        }

        // add the course
        this.availableCourses.put(course.getCourseCode(), course);
        return false;
    }


    /**
     * Adds a course as a pre-requisite to another course. Both courses must already exist
     * in the university's list of offered courses.
     * @param courseID the id of the course you want to add the pre-requisite to
     * @param preReqCourseID the id of the pre-requisite course
     * @return false if either the courseID or preReqCourseID are invalid, true after adding the pre-requisite
     */
    public boolean addRequisiteToCourse(String courseID, String preReqCourseID){
        if (this.availableCourses.containsKey(courseID) && this.availableCourses.containsKey(preReqCourseID)) {
            // both exist then add prerequisite course to the target course
            Course course = this.availableCourses.get(courseID);
            Course preRequisiteCourse = this.availableCourses.get(preReqCourseID);
            course.addPreRequisiteCourse(preRequisiteCourse);
        }

        // at this point either or both of the course does not exist therefore return false
        return false;
    }

    /**
     * Gets a course from the university
     * @param courseCode the course code.
     * @return the course object associated with the code or null if not found
     */
    public Course getCourse(String courseCode){
        return this.availableCourses.get(courseCode);
    }

    /**
     * Get a list containing all courses offered by the university.
     * You will have to work with maps and lists on this method.
     * Referer to the document on how to ITERATE over maps. You CANNOT use foreach directly with maps
     * What is the best List type to use? ArrayList or LinkedList? Why?
     *
     * @return the list of courses offered by the university
     */
    public List<Course> getCourses(){
        // Prepare the list of courses. Use ArrayList since it provides constant time for search operation.
        // So generally it is faster or better at searching, storing, and accessing data.
        List<Course> courses = new ArrayList<>();

        // Iterate over the map and add each student to the list
        for (Map.Entry<String, Course> set : this.availableCourses.entrySet()) {
            Course course = set.getValue();
            courses.add(course);
        }

        return courses;
    }

    /**
     * Enroll a student in a course IF the student has already passed the pre-requisites of the course.
     * Note to 1110 students: remember that students keep two lists of courses.
     *
     * The method should add the student to the course's list of students and add the course to to the student's
     * list of current courses.
     *
     * @param studentID the id of the student
     * @param courseCode the course code for enrollment.
     * @return false if studentID, courseCode are incorrect, false if the student does not have the pre-requisites
     *         true if the student was enrolled in the course.
     *
     * NOTE2: See how false is representing three different issues? Here the "modern" approach would be to use
     *        exceptions (throw an exception) for the wrong id and code problems.
     */
    public boolean enrollStudentInCourse(int studentID, String courseCode) throws Exception {
        // get the student
        SchoolStudent schoolStudent = this.getStudent(studentID);
        if (schoolStudent == null) {
            // invalid or incorrect student
            throw new Exception("Invalid Student with id=" + studentID);
        }

        // get the course
        Course course = this.getCourse(courseCode);
        if (course == null) {
            // invalid or incorrect student
            throw new Exception("Invalid Course with code=" + courseCode);
        }

        // get the prerequisites of the course
        List<Course> prerequisites = course.getPreRequisites();
        // get the previously enrolled courses of the student
        List<Course> previouslyEnrolledCourses = schoolStudent.getPreviousCourses();
        // check if all prerequisites are previously enrolled
        if (!previouslyEnrolledCourses.containsAll(prerequisites)) {
            // not all prerequisites are previously enrolled
            throw new Exception("Not all prerequisites were previously enrolled.");
        }

        // enroll the student
        course.addStudentToCourse(schoolStudent);
        // add the course to the student
        schoolStudent.enrollInCourse(course);

        // return true since student was successfully enrolled
        return true;
    }

    /**
     * Removes a student from a course IF the student is already enrolled in it.
     * @param studentID the student ID
     * @param courseCode the course code
     * @return false if studentID, courseCode are incorrect, false if the student is not enrolled in the course
     *        true if the student was removed from the course.
     */
    public boolean removeStudentFromCourse(int studentID, String courseCode) throws Exception {
        // get the student
        SchoolStudent schoolStudent = this.getStudent(studentID);
        if (schoolStudent == null) {
            // invalid or incorrect student
            throw new Exception("Invalid Student with id=" + studentID);
        }

        // get the course
        Course course = this.getCourse(courseCode);
        if (course == null) {
            // invalid or incorrect student
            throw new Exception("Invalid Course with code=" + courseCode);
        }

        List<SchoolStudent> enrolledSchoolStudents = course.getEnrolledStudents();
        if (!enrolledSchoolStudents.contains(schoolStudent)) {
            // student was not enrolled
            throw new Exception("The student with an id=" + schoolStudent + ", is not enrolled.");
        }

        // remove the student
        course.removeStudent(schoolStudent);
        // remove the course from the student
        schoolStudent.removeCourse(course);

        return true;
    }


    /**
     * Removes a student from the university.
     * The student will be removed from the university index AND from the list of students of every course that the
     * student was already enrolled.
     *
     * There are a couple of ways to solve this method. If you iterate over the student's own courses,
     *  you have to be careful not to change the collection while you are iterating (unless you remove with the iterator)
     *
     * @param studentID the id of the student to remove
     * @return false if the studentID is not in the index. True if the student was removed from the index and courses
     */
    public boolean removeStudentFromUniversity(int studentID){
        // get the student
        if (!this.studentBody.containsKey(studentID)) {
            // student does not exist
            return false;
        }

        // remove the student
        SchoolStudent schoolStudent = this.studentBody.remove(studentID);

        // remove the student from the courses
        for (Course course : this.getCourses()) {
            course.removeStudent(schoolStudent);
        }

        return true;
    }

    /**
     * Removes a course from the university.
     * This method should remove the course from the university offered courses
     *     AND from each student's current courses.
     *
     * The method must remove the course from any other courses that have it as a pre-requisite
     *
     * @param courseCode the course code
     * @return false if the course code does not match any offered course. True after the course was removed
     */
    public boolean removeCourseFromUniversity(String courseCode){
        // get the course
        if (!this.availableCourses.containsKey(courseCode)) {
            // course does not exist
            return false;
        }

        // remove the course
        Course removedCourse = this.availableCourses.remove(courseCode);

        // remove the course from each student
        for (SchoolStudent schoolStudent : this.getStudents()) {
            schoolStudent.removeCourse(removedCourse);
        }

        // remove the course as prerequisite
        for (Course course : this.getCourses()) {
            course.removePreRequisiteCourse(removedCourse);
        }

        return true;
    }


    public String getUniversityMotto() {
        return universityMotto;
    }

    public String getUniversityName() {
        return universityName;
    }

    /**
     * Add a new student using name and ID
     * @param name the student's name
     * @param studentID the student's ID between 0 and 999999
     * @return true if the student was added, false if the student was already on the university
     */
    public boolean addStudent(String name, int studentID){
        return addStudent(new SchoolStudent(name,studentID));
    }

    public boolean addCourse(String name, String courseID){
        return addCourse(new Course(name,courseID));
    }



    @Override
    public String toString() {
        return String.format("%s (%s)\nNumber of Students: %d\nNumber of Courses %d",
                universityName,universityMotto,studentBody.size(),availableCourses.size());
    }
}
