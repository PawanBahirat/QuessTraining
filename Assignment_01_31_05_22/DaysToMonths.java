import java.io.*;
import java.util.*;

public class DaysToMonths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Days : ");
        int n = sc.nextInt();
        System.out.println("Output : " + n/30 + " Month and " + n%30 + " days");
    }
}
