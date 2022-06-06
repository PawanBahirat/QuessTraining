package Assignment_04_03_06_22;

import java.util.Scanner;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Row Size : ");
        int n = sc.nextInt();
        System.out.print("Enter Col Size : ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        System.out.println("Enter "+n*m+" Elements : ");
        int[][] newArr = new int[n][m];
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) arr[i][j] = sc.nextInt();
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) newArr[i][j] = arr[j][i];
        System.out.println("Transpose Of Matrix : ");
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
