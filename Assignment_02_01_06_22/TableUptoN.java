package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class TableUptoN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(" "+i * j );
            }
            System.out.println();
        }
    }
}
