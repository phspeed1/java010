import java.util.*;

public class MergeSort020{

    public static void main(String[] args){
        int[] arr = {3, 9, 4, 7, 5, 0, 11, 1, 6, 8, 2};
        String str = "str";
        System.out.println("input : "+str);
    
        new MergeSort020().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(int[] arr){
        int start = 0;
        int end = arr.length -1;
        
        System.out.println("Before : "+Arrays.toString(arr));
        mergeSort(arr, start, end);
        System.out.println("After : "+Arrays.toString(arr));
    }

    void mergeSort(int[] arr, int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, end, mid);
    }

    void merge(int[] arr, int start, int end, int mid){
        int[] tmp = Arrays.copyOf(arr, arr.length);
        int left = start;
        int right = mid+1;
        int idx = start;

        while(left <= mid && right <= end){
            if(tmp[left] < tmp[right])
                arr[idx++] = tmp[left++];
            else
                arr[idx++] = tmp[right++];
        }
        while(left <= mid){
            arr[idx++] = tmp[left++];
        }
    }

}