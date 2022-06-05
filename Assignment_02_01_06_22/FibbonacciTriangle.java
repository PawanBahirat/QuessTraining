package Assignment_02_01_06_22;

import java.util.*;
import java.io.*;

public class FibbonacciTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Limit : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int a = 0, b = 1;
            System.out.print("  "+b);
            for (int j = 1; j < i; j++) {
                int c = a + b;
                System.out.print("  "+c);
                a = b;
                b = c;
            }
            System.out.println();
        }

    }
}
