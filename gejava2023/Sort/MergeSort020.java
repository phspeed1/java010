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
        System.out.println("Before : "+Arrays.toString(arr));
 //       mergeSort(arr, 0, arr.length-1);
        System.out.println("After : "+Arrays.toString(arr));
    }



}