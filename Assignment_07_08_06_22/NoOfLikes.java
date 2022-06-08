package Assignment_07_08_06_22;

import java.util.*;

public class NoOfLikes {

    public static void likes(String[] arr){
        if(arr.length == 0) System.out.print("No one likes this");
        else if(arr.length == 1) System.out.print("Output : "+arr[0]+" likes this");
        else if(arr.length == 2) System.out.print("Output : "+arr[0]+" and "+arr[1]+" likes this");
        else if(arr.length == 3) System.out.print("Output : "+arr[0]+", "+arr[1]+" and "+arr[2]+" likes this");
        else System.out.print("Output : "+arr[0]+", "+arr[1]+" and "+(arr.length-2)+" others likes this" );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.print("Enter Array elements : ");
        for (int i=0;i<n;i++) arr[i] = sc.next();
        likes(arr);
    }
}
