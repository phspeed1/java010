import java.util.*;

public class QuickSort020{

    public static void main(String[] args){
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        String str = "str";
        System.out.println("input : "+str);
    
        new QuickSort020().solution(arr);
        System.out.println("output : "+str);
    }
    
    void solution(int[] arr){
        System.out.println("Before : "+Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("After : "+Arrays.toString(arr));
    }

    void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);
        if(start < part2-1)
            quickSort(arr, start, part2-1);
        if(part2 < end)
            quickSort(arr, part2, end);
    }

    int partition(int[] arr, int start, int end){
        int pivot = arr[(start + end)/2];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end)
                swap(arr, start++, end--);
        }


        return start;
    }

 
    void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}