package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class SumOfDigit {
    public static int sum(int n, int sum) {
        if(n < 10) return sum+n;
        sum += n %10;
        n = n / 10;
        return sum(n , sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sum(n,0));
    }
}
