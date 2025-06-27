public class Student {
    private int rollNumber;
    private String name;
    private double grade;

    public Student(int rollNumber, String name, double grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

    public int getRollNumber() { return rollNumber; }
    public String getName() { return name; }
    public double getGrade() { return grade; }

    public void setName(String name) { this.name = name; }
    public void setGrade(double grade) { this.grade = grade; }

    public String getGradeLetter() {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return String.format("Roll No: %d | Name: %s | Grade: %.2f (%s)",
                rollNumber, name, grade, getGradeLetter());
    }

    public String toCSV() {
        return rollNumber + "," + name + "," + grade;
    }

    public static Student fromCSV(String line) {
        String[] parts = line.split(",");
        return new Student(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2]));
    }
}
