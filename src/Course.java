/**
 * Represents a single university course.
 * Contains standard details such as course code, name, schedule, credits,
 * assigned professor, and room number.
 */
public class Course {
    private String courseCode;
    private String courseName;
    private String schedule;
    private int credits;
    private String professor;
    private String room;

    /**
     * Constructs a new Course with the given details.
     *
     * @param courseCode The unique identifier for the course (e.g., CS101).
     * @param courseName The full name of the course.
     * @param schedule   The time and days the course takes place.
     * @param credits    The number of credit hours for this course.
     * @param professor  The name of the professor teaching the course.
     * @param room       The physical or virtual room assignment.
     */
    public Course(String courseCode, String courseName, String schedule, int credits, String professor, String room) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.schedule = schedule;
        this.credits = credits;
        this.professor = professor;
        this.room = room;
    }

    /**
     * @return The unique course code.
     */
    public String getCourseCode() { return courseCode; }

    /**
     * @return The full name of the course.
     */
    public String getCourseName() { return courseName; }

    /**
     * @return The schedule of the course.
     */
    public String getSchedule() { return schedule; }

    /**
     * @return The credit hours awarded for completing the course.
     */
    public int getCredits() { return credits; }

    /**
     * @return The name of the professor.
     */
    public String getProfessor() { return professor; }

    /**
     * @return The room assignment for the course.
     */
    public String getRoom() { return room; }

    /**
     * Returns a string representation of the course.
     *
     * @return Formatted string containing course code, name, and schedule.
     */
    @Override
    public String toString() {
        return courseCode + " - " + courseName + " (" + schedule + ")";
    }
}
