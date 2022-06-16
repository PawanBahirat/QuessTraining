import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;

public class NumberSystemConverter{
    public  static final String bin = "\033[1;92m"+"Binary Value is : ";
    public  static final String dec = "\033[1;92m"+"Decimal Value is : ";
    public  static final String oct = "\033[1;92m"+"Octal Value is : ";
    public  static final String hex = "\033[1;92m"+"HexaDecimal Value is : ";

    public static void binary(Scanner sc) {
        out.print("Enter Binary Value : ");
        String val = sc.next();
        if(Pattern.matches("[0-1]*",val)){
        out.print("\nEnter The Output Format : "+"\n\n1. Decimal\n2. Octal\n3. Hexadecimal\n\nEnter Your Choice : ");
        String outForm = sc.next();
        if(Pattern.matches("[1-3]*",outForm)){
        switch (outForm){
            case "1": out.print(dec+Integer.parseInt(val,2)); break;
            case "2": out.print(oct+Integer.toOctalString(Integer.parseInt(val,2))); break;
            case "3": out.print(hex+Integer.toHexString(Integer.parseInt(val,2))); break;
            }
        } else out.println("\033[0;91m"+"InValid Choice...!");
        } else { out.println("\033[0;91m"+"Invalid Binary Value...!"); return; }
    }
    public static void decimal(Scanner sc){
        out.print("Enter Decimal Value : ");
        String val = sc.next();
        if(Pattern.matches("[0-9]*",val)){
        out.print("\nEnter The Output Format : "+"\n\n1. Binary\n2. Octal\n3. Hexadecimal\n\nEnter Your Choice : ");
        String outForm = sc.next();
        if(Pattern.matches("[1-3]*",outForm)){
        switch (outForm){
            case "1": out.print(bin+Integer.toBinaryString(Integer.parseInt(val))); break;
            case "2": out.print(oct+Integer.toOctalString(Integer.parseInt(val))); break;
            case "3": out.print(hex+Integer.toHexString(Integer.parseInt(val))); break;
            }
        } else out.println("\033[0;91m"+"InValid Choice...!");
        } else { out.println("\033[0;91m"+"Invalid Decimal Value...!"); return; }
    }
    public static void octal(Scanner sc){
        out.print("Enter Octal Value : ");
        String val = sc.next();
        if(Pattern.matches("[0-7]*",val)){
        out.print("\nEnter The Output Format : "+"\n\n1. Binary\n2. Decimal\n3. Hexadecimal\n\nEnter Your Choice : ");
        String outForm = sc.next();
        if(Pattern.matches("[1-3]*",outForm)) {
        switch (outForm){
            case "1": out.print(bin+Integer.toBinaryString(Integer.parseInt(val,8))); break;
            case "2": out.print(dec+Integer.parseInt(val,8)); break;
            case "3": out.print(hex+Integer.toHexString(Integer.parseInt(val,8))); break;
            }
        } else out.println("\033[0;91m"+"InValid Choice...!");
        } else { out.println("\033[0;91m"+"Invalid Octal Value...!"); return; }
    }
    public static void hexaDecimal(Scanner sc){
        out.print("Enter HexaDecimal Value : ");
        String val = sc.next();
        if(Pattern.matches("[0-9A-Fa-f]*",val)) {
        out.print("\nEnter The Output Format : "+"\n\n1. Binary\n2. Decimal\n3. Octal\n\nEnter Your Choice : ");
        String outForm = sc.next();
        if(Pattern.matches("[1-3]*",outForm)) {
        switch (outForm){
            case "1": out.print(bin+Integer.toBinaryString(Integer.parseInt(val,16))); break;
            case "2": out.print(dec+Integer.parseInt(val,16)); break;
            case "3": out.print(oct+Integer.toOctalString(Integer.parseInt(val,16))); break;
            }
        } else out.println("\033[0;91m"+"InValid Choice...!");
        } else { out.println("\033[0;91m"+"Invalid HexaDecimal Value...!"); return; }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        do{
        out.print("\033[0;34m"+"\nEnter The Input Format : "+"\n\n1. Binary\n2. Decimal\n3. Octal\n4. Hexadecimal\n\nEnter Your Choice : ");
        String n = sc.next();
        if(Pattern.matches("[1-5]*",n)){
        switch (n){
            case "1": binary(sc); break;
            case "2": decimal(sc); break;
            case "3": octal(sc); break;
            case "4": hexaDecimal(sc); break;
            }
        } else out.println("\033[0;91m"+"InValid Choice...!");

            out.print("\033[1;92m"+"\nDo You Want to Continue YES/NO ? ");
            String q = sc.next();
            if(q.equals("Yes") || q.equals("yes") || q.equals("YES")) flag = true;
            else flag = false;
        }while(flag);
    }
}