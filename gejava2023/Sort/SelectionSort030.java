import java.util.Arrays;

public class SelectionSort030 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println("src : "+Arrays.toString(arr));
        new SelectionSort030().selectionSort(arr, 0);
        System.out.println("rtn : "+Arrays.toString(arr));

    }

    void selectionSort(int[] arr, int start){
        if(start == arr.length)
            return;
        int minIdx = start;
        for(int i=start; i<arr.length; i++){
            if(arr[i] < arr[minIdx])
                minIdx = i;
        }
        swap(arr, start, minIdx);
        selectionSort(arr, start+1);
    }

    void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }



}
