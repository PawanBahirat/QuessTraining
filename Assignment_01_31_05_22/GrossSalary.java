import java.io.*;
import java.util.*;

public class GrossSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Basic Salary : ");
        float BasicSal = sc.nextFloat();

        float ta = BasicSal * 0.1f;
        float da = BasicSal * 0.15f;
        float hra = BasicSal * 0.20f;
        float pf = BasicSal * 0.12f;

        if(BasicSal >= 20000) BasicSal += BasicSal * 0.1;
        else BasicSal += BasicSal * 0.20;

        System.out.println(BasicSal+ta+da+hra - pf);
    }
}
