import  java.io.*;
import java.util.*;

public class FirstNLastDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any 4 Digit Number : ");

        int n  = sc.nextInt();
        System.out.print("First and Last Digit Sum : "+ (n/1000 + n%10));
    }
}
