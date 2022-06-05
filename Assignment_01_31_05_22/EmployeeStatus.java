import java.util.*;

public class EmployeeStatus {
    public static void main(String[] args) {

        char ge,ms;
        int age;
        System.out.print("Enter marital status (M/N) : ");
        Scanner obj = new Scanner(System.in);
        ms = obj.next(). charAt(0);
        System.out.print("Enter Gender (M/F) : ");
        ge = obj.next(). charAt(0);
        System.out.print("Enter Age : ");
        age= obj.nextInt();

        if (ms=='M') System.out.println ("Driver is insured");
        else if (ge=='M' && age>30 && ms=='N') System.out.println ("Driver is insured");
        else if (ge=='F' && age>25 && ms=='N') System.out.println ("Driver is insured");
        else System.out.println ("Driver is not insured");
    }
}
