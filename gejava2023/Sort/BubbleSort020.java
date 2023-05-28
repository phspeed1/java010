import java.util.Arrays;

public class BubbleSort020 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println("src : "+Arrays.toString(arr));
        new BubbleSort020().bubbleSort(arr, arr.length-1);
        System.out.println("rtn : "+Arrays.toString(arr));

    }

    void bubbleSort(int[] arr, int endP){
        if(endP == 0)
            return;

        for(int i=0; i<endP; i++){
            if(arr[i] > arr[i+1]) swap(arr, i, i+1);
        }

        bubbleSort(arr, endP-1);
    }

    void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }





}
