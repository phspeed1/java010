import java.util.*;

public class SelectionSort040{

    public static void main(String[] args){
        int[] arr = {3, 6, 1, 8, 2, 4};
        String str = "str";
        System.out.println("input : "+str);
    
        new SelectionSort040().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(int[] arr){
        int start = 0;
        System.out.println("before : "+Arrays.toString(arr));
        selectionSort(arr, start);
        System.out.println("after : "+Arrays.toString(arr));
    }

    void selectionSort(int[] arr, int idx){
        if(idx == arr.length-1) return;
        int minIdx = idx;
        for(int i=idx+1; i<arr.length; i++){
            if(arr[i] < arr[minIdx])
                minIdx = i;
        }
        swap(arr, idx, minIdx);
        System.out.println("["+idx+"]"+Arrays.toString(arr));
        selectionSort(arr, idx+1);
        
    }
    void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

}