package javaapplication4;

import java.util.Scanner;

public class Sheet3Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (0 to stop): ");
        int num = scanner.nextInt();
        int max = num;

        while (num != 0) {
            if (num > max) {
                max = num;
            }
            System.out.print("Enter a positive integer (0 to stop): ");
            num = scanner.nextInt();
        }

        System.out.println("The largest number entered is: " + max);
        scanner.close();
    }
}
