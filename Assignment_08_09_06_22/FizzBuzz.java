package Assignment_08_09_06_22;

import java.io.*;
import java.util.*;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number : ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            if (i%15 == 0)  System.out.println("FizzBuzz");
            else if (i%5 == 0) System.out.println("Buzz");
            else if (i%3 == 0) System.out.println("Fizz");
            else System.out.println(i);
        }
    }
}
