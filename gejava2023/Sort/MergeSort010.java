import java.util.*;

public class MergeSort010{
    int stopper = 0;
    public static void main(String[] args){
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        String str = "str";
        System.out.println("input : "+str);
    
        new MergeSort010().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(int[] arr){
        int start = 0;
        int end = arr.length-1;
        int[] tmp = new int[arr.length];
        System.out.println("Before : "+Arrays.toString(arr));
        mergeSort(arr, start, end, tmp);
        System.out.println("After : "+Arrays.toString(arr));
        
    }

    void mergeSort(int[] arr, int start, int end, int[] tmp){
        if(start == end) return;
        int mid = start + ((end - start) / 2);
        int midGood = (start + end) / 2;

        if(stopper++ > 100) return;
        System.out.println("mergeSort() start : "+start+", mid : "+mid+", end : "+end+"  ("+midGood+")");
        

        mergeSort(arr, start, mid, tmp);
        mergeSort(arr, mid+1, end, tmp);
        merge(arr, start, mid, end, tmp);
    }

    void merge(int[] arr, int start, int mid, int end, int[] tmp){

        for(int i=start; i<=end; i++){
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid+1;
        int idx = start;

        while(part1<= mid && part2 <=end){
            if(tmp[part1] < tmp[part2]){
                arr[idx++] = tmp[part1++];
            }else{
                arr[idx++] = tmp[part2++];
            }
        }
        while(part1 <= mid){
            arr[idx++] = tmp[part1++];
        }

    }

}