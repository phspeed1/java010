import java.util.*;

public class BuffleSort030{

    public static void main(String[] args){
        int[] arr = {3, 6, 1, 8, 2, 4};
        String str = "str";
        System.out.println("input : "+str);
    
        new BuffleSort030().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(int[] arr){
        System.out.println("before : "+Arrays.toString(arr));
        bubbleSort(arr, arr.length-1);
        System.out.println("after : "+Arrays.toString(arr));
    }

    void bubbleSort(int[] arr, int end){
        if(end == 0) return;

        for(int i=0; i<end; i++){
            if(arr[i] > arr[i+1])
                swap(arr, i, i+1);
        }
        System.out.println("["+end+"]] : "+Arrays.toString(arr));

        bubbleSort(arr, end-1);
    }


    void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}