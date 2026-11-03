

package javaapplication80;
import java.util.Scanner;

public class JavaApplication80 {

    
    public static void main(String[] args) {
Scanner x = new Scanner (System.in);
System.out.println( "enter a positive number : ");
     int n = x.nextInt();
     if ( n == 0){
System.out.println( " 1");
     }
     else 
     {
         while ( n>0)
         {
             int i =1;
             n = n*i;
             if ( i<=n)
                 i++;
         }
         System.out.println(" factorial of this number is : " + n);




     }
    
    }
    
}
