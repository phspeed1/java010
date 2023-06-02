import java.util.*;

public class Heap010{

    public static void main(String[] args){
        String str = "str";
        int[] arr = {3,7,5,4,2,8};
        int N = 3;
        System.out.println("input : "+Arrays.toString(arr));
    
        int nRtn = new Heap010().solution(arr, N);
        System.out.println("output : "+nRtn);
    }
    
    int solution(int[] arr, int N){
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : arr)pQueue.offer(i);

        int nRtn=0;
        System.out.println(pQueue);
        for(int i=0; i<N; i++){
            nRtn = pQueue.poll();
            System.out.println(pQueue);
        }        
        return nRtn;
    }

}