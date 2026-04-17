import java.util.*;
public class Main{
    public static void quicksort(int arr[] , int low,int high){
        int start = low;
        int end = high;
        int mid=(start+end)/2;
        int pivot=arr[mid];
        while(start <= end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start <=end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
            if(low<end){
                quicksort(arr,low,end);
            }if(start <high){
                quicksort(arr,start,high);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quicksort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}