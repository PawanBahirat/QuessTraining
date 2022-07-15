import java.util.Scanner;

public class LogestPalindromicString {
    public static boolean isPal(String str){
        int l=0, r=str.length()-1;
        while(l < r)  if(str.charAt(r--) != str.charAt(l++))  return false;
        return true;
    }
    public static String longestPalindrome(String str) {
        String res = "";
        for(int i=0;i<str.length();i++)
            for(int j=i+1;j<=str.length();j++){
                String temp = "";
                if(isPal(str.substring(i,j))) temp =str.substring(i,j);
                int resLen = Math.max(temp.length(),res.length());
                if(resLen == temp.length()) res = temp;
                else res = res;
            }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String str = sc.next();
        System.out.println("Result : "+longestPalindrome(str));
    }
}
