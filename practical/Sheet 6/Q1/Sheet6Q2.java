import java.util.Scanner;

class Location {
    // A)
    private double maxValue;
    private int column;

    // B)
    public double getMaxValue() {
        return maxValue;
    }

    public int getColumn() {
        return column;
    }

    // C)
    public void locateLargest(double[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        
        maxValue = values[0];
        column = 0;

        for (int i = 1; i < values.length; i++) {
            if (values[i] > maxValue) {
                maxValue = values[i];
                column = i;
            }
        }
    }
}

public class Sheet6Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the number of columns in the array: ");
        int size = scanner.nextInt();

        double[] array = new double[size];

        
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        
        Location loc = new Location();
        loc.locateLargest(array);

        
        System.out.println("The location of the largest element is " + 
                           loc.getMaxValue() + " at position (" + loc.getColumn() + ")");
        
        scanner.close();
    }
}