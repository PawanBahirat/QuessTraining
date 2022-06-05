package Assignment_02_01_06_22;

import java.util.Scanner;

public class ArmstrongNumber1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.print("Enter Any Number : ");
        int number = n, res = 0;
        while (number != 0) {
            int temp = number % 10;
            res += (temp*temp*temp);
            number /= 10;
        }
        System.out.println(n + ((res == n) ? " is an Armstrong number." : " is not an Armstrong number"));
    }
}
