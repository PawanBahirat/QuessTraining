package Assignment_03_02_06_22;

import java.io.*;
import java.util.Scanner;

public class TableUsingRec {
    public static void mul_table(int n, int i) {
        if (i > 10) return;
        System.out.println(n + " * " + i + " = " + n * i);
        mul_table(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();
        TableUsingRec.mul_table(n, 1);
    }
}
