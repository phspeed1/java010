import java.util.*;
import java.io.*;

public class Inf040LatestRecentlyUsedInsertSort{

    public static void main(String[] args){
        int S = 5;
        int N = 9;
        String str = "1 2 3 2 6 2 3 5 7";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] strArr = str.split(" ");
        //     S = Integer.parseInt(strArr[0]);
        //     N = Integer.parseInt(strArr[1]);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf040LatestRecentlyUsedInsertSort().solution(str, S, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int S, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] nums = new int[N];
        for(int i=0; i<strArr.length; i++) nums[i] = Integer.parseInt(strArr[i]);
        int[] arr = new int[S];

        // 강사 방식으로 다시한번
        for(int x : nums){
            int idx = -1;
            for(int i=0; i<S; i++) {
                if(arr[i] == x){
                    idx = i;
                    break;
                }
            }
            if(idx != -1){
                for(int j=idx-1; j>=0; j--) arr[j+1] = arr[j];
            }else{
                for(int j=S-1; j>0; j--) arr[j] = arr[j-1];
            }
            arr[0] = x;
        //    System.out.println("("+x+")"+Arrays.toString(arr));
        }
        for(int i:arr) buff.append(" "+i);


//        buff = new StringBuilder(solveInsertSort(arr, S, N)); // 내가 제출한 방식

        return buff.toString().trim();
    }



    String solveInsertSort(int[] nums, int S, int N){
        StringBuilder buff = new StringBuilder();
        int[] arr = new int[S];

        for(int i=0; i<N; i++){
            int num = nums[i];
            int idx = indexOf(arr, num);
            if(idx != -1){
                // 이미 메모리에 있을 때
                shiftInsert(arr, idx);
            }else{
                // 메모리에 없을때는 전체밀어내고 맨앞에 삽입
                for(int j=S-1-1; j>=0; j--){
                    arr[j+1] = arr[j];
                }
                arr[0] = num;
            }
        //    System.out.println("("+num+")"+Arrays.toString(arr));;
        }

        for(int i:arr) buff.append(" "+i);
        return buff.toString().trim();
    }

    int indexOf(int[] arr, int num){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == num) return i;
        }
        return -1;
    }
    int getFirstZero(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0) return i;
        }
        return -1;
    }
    void shiftInsert(int[] arr, int idx){
        int tmp = arr[idx];
        for(int j=idx-1; j >= 0; j--){
            arr[j+1] = arr[j];
        }
        arr[0] = tmp;
    }

    // 실패. 큐로 순환해서 풀면 안됨 밀어냈어야 함.
    String solveQueue(int[] arr, int S, int N){
        StringBuilder buff = new StringBuilder();
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i<N; i++){
            int a = arr[i];
            if(queue.contains(a)){
                while(queue.peek() != a) queue.offer(queue.poll());
            }else{
                if(queue.size() < S){
                    queue.offer(a);
                }else{
                    queue.poll();
                    queue.offer(a);
                }
            }
            System.out.println("["+a+"]"+queue);
        }
        for(int i : queue) buff.append(" "+i);

        return buff.toString().trim();
    }

}