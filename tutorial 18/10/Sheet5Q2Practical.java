import java.util.Scanner;

public class Sheet5Q2Practical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] students = new String[3][2];

        System.out.println("Enter name and grade for 3 students:");
        for (int i = 0; i < 3; i++) {
            students[i][0] = scanner.next(); 
            students[i][1] = scanner.next(); 
        }


        for (int i = 0; i < 3; i++) {
            String record = students[i][0].concat(": ").concat(students[i][1]);
            System.out.println(record);
        }


        int gradeACount = 0;
        for (int i = 0; i < 3; i++) {
            if (students[i][1].equalsIgnoreCase("A")) {
                gradeACount++;
            }
        }
        System.out.println("Students with grade A: " + gradeACount);


        System.out.print("Enter first letter: ");
        String prefix = scanner.next();
        int prefixCount = 0;
        
        for (int i = 0; i < 3; i++) {
            if (students[i][0].startsWith(prefix)) {
                prefixCount++;
            }
        }
        System.out.println("Names starting with " + prefix + ": " + prefixCount);

        scanner.close();
    }
}