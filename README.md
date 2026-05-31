# University Course Registration System

A streamlined Java application for university students to register for their desired degree program and instantly generate a formatted timetable. Developed with a focus on simplicity, object-oriented principles, and clean UI design using Java Swing.

## 🚀 Features

- **Program Selection**: Choose between Software Engineering, BBA, Computer Science, Data Science, and AI.
- **Dynamic Timetables**: Generates a complete schedule based on the selected program.
- **Real-World Attributes**: Course tables show credits, professor names, and room numbers.
- **Credit Calculation**: Automatically sums up and displays the total credit hours.
- **File Export (I/O)**: Save the generated timetable as a `.txt` receipt to your local machine!
- **Data Validation**: Built-in logic to ensure student IDs are valid and not blank.

## 📂 Project Structure

This project follows the standard Java project structure:
- `/src` - Contains all `.java` source code files.
- `/bin` - Contains the compiled `.class` bytecode files.

## 🛠️ How to Compile & Run

You must have the Java Development Kit (JDK) installed on your machine.

1. **Compile the Source Code**:
   Open a terminal in the root directory of the project and run:
   ```bash
   javac -d bin src/*.java
   ```
2. **Run the Application**:
   Execute the compiled GUI class from the bin folder:
   ```bash
   java -cp bin RegistrationGUI
   ```

## 📸 Usage Example
1. Enter your Name and Student ID (must be at least 4 characters).
2. Select your desired Field of Study.
3. Click "Enroll & View Timetable".
4. Review your generated schedule and click "Save Timetable" to export a text file receipt!
