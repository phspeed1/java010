import java.util.Arrays;

public class BubbleSort010 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println("src : "+Arrays.toString(arr));
        new BubbleSort010().bubbleSort(arr, arr.length-1);
        System.out.println("rtn : "+Arrays.toString(arr));

    }

    void bubbleSort(int[] arr, int end){
        if(end == 0)
            return;
        for(int i=0; i<end; i++){
            if(arr[i] > arr[i+1])
                swap(arr, i, i+1);

        }
        bubbleSort(arr, end-1);
    }

    void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }



}
