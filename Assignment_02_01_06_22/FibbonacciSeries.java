package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class FibbonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();
        int f = 0, s = 1;
        System.out.println("Fibonacci Series Upto " + n + ": ");
        while (f <= n) {
            System.out.print(f + ", ");
            int next = f + s;
            f = s;
            s = next;
        }
    }
}
