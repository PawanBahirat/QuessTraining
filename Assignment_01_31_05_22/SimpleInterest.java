import java.io.*;
import java.util.*;

public class SimpleInterest {
    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount : ");
        float amt = sc.nextFloat();
        System.out.print("Enter Time period in year : ");
        float time = sc.nextFloat();

        System.out.println("Simple Interest is : " + ( amt * 7.5 * time )/100);
    }
}
