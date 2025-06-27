import java.io.*;
import java.util.*;

public class StudentStorage {
    private static final String FILE_NAME = "students.csv";

    public static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return list;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Student.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading students: " + e.getMessage());
        }
        return list;
    }

    public static void saveStudents(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}
