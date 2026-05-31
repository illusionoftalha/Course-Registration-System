/**
 * Represents a student in the university system.
 * Keeps track of the student's ID, name, and their enrolled field of study.
 */
public class Student {
    private String studentId;
    private String name;
    private String field;

    /**
     * Constructs a new Student.
     *
     * @param studentId The unique student identification number.
     * @param name      The full name of the student.
     * @param field     The degree program or field of study (e.g., "Software Engineering").
     */
    public Student(String studentId, String name, String field) {
        this.studentId = studentId;
        this.name = name;
        this.field = field;
    }

    /**
     * @return The student's unique ID.
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * @return The student's full name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The student's enrolled field of study.
     */
    public String getField() {
        return field;
    }
}
