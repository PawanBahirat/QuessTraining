package Assignment_02_01_06_22;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number : ");
        int n = sc.nextInt();

        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                System.out.print(c + " ");
                n /= c;
            }
            else c++;
        }
    }
}
