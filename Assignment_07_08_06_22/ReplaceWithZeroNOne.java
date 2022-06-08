package Assignment_07_08_06_22;

import java.util.*;

public class ReplaceWithZeroNOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
       String str = sc.next();
       String res = new String("");
       for(int i=0;i<str.length();i++){
           if(Character.getNumericValue(str.charAt(i)) < 5) res += 0;
           else res += 1;
       }
        System.out.println(res);
    }
}