package p1;

import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String grade;

    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student { " +
                "ID: " + id +
                ", Name: '" + name + '\'' +
                ", Age: " + age +
                ", Grade: '" + grade + '\'' +
                " }";
    }
}

public class StudentManagementApp {
    private static Map<Integer, Student> studentData = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Create New Student Data");
            System.out.println("2. Read All Student Data");
            System.out.println("3. Read Student Data by ID");
            System.out.println("4. Update Student by ID");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    readAllStudents();
                    break;
                case 3:
                    readStudentById();
                    break;
                case 4:
                    updateStudentById();
                    break;
                case 5:
                    deleteStudentById();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice..");
            }
        }
    }

    private static void createStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        if (studentData.containsKey(id)) {
            System.out.println("Student with this ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();

        studentData.put(id, new Student(id, name, age, grade));
        System.out.println("Student created successfully!");
    }

    private static void readAllStudents() {
        if (studentData.isEmpty()) {
            System.out.println("No student data available.");
        } else {
            System.out.println("--- All Student Data ---");
            for (Student student : studentData.values()) {
                System.out.println(student);
            }
        }
    }

    private static void readStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        Student student = studentData.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Student student = studentData.get(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter New Grade: ");
        String grade = scanner.nextLine();

        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        System.out.println("Student updated successfully!");
    }

    private static void deleteStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        if (studentData.remove(id) != null) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}

