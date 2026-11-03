import java.util.Scanner;

public class Sheet5Q1Practical {

    public static int generateSecret() {
        return (int) (Math.random() * 50) + 1;
    }

    public static String checkGuess(int guess, int secret) {
        if (guess == secret) {
            return "Correct";
        } else if (guess > secret) {
            return "Lower";
        } else {
            return "Higher";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secret = generateSecret();
        int[] guesses = new int[5];
        boolean won = false;

        for (int i = 0; i < 5; i++) {
            System.out.print("Guess: ");
            int guess = scanner.nextInt();
            guesses[i] = guess;

            String result = checkGuess(guess, secret);

            if (result.equals("Correct")) {
                System.out.println("Correct in " + (i + 1) + " attempts");
                won = true;
                break;
            } else {
                System.out.println(result);
            }
        }

        if (!won) {
            System.out.println("The secret number was: " + secret);
        }

        scanner.close();
    }
}