package Assignment_04_03_06_22;

import java.io.*;
import java.util.*;

public class DuplicatesInArray {
    public static int duplicate(int numbers[]) {
        int cnt = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean flag = false;
            int j = 0;
            while (j < i) {
                if ((i != j) && numbers[i] == numbers[j]) flag = true;
                j++;
            }
            if (flag) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" Elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Total Duplicates : "+duplicate(arr));
    }
}
