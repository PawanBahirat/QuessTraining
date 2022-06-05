package Assignment_02_01_06_22;

import java.util.*;

public class PrimeNumber1
{
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) if (n % i == 0) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();
        System.out.println(isPrime(n) ? n + " is Prime Number" : n +" is Not a Prime Number");
    }
}
