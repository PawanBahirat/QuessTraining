package Assignment_03_02_06_22;

import java.io.*;
import java.util.*;

public class AlternatePrimeNumbers {
    public static boolean isPrime(int num) {
        int iter = 2;
        boolean flag = true;
        while (num > iter) {
            if (num % iter == 0) {
                flag = false;
                break;
            }
            iter++;
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int num = scan.nextInt();
        System.out.print("Alternate prime numbers : ");
        int iter = 2;
        for(int i = 2; i<=num;i++) {
            if(isPrime(i)) {
                if(iter%2==0) System.out.print(i+" ");
                iter++;
            }
        }
    }

}
