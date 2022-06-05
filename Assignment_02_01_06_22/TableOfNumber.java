package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class TableOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) System.out.println(n + " * " + i + " = " + n * i);
    }

}
