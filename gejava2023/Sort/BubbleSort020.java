import java.util.Arrays;

public class BubbleSort020 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println("src : "+Arrays.toString(arr));
        new BubbleSort020().bubbleSort(arr, 0);
        System.out.println("rtn : "+Arrays.toString(arr));

    }

    void bubbleSort(int[] arr, int minIdx){
        if(minIdx == arr.length-1) return;
        for(int i=arr.length-1; i>minIdx; i--){
            if(arr[i] < arr[i-1])
                swap(arr, i, i-1);
        }
        System.out.println(minIdx+" : "+Arrays.toString(arr));
        bubbleSort(arr, minIdx+1);
    }

    void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }





}
