import java.io.*;
import java.util.*;

public class Discount {
    public static void main(String[] args) {
        int price = Integer.parseInt(args[0]);
        int quantity = Integer.parseInt(args[1]);

        int total = price * quantity;
        if(quantity >= 10) total -= total*0.1;
        System.out.println(total);
    }
}
