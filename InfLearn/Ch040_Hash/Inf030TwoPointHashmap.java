import java.util.*;
import java.io.*;

public class Inf030TwoPointHashmap{

    public static void main(String[] args){
        int N = 7;
        int K = 4;
        String str = "20 12 20 10 23 17 10";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            String[] strArr = str.split(" ");
            N = Integer.parseInt(strArr[0]);
            K = Integer.parseInt(strArr[1]);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf030TwoPointHashmap().solution(str, N, K);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N, int K){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
         Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
         // 초기화 End
        ////////////////////////////////////////
        // 1. 내가 제출한 방식
        // int k = K-1;
        // for(int i=0; i<N; i++){
        //     map.put(arr[i], map.getOrDefault(arr[i], 0)+1);

        //     if(i < k)
        //         continue;

        //     buff.append(" "+map.size());
            
        //     if(map.get(arr[i-k]) == 1)
        //         map.remove(arr[i-k]);
        //     else
        //         map.put(arr[i-k], map.get(arr[i-k]) -1);
        // }

        // 2. 강사방식
        // for(int i=0; i<K-1; i++){
        //     map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
        // }
        // int lt =0;
        // for(int rt=K-1; rt<N; rt++){
        //     map.put(arr[rt], map.getOrDefault(arr[rt], 0) +1);
        //     buff.append(" "+map.size());
        //     map.put(arr[lt], map.get(arr[lt]) -1);
        //     if(map.get(arr[lt]) == 0)
        //         map.remove(arr[lt]);
        //     lt++;
        // }

        // 3. 내 방식 다시
        int lt=0;
        for(int rt = 0; rt < N; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
            if(rt < K-1)
                continue;
            buff.append(" "+map.size());
            map.put(arr[lt], map.get(arr[lt])-1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        

        return buff.toString().trim();
    }

}