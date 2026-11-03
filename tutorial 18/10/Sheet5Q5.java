import java.util.Scanner;

public class Sheet5Q5 {

    public static boolean isStrong(String pw) {
        if (pw.length() < 6) {
            return false;
        }
        char firstChar = pw.charAt(0);
        if (!Character.isUpperCase(firstChar)) {
            return false;
        }
        if (pw.indexOf('@') == -1) {
            return false;
        }
        return true;
    }

    public static String mask(String pw) {
        String masked = "";
        masked += pw.charAt(0);
        for (int i = 1; i < pw.length(); i++) {
            masked = masked.concat("*");
        }
        return masked;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] passwords = new String[4];

        System.out.print("Enter 4 passwords: ");
        for (int i = 0; i < passwords.length; i++) {
            passwords[i] = scanner.next();
        }

        for (int i = 0; i < passwords.length; i++) {
            String status = isStrong(passwords[i]) ? "Strong" : "Weak";
            String maskedPw = mask(passwords[i]);
            
            System.out.println("Password " + (i + 1) + ": " + status + " (" + maskedPw + ")");
        }
        
        scanner.close();
    }
}