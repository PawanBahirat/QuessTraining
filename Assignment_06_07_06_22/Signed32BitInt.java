package Assignment_06_07_06_22;

import java.util.*;

public class Signed32BitInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            try{
                System.out.print("Enter Value of a : ");
                int a = sc.nextInt();
                System.out.print("Enter Value of b : ");
                int b = sc.nextInt();
                System.out.println("Result = "+(a/b));
            }catch (InputMismatchException e){
                System.out.println("Enter 32 bit Signed Integer.");
            }catch(Exception e){
                System.out.println(e);
            }
    }
}
