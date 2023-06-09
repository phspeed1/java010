import java.util.*;
import java.io.*;

public class Inf050DupCheck{

    public static void main(String[] args){
        int N = 8;
        String str = "20 25 52 30 39 33 43 33";
        N = 9;
        str = "9 7 3 5 1 6 9 4 1";
        str = "9 8 7 6 5 4 3 2 1";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf050DupCheck().solution(str, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        boolean isDupSet = isDupSet(arr, N);
        if(isDupSet) return "D";

        // boolean isDupSort = isDupSort(arr, N);
        // if(isDupSort) return "D";

        
        buff.append("U");
        return buff.toString();
    }

    boolean isDupSet(int[] arr, int N){
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<N; i++){
            set.add(arr[i]);
            if(set.size() != i+1) return true;
        }
        return false;
    }
    int max=0;
    boolean isDupSort(int[] arr, int N){
        
        //selectionSort(arr, N);
        //bubbleSort(arr, N);
        //insertSort(arr, N);
        //quickSort(arr, 0, N-1);
        mergeSort(arr, 0, N-1);

        for(int i=0; i<N-1; i++){
            if(arr[i] == arr[i+1]) return true;
        }
        return false;
    }

    void selectionSort(int[] arr, int N){
        for(int i=0; i<N; i++){
            int m = i;
            for(int j=i+1; j<N; j++){
                if(arr[m] > arr[j]) m = j;
            }
            swap(arr, i, m);
            System.out.println("("+i+")"+Arrays.toString(arr));
        }
    }

    void bubbleSort(int[] arr, int N){
        for(int i=0; i<N; i++){
            for(int j=N-1; j>i; j--){
                if(arr[j-1] > arr[j]) swap(arr, j-1, j);
            }
            System.out.println("("+i+")"+Arrays.toString(arr));
        }
    }

    void insertSort(int[] arr, int N){
        for(int i=1; i<N; i++){
            int tmp = arr[i];
            int j = i-1;
            for( ; j>= 0 && arr[j]>tmp; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = tmp;
            System.out.println("("+i+")"+Arrays.toString(arr));
        }
    }

    void quickSort(int[] arr, int lt, int rt){
        // pivot 잡아서 part1 에는 pivot 보다 작은것 part2 에는 povit 보다 큰것 part1, part2 재귀 반복

        int mid = partition(arr, lt, rt);
        System.out.println("("+lt+"~"+mid+"~"+rt+")"+Arrays.toString(arr));

        if(lt < mid-1) quickSort(arr, lt, mid-1);
        if(mid < rt) quickSort(arr, mid, rt);


    }
    int partition(int[] arr, int lt, int rt){
        int pivot = arr[(lt + rt) / 2];
        while(lt <= rt){
            while(arr[lt] < pivot) lt++;
            while(pivot < arr[rt]) rt--;
            if(lt <= rt) swap(arr, lt++, rt--);
        }
        return lt;
    }

    void mergeSort(int[] arr, int lt, int rt){
        // 일단 끝까지 2로 나누어서 쪼갠 후 merge 정렬
        if(lt >= rt) return;

        int mid = (lt + rt) / 2;
        mergeSort(arr, lt, mid);
        mergeSort(arr, mid+1, rt);
        merge(arr, lt, mid, rt);
        System.out.println("("+lt+"~"+mid+"~"+rt+")"+Arrays.toString(arr));
    }
    void merge(int[] arr, int start, int mid, int end){
        int[] temp = Arrays.copyOf(arr, arr.length);
        int idx = start;
        int lt = start;
        int rt = mid+1;
        while(lt <= mid && rt <=end){
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