import java.util.Arrays;

public class BubbleSort010 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        System.out.println("src : "+Arrays.toString(arr));
        new BubbleSort010().solution(arr);
        System.out.println("rtn : "+Arrays.toString(arr));
    }

    private void solution(int[] arr){
//        bubbleSort(arr, 0);
        bubbleSort(arr, 0, arr.length-1);
    }

    private void bubbleSort(int[] arr, int target, int idx){
        if(target ==arr.length-1 || idx==0) return;
        
        if(arr[idx-1] > arr[idx])
            swap(arr, idx-1, idx);
        if(idx == target -1){
            bubbleSort(arr, target+1, arr.length-1);
        }else{
            bubbleSort(arr, target, idx-1);
        }
    }

    private void bubbleSort2(int[] arr, int idx){
        if(idx ==arr.length-1) return;
        for(int i = arr.length-1; i>idx; i--){
            if(arr[i-1] > arr[i])
                swap(arr, i-1, i);
        }
        bubbleSort2(arr, idx+1);
    }

    void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }



}
