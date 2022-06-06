package Assignment_04_03_06_22;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class ArrayCopy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int n = sc.nextInt();
        int[] src = new int[n];
        int[] dest = new int[src.length];
        System.out.print("Enter Source Array Elements : ");
        for (int i=0;i<n;i++) src[i] = sc.nextInt();
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println("Destination Array : "+Arrays.toString(dest));
    }

}
