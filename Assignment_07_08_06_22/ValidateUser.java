package Assignment_07_08_06_22;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ValidateUser {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Username : ");
        String name = sc.nextLine();
        System.out.print("Enter Password : ");
        String passwd = sc.nextLine();
        try {
            if (name.length() < 6 || name.length() > 15) throw new Exception("A username must be of length 6-15 characters.");
            else if(!(Pattern.matches("[A-Za-z0-9]*",name))) throw new Exception("There cannot be any types of parentheses or whitespaces in a valid username or password.");
            else if(!(Pattern.matches("[A-Z]+[A-Za-z0-9]*",name))) throw new Exception("A username must start with an uppercase English alphabet A to Z.");
            else if(passwd.length() < 8 || passwd.length() > 256) throw new Exception("A password must not be shorter than 8 characters but must not exceed 256.");
            else if(!(Pattern.matches("[A-Za-z0-9]*",passwd))) throw new Exception("There cannot be any types of parentheses or whitespaces in a valid username or password.");
            else if(passwd.equals(name)) throw new Exception("A password cannot contain or be the same as its associated username");
            else System.out.println("UserName and Password is valid.");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
