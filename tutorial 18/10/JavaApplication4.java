package javaapplication4;

import java.util.Scanner;
import java.util.Random;

public class JavaApplication4 {

    // Your custom function that generates the random winning number (0 to 3)
    public static int YES() {
        Random rand = new Random();
        int HIM = rand.nextInt(4);
        return HIM;
    }

    public static void main(String[] args) {
        // Create the Scanner tool once
        Scanner input = new Scanner(System.in);

        System.out.print("Player X, place your bet (0-3): ");
        int x = input.nextInt();

        System.out.print("Player Y, place your bet (0-3): ");
        int y = input.nextInt();

        System.out.print("Player Z, place your bet (0-3): ");
        int z = input.nextInt();

        System.out.print("Player A, place your bet (0-3): ");
        int a = input.nextInt();

        // Call your YES function to get the random winning number
        int HIM = YES();

        System.out.println("\n--- The winning number was: " + HIM + " ---");

        // Check who won and print out all the winners/losers messages
        if (HIM == x) {
            System.out.println("TODAYSSSSSSSSSSS WINNER IS.........X HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........y HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........z HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........a HORRAYYYYYYY");
        } 
        else if (HIM == y) {
            System.out.println("TODAYSSSSSSSSSSS WINNER IS.........y HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........x HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........z HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........a HORRAYYYYYYY");
        } 
        else if (HIM == z) {
            System.out.println("TODAYSSSSSSSSSSS WINNER IS.........z HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........x HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........y HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........a HORRAYYYYYYY");
        } 
        else if (HIM == a) {
            System.out.println("TODAYSSSSSSSSSSS WINNER IS.........a HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........x HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........y HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........z HORRAYYYYYYY");
        } 
        else {
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........a HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........x HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........y HORRAYYYYYYY");
            System.out.println("TODAYSSSSSSSSSSS LOSER  IS.........z HORRAYYYYYYY");
        }

        input.close();
    }
}