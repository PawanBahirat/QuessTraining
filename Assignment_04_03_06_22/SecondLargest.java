package Assignment_04_03_06_22;

import java.util.Scanner;

public class SecondLargest {
    public static int secondLargest(int[] arr){
        int max = Integer.MIN_VALUE;
        int secMax = -1;

        for (int i=0;i<arr.length;i++) max = Math.max(arr[i], max);
        for (int i=0;i<arr.length;i++) if(arr[i] != max) secMax = Math.max(secMax, arr[i]);
        return secMax;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter "+n+" Elements : ");
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(secondLargest(arr));
    }
}
