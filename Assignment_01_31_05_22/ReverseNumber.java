
import  java.io.*;
import java.util.*;
public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Three Digit Number : ");

        int n = sc.nextInt();
        System.out.println("Reversed Number is : "+n%10+""+((n/10)%10)+""+((n/10)/10)%10);
    }
}
