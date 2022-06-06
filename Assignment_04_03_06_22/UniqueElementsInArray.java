package Assignment_04_03_06_22;

import java.io.*;
import java.util.*;

public class UniqueElementsInArray {
    public static void unique(int arr[]) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            if (mp.containsKey(arr[i])) mp.put(arr[i], mp.get(arr[i]) + 1);
            else mp.put(arr[i], 1);

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) if(entry.getValue() == 1) cnt++;
        System.out.println("Total Unique elements : "+cnt);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" Elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        unique(arr);
    }
}
