import java.util.Arrays;

public class SelectionSort010 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println("before : "+Arrays.toString(arr));
        new SelectionSort010().solution(arr);
        System.out.println("After : "+Arrays.toString(arr));
    }

    private void solution(int[] arr){
        selectionSort(arr, 0);
    }

    private void selectionSort(int[] arr, int idx){
        if(idx == arr.length-1) return;

        int minIdx = idx;
        for(int i=idx; i<arr.length; i++){
            if(arr[i] < arr[minIdx]) minIdx =i;
        }
        swap(arr, idx, minIdx);
        selectionSort(arr, idx+1);

    }


    static void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }


}
