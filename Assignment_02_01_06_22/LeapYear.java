package Assignment_02_01_06_22;

import java.io.*;
import java.util.*;

public class LeapYear {
    public static void main(String[] args) {
        int year;
        Scanner scn = new Scanner(System.in);
        year = scn.nextInt();
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) System.out.println(year + " : Leap Year");
        else System.out.println(year + " : Non - Leap Year");

    }
}
