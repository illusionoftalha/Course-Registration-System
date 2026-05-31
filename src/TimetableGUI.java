import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * The Graphical User Interface that displays the generated timetable for a specific student.
 * Provides functionality to view the schedule, calculate total credits, and export the timetable to a text file.
 */
public class TimetableGUI extends JFrame {
    private Student student;
    private ArrayList<Course> courses;

    /**
     * Initializes the Timetable window for the specified student.
     *
     * @param student The student object containing their details and chosen field.
     */
    public TimetableGUI(Student student) {
        this.student = student;
        this.courses = generateCoursesForField(student.getField());

        setTitle("Timetable - " + student.getField());
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        createUI();
    }

    /**
     * Generates a predefined list of courses based on the chosen academic program.
     *
     * @param field The academic program chosen by the student.
     * @return An ArrayList of Course objects tailored to the selected field.
     */
    private ArrayList<Course> generateCoursesForField(String field) {
        ArrayList<Course> list = new ArrayList<>();
        switch (field) {
            case "Software Engineering":
                list.add(new Course("SE101", "Intro to Software Engineering", "Mon/Wed 08:30 AM", 3, "Dr. Smith", "Room 301"));
                list.add(new Course("CS101", "Programming Fundamentals", "Tue/Thu 10:00 AM", 4, "Dr. Turing", "Lab A"));
                list.add(new Course("MATH101", "Calculus I", "Fri 09:00 AM", 3, "Prof. Gauss", "Room 205"));
                list.add(new Course("ENG101", "English Composition", "Mon/Wed 11:30 AM", 2, "Dr. Johnson", "Room 102"));
                break;
            case "BBA":
                list.add(new Course("MGT101", "Principles of Management", "Mon/Wed 09:00 AM", 3, "Dr. Adams", "Room 401"));
                list.add(new Course("ACC101", "Financial Accounting", "Tue/Thu 11:30 AM", 3, "Prof. Clark", "Room 402"));
                list.add(new Course("ECO101", "Microeconomics", "Fri 10:00 AM", 3, "Dr. Keynes", "Room 405"));
                list.add(new Course("ENG101", "Business English", "Mon/Wed 02:00 PM", 2, "Dr. Johnson", "Room 102"));
                break;
            case "Computer Science":
                list.add(new Course("CS101", "Programming Fundamentals", "Tue/Thu 10:00 AM", 4, "Dr. Turing", "Lab A"));
                list.add(new Course("CS102", "Digital Logic Design", "Mon/Wed 01:00 PM", 4, "Dr. Boole", "Lab B"));
                list.add(new Course("MATH101", "Calculus I", "Fri 09:00 AM", 3, "Prof. Gauss", "Room 205"));
                list.add(new Course("PHY101", "Applied Physics", "Tue/Thu 02:30 PM", 3, "Dr. Newton", "Room 304"));
                break;
            case "Data Science":
                list.add(new Course("DS101", "Intro to Data Science", "Mon/Wed 10:00 AM", 3, "Dr. Patil", "Room 501"));
                list.add(new Course("CS101", "Programming Fundamentals", "Tue/Thu 10:00 AM", 4, "Dr. Turing", "Lab A"));
                list.add(new Course("STAT101", "Probability & Statistics", "Fri 11:00 AM", 3, "Prof. Bayes", "Room 208"));
                list.add(new Course("MATH101", "Calculus I", "Fri 09:00 AM", 3, "Prof. Gauss", "Room 205"));
                break;
            case "Artificial Intelligence":
                list.add(new Course("AI101", "Intro to Artificial Intelligence", "Mon/Wed 02:00 PM", 3, "Dr. McCarthy", "Room 601"));
                list.add(new Course("CS101", "Programming Fundamentals", "Tue/Thu 10:00 AM", 4, "Dr. Turing", "Lab A"));
                list.add(new Course("MATH101", "Calculus I", "Fri 09:00 AM", 3, "Prof. Gauss", "Room 205"));
                list.add(new Course("ENG101", "English Composition", "Mon/Wed 11:30 AM", 2, "Dr. Johnson", "Room 102"));
                break;
            default:
                list.add(new Course("GEN101", "General Studies", "TBD", 3, "TBD", "TBD"));
                break;
        }
        return list;
    }

    /**
     * Constructs the primary layout for the timetable interface, including headers, 
     * a data table representing the schedule, and footer action buttons.
     */
    private void createUI() {
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.setBackground(new Color(220, 240, 255));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel welcomeLabel = new JLabel("Welcome, " + student.getName() + " (" + student.getStudentId() + ")", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JLabel fieldLabel = new JLabel("Enrolled Program: " + student.getField(), SwingConstants.CENTER);
        fieldLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        topPanel.add(welcomeLabel);
        topPanel.add(fieldLabel);

        add(topPanel, BorderLayout.NORTH);

        String[] columnNames = {"Code", "Course Name", "Credits", "Professor", "Room", "Time Slot"};
        String[][] data = new String[courses.size()][6];
        
        int totalCredits = 0;

        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            data[i][0] = c.getCourseCode();
            data[i][1] = c.getCourseName();
            data[i][2] = String.valueOf(c.getCredits());
            data[i][3] = c.getProfessor();
            data[i][4] = c.getRoom();
            data[i][5] = c.getSchedule();
            
            totalCredits += c.getCredits();
        }

        JTable table = new JTable(data, columnNames);
        table.setEnabled(false); 
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel creditLabel = new JLabel("Total Credits: " + totalCredits);
        creditLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(creditLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton exportButton = new JButton("Save Timetable");
        exportButton.addActionListener(e -> exportTimetable());
        
        JButton logoutButton = new JButton("Start Over");
        logoutButton.addActionListener(e -> {
            RegistrationGUI regGui = new RegistrationGUI();
            regGui.setVisible(true);
            dispose();
        });
        
        buttonPanel.add(exportButton);
        buttonPanel.add(logoutButton);
        
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);
    }
    
    /**
     * Exports the generated timetable to a formatted text file.
     * Uses File I/O classes to write the output to the disk in the current directory.
     */
    private void exportTimetable() {
        String filename = student.getName().replaceAll("\\s+", "_") + "_Timetable.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=========================================");
            writer.println("       UNIVERSITY TIMETABLE RECEIPT      ");
            writer.println("=========================================");
            writer.println("Student Name: " + student.getName());
            writer.println("Student ID:   " + student.getStudentId());
            writer.println("Program:      " + student.getField());
            writer.println("-----------------------------------------");
            writer.println(String.format("%-8s %-30s %-8s %-20s %-10s %-20s", "Code", "Course Name", "Credits", "Professor", "Room", "Time"));
            writer.println("-----------------------------------------");
            
            int total = 0;
            for (Course c : courses) {
                writer.println(String.format("%-8s %-30s %-8d %-20s %-10s %-20s", 
                    c.getCourseCode(), c.getCourseName(), c.getCredits(), c.getProfessor(), c.getRoom(), c.getSchedule()));
                total += c.getCredits();
            }
            writer.println("-----------------------------------------");
            writer.println("Total Credit Hours: " + total);
            writer.println("=========================================");
            
            JOptionPane.showMessageDialog(this, 
                "Timetable saved successfully to " + filename, 
                "Export Success", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error saving timetable: " + ex.getMessage(), 
                "Export Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
