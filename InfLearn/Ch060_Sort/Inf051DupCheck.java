import java.util.*;
import java.io.*;

public class Inf051DupCheck{

    public static void main(String[] args){
        int N = 8;
        String str = "20 25 52 30 39 33 43 33";
        N = 9;
        str = "9 7 3 5 1 6 9 4 1";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf051DupCheck().solution(str, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        int[] resArr = Arrays.copyOf(arr, arr.length);
        selectionSort(resArr, N);
        System.out.println("selectionSort : "+Arrays.toString(resArr));

        resArr = Arrays.copyOf(arr, arr.length);
        bubbleSort(resArr, N);
        System.out.println("bubbleSort : "+Arrays.toString(resArr));
        
        resArr = Arrays.copyOf(arr, arr.length);
        insertSort(resArr, N);
        System.out.println("insertSort : "+Arrays.toString(resArr));
        
        resArr = Arrays.copyOf(arr, arr.length);
        quickSort(resArr, 0, N-1);
        System.out.println("quickSort : "+Arrays.toString(resArr));
        
        resArr = Arrays.copyOf(arr, arr.length);
        mergeSort(resArr, 0, N-1);
        System.out.println("mergeSort : "+Arrays.toString(resArr));
        
        
        return buff.toString();
    }


    void selectionSort(int[] arr, int N){
        for(int i=0; i<N; i++){
            int m = i;
            for(int j=i+1; j<N; j++){
                if(arr[m] > arr[j]) m = j;
            }
            swap(arr, i, m);
        }
    }

    void bubbleSort(int[] arr, int N){
        for(int i=0; i<N; i++){
            for(int j=N-1; j>i; j--){
                if(arr[j-1] > arr[j]) swap(arr, j-1, j);
            }
        }
    }

    void insertSort(int[] arr, int N){
        for(int i=1; i<N; i++){
            int t = arr[i];
            int j=i-1;
            for( ; j >= 0 && arr[j] > t; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = t;
        }
    }

    void quickSort(int[] arr, int lt, int rt){
        // pivot 받아서 less bigger 별로 다시 quickSort 후 오른쪽 인덱스 넘김
        int mid = partition(arr, lt, rt);
        if(lt < mid-1) quickSort(arr, lt, mid-1);
        if(mid < rt) quickSort(arr, mid, rt);
    }

    int partition(int[] arr, int lt, int rt){
        int pivot = arr[(lt+rt)/2];
        while(lt <= rt){
            while(arr[lt] < pivot) lt++;
            while(pivot < arr[rt]) rt--;
            if(lt <= rt) swap(arr, lt++, rt--);
        }
        return lt;
    }

    void mergeSort(int[] arr, int lt, int rt){
        // 일단 길이 1 때까지 나눈 후 merge
        if(lt >= rt) return;

        int mid = (lt + rt)/2;
        mergeSort(arr, lt, mid);
        mergeSort(arr, mid+1, rt);
        merge(arr, lt, mid, rt);
    }

    void merge(int[] arr, int start, int mid, int end){
        int[] temp = Arrays.copyOfRange(arr, 0, end+1);
        int idx = start;
        int lt = start;
        int rt = mid+1;

        while(lt <= mid && rt <= end){
            if(temp[lt] < temp[rt]) arr[idx++] = temp[lt++];
            else arr[idx++] = temp[rt++];
        }
        while(lt <= mid) arr[idx++] = temp[lt++];
    }

    void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

}