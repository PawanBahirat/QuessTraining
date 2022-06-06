package Assignment_04_03_06_22;

import java.util.Scanner;
import java.io.*;

public class NthPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();

        int num=1, count=0, i;

        while (count < n) {
            num=num+1;
            for (i = 2; i <= num; i++)if (num % i == 0) break;
            if ( i == num) count = count+1;
        }
        System.out.println(n +"th prime is : " + num);
    }
}
