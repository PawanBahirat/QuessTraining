import java.util.*;

public class SearchInRotatedArray {
    public static boolean rotatedArray(int[] arr, int t, int l, int r) {
        while(l<=r) {
            int m = l + (r-l)/2;
            if(t == arr[m]) return true;

            else if(arr[l] < arr[m])
                if(t < arr[m] && t >= arr[l]) r = m-1;
                else l = m+1;

            else if (arr[m] < arr[l])
                if(t > arr[m] && t <= arr[r]) l = m+1;
                else r = m-1;

            else l++;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();

        System.out.print("Enter Array Elements : ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();

        System.out.print("Enter Target Value : ");
        int t = sc.nextInt();

        System.out.println(rotatedArray(arr,t, 0, arr.length-1));
    }
}
