package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class XPowerY {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Base : ");
        int base = sc.nextInt();
        System.out.print("Enter Power : ");
        int power = sc.nextInt();
        int result = 1;
        for (power = 3; power != 0; power--) result = result * base;
        System.out.println("Result =  " + result);
    }
}
