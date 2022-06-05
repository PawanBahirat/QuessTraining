package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class PalindromeNumber {
    static int reverse(int n){
        int rev = 0;
        int rem;
        while(n>0){
            rem = n%10;
            rev = (rev*10) + rem;
            n = n/10;
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();
        System.out.println((n == reverse(n)) ? n + " is Palindrome" : n +" is not an Palindrome");
    }
}
