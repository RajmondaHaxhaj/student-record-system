import java.util.*;

public class StudentManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Student> students = StudentStorage.loadStudents();

    public static void main(String[] args) {
        if (!AuthSystem.login()) return;

        int choice;
        do {
            showMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    StudentStorage.saveStudents(students);
                    System.out.println("Exiting... Data saved.");
                }
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\n--- Student Management System ---");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by Roll Number");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Save and Exit");
    }

    private static void addStudent() {
        int roll = readInt("Enter Roll Number: ");
        if (findStudent(roll) != null) {
            System.out.println("Student already exists.");
            return;
        }
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        double grade = readDouble("Enter Grade: ");
        students.add(new Student(roll, name, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private static void searchStudent() {
        int roll = readInt("Enter Roll Number: ");
        Student s = findStudent(roll);
        System.out.println(s != null ? s : "Student not found.");
    }

    private static void updateStudent() {
        int roll = readInt("Enter Roll Number to update: ");
        Student s = findStudent(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter new name (or press Enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isBlank()) s.setName(name);

        String gradeInput;
        System.out.print("Enter new grade (or press Enter to keep current): ");
        gradeInput = scanner.nextLine();
        if (!gradeInput.isBlank()) {
            try {
                double grade = Double.parseDouble(gradeInput);
                s.setGrade(grade);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grade input. Grade not changed.");
            }
        }
        System.out.println("Student updated.");
    }

    private static void deleteStudent() {
        int roll = readInt("Enter Roll Number to delete: ");
        Student s = findStudent(roll);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(s);
        System.out.println("Student deleted.");
    }

    private static Student findStudent(int roll) {
        return students.stream().filter(s -> s.getRollNumber() == roll).findFirst().orElse(null);
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid decimal number. Try again.");
            }
        }
    }
}
