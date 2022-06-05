import java.io.*;
import java.util.*;

public class GretrNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers : ");
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.print("c = ");
        int c = sc.nextInt();

        System.out.println((a>b) ? (a>c ? a:c) : (b>c ? b:c));
    }
}
