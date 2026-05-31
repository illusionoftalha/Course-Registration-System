import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main entry point and login interface for the Course Registration System.
 * Allows students to enter their Name, ID, and select their Program to generate a timetable.
 */
public class RegistrationGUI extends JFrame {
    private JTextField nameField;
    private JTextField idField;
    private JComboBox<String> fieldComboBox;

    /**
     * Initializes the Registration User Interface.
     */
    public RegistrationGUI() {
        setTitle("University Course Registration");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        createUI();
    }

    /**
     * Builds and adds the GUI components to the main frame.
     */
    private void createUI() {
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        formPanel.add(idField);

        formPanel.add(new JLabel("Field of Study:"));
        String[] fields = {"Software Engineering", "BBA", "Computer Science", "Data Science", "Artificial Intelligence"};
        fieldComboBox = new JComboBox<>(fields);
        formPanel.add(fieldComboBox);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton enrollButton = new JButton("Enroll & View Timetable");
        enrollButton.addActionListener(new EnrollButtonListener());
        buttonPanel.add(enrollButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Action Listener for the Enrollment button.
     * Validates input fields and transitions to the Timetable window upon success.
     */
    private class EnrollButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText().trim();
            String id = idField.getText().trim();
            String field = (String) fieldComboBox.getSelectedItem();

            if (name.isEmpty() || id.isEmpty()) {
                JOptionPane.showMessageDialog(RegistrationGUI.this, 
                    "Please fill in all details.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!id.matches("[A-Za-z0-9-]+") || id.length() < 4) {
                JOptionPane.showMessageDialog(RegistrationGUI.this, 
                    "Invalid ID format. Must be at least 4 characters (letters, numbers, or dashes).", 
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = new Student(id, name, field);
            
            TimetableGUI timetableGUI = new TimetableGUI(student);
            timetableGUI.setVisible(true);
            
            dispose();
        }
    }

    /**
     * Main method to launch the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistrationGUI app = new RegistrationGUI();
            app.setVisible(true);
        });
    }
}
