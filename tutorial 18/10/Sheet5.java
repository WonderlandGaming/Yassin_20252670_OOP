import java.util.Scanner;

public class Sheet5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sales = new int[7];
        int total = 0;
        int countGreaterThan20 = 0;

        System.out.print("Enter sales of 7 days: ");
        for (int i = 0; i < sales.length; i++) {
            sales[i] = scanner.nextInt();
            total += sales[i];
            
            if (sales[i] > 20) {
                countGreaterThan20++;
            }
        }

        double average = (double) total / sales.length;
        long roundedAverage = Math.round(average);

        System.out.println("Total: " + total);
        System.out.println("Days greater than 20: " + countGreaterThan20);
        System.out.println("Average: " + roundedAverage);
        
        scanner.close();
    }
}