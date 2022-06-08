package Assignment_07_08_06_22;

import java.io.*;
import java.util.*;

public class HighestScoringWord {
    public static String hsw(String str) {
        String res = "";
        int max = 0;

        for (String w : str.split(" ")) {
            int wt = 0;
            for (char c : w.toCharArray()) wt += c - 96;
            if (wt > max) {
                max = wt;
                res = w;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        System.out.print("Highest Scoring Word is : "+ hsw(str));
    }
}
