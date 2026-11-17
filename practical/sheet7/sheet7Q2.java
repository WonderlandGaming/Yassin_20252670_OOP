package sheet7;

import java.util.Scanner;

class Student {
    
    private String studentName;
    private String studentID;
    private double grade;

    
    public Student() {
        this.studentName = "Unknown";
        this.studentID = "0000";
        this.grade = 0.0;
    }

    
    public Student(String studentName, String studentID, double grade) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.grade = grade;
    }

    
    public void updateGrade(double newGrade) {
        this.grade= newGrade;
    }

    
    public boolean isPassed() {
        return grade >= 50;
    }

    
    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public double getGrade() {
        return grade;
    }
}

public class sheet7Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        input.nextLine(); 

        Student[] students = new Student[numStudents];

        
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("ID: ");
            String id = input.nextLine();

            System.out.print("Grade: ");
            double grade = input.nextDouble();
            input.nextLine(); 

            students[i] = new Student(name, id, grade);
        }

        
        System.out.print("\nEnter the index of the student to update (0 to " + (numStudents - 1) + "): ");
        int index = input.nextInt();

        if (index >= 0 && index < numStudents) {
            System.out.print("Enter the new grade: ");
            double newGrade = input.nextDouble();
            students[index].updateGrade(newGrade);
            System.out.println("Grade updated successfully.");
        } else {
            System.out.println("Invalid index! No grade updated.");
        }

        
        System.out.println("\n--- All Students Information ---");
        for (int i = 0; i < numStudents; i++) {
            String status = students[i].isPassed() ? "Passed" : "Failed";
            System.out.println("Index [" + i + "] | Name: " + students[i].getStudentName()
                    + " | ID: " + students[i].getStudentID()
                    + " | Grade: " + students[i].getGrade()
                    + " | Status: " + status);
        }

        input.close();
    }
}