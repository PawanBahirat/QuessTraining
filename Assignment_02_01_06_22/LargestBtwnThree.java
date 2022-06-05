package Assignment_02_01_06_22;

import java.util.*;
import java.io.*;

public class LargestBtwnThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n1 = sc.nextDouble();
        double n2 = sc.nextDouble();
        double n3 = sc.nextDouble();
        if( n1 >= n2 && n1 >= n3) System.out.println(n1 + " is the largest number.");
        else if (n2 >= n1 && n2 >= n3) System.out.println(n2 + " is the largest number.");
        else System.out.println(n3 + " is the largest number.");
    }
}
