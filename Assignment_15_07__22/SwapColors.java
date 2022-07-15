import java.util.Scanner;

public class SwapColors {
    public static void sort(int[] arr) {
        int i = 0,j = 0,k = arr.length-1;
        while(j<=k){
            if(arr[j] == 0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[j] == 1) j++;
            else if(arr[j] == 2){
                swap(arr, j,k);
                k--;
            }
        }
    }
    public static void swap(int [] arr, int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        System.out.print("Enter Array Elements : ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        sort(arr);
        for(int i=0;i<n;i++) System.out.print("Result : "+arr[i]+" ");
    }
}
