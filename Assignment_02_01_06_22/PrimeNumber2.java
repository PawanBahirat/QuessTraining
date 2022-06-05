package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class PrimeNumber2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Lower value : ");
        int l = sc.nextInt();
        System.out.print("Enter Higher Value : ");
        int h = sc.nextInt();

        while (l < h) {
            boolean flag = false;
            for(int i = 2; i <= l/2; ++i)
                if(l % i == 0) {
                    flag = true;
                    break;
                }

            if (!flag)
                System.out.print(l + " ");
            ++l;
        }
    }
}
