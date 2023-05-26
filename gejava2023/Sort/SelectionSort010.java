import java.util.Arrays;

public class SelectionSort010 {
    public static void main(String[] args) {
        int[] src = {3, 6, 1, 8, 2, 4};
        System.out.println("src : "+Arrays.toString(src));
        int[] rtn = selectionSort(src);
        System.out.println("rtn : "+Arrays.toString(rtn));

    }

    static int[] selectionSort(int[] src){
        int minIdx;
        int tmp;
        for(int i=0; i<src.length; i++){
            minIdx=i;
            for(int j=i+1; j<src.length; j++){
                System.out.println(Arrays.toString(src)+""+src[minIdx]+"["+j+"]"+src[j]+" ? "+(src[j] < src[minIdx]));
                if(src[j] < src[minIdx]){
                    minIdx = j;
                }
            }
            swap(src, i, minIdx);
            System.out.println(" "+Arrays.toString(src));
    
        }
        return src;
    }

    static void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }


}
