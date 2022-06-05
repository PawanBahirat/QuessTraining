import java.util.*;

public class ArmstrongNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int number = n, res = 0;

        while (number != 0) {
            int temp = number % 10;
            res += (temp*temp*temp);
            number /= 10;
        }

        System.out.println(n + ((res == n) ? " is an Armstrong number." : " is not an Armstrong number"));
    }
}
