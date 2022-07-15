import java.util.Scanner;

public class MaxJump {
    public static boolean temp(int[] arr) {
        if(arr.length ==0 ) return true;
        boolean[] b = new boolean[arr.length];
        b[0]=true;

        for(int i=0;i<arr.length;i++){
            if(b[i]==false) return false;
            for(int j=i+1;j<arr.length && j<=i+arr[i];j++) b[j]=true;
        }
        return b[arr.length-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        System.out.print("Enter Array Elements : ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println("Result : "+temp(arr));
    }
}
