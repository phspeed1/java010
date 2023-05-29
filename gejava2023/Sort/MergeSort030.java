import java.util.*;

public class MergeSort030{

    public static void main(String[] args){
        int[] arr = {3, 9, 4, 7, 5, 0, 11, 1, 6, 8, 2};
        String str = "str";
        System.out.println("input : "+str);
    
        new MergeSort030().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(int[] arr){
        int[] tmp = new int[arr.length];
        System.out.println("before : "+Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1, tmp);
        System.out.println("after : "+Arrays.toString(arr));
    }

    void mergeSort(int[] arr, int start, int end, int[] tmp){
        if(start == end) return;
        int mid = (start+end)/2;
        mergeSort(arr, start, mid, tmp);
        mergeSort(arr, mid+1, end, tmp);
        merge(arr, start, end, mid, tmp);
    }

    void merge(int[] arr, int start, int end, int mid, int[] tmp){
        int idx = start;
        int left = start;
        int right = mid+1;
        tmp = Arrays.copyOf(arr, arr.length);
        
        while(left <= mid && right <= end){
            if(tmp[left] < tmp[right] ) arr[idx++] = tmp[left++];
            else arr[idx++] = tmp[right++];
        }
        while(left <= mid) arr[idx++] = tmp[left++];
    }

}