import  java.io.*;
import java.util.*;

public class ValidTriangle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Values : " );
        System.out.print("a = ");
        int a = sc.nextInt();
        System.out.print("b = ");
        int b = sc.nextInt();
        System.out.print("c = ");
        int c = sc.nextInt();

        System.out.println((a + b <= c || a + c <= b || b + c <= a) ? "Triangle is Not Valid." : "Triangle is Valid.");
    }
}
