package Assignment_04_03_06_22;

import java.io.*;
import java.util.*;

public class ReversArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" Elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.print("Reversed Array : ");
        for(int i=n-1;i>=0;i--) System.out.print(arr[i]+" ");
    }
}
