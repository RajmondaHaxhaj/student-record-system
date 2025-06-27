# Student Management System with Login and Grade Classification

A console-based Java application to manage student data using Object-Oriented Programming, file handling (CSV), and featuring:

- Admin login system with username and password authentication.
- Add, view, search, update, and delete student records.
- Grade classification (A, B, C, D, F) based on numeric grades.
- Persistent storage using a CSV file (`students.csv`).

## Features

- Simple text-based menu interface.
- Input validation for numeric fields.
- Stores data between program runs.
- Grade classification displayed alongside numeric grade.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed.
- Basic command line knowledge.

### Files Included

- `Student.java` — Student class with grade classification.
- `StudentStorage.java` — Handles loading and saving students to CSV file.
- `AuthSystem.java` — Simple admin login system.
- `StudentManager.java` — Main application logic with menu.

### How to Compile and Run

1. Open your terminal/command prompt.
2. Navigate to the project folder containing all `.java` files.
3. Compile all Java files:
    ```
    javac *.java
    ```
4. Run the program:
    ```
    java StudentManager
    ```
5. Login with credentials:
    - Username: `admin`
    - Password: `1234`

## Usage

After login, use the menu to:

1. Add new students.
2. View all students.
3. Search a student by roll number.
4. Update student information.
5. Delete a student record.
6. Save and exit the program.

Grades will be shown with letter classification, for example:  
`Roll No: 101 | Name: Alice | Grade: 85.50 (B)`

## Notes

- The student data is saved in a file called `students.csv` in the project folder.
- Modify the username and password in `AuthSystem.java` as needed.



---

Made with Java 💻
