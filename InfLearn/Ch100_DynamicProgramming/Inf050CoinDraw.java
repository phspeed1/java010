import java.util.*;
import java.io.*;

public class Inf050CoinDraw{

    public static void main(String[] args){
        int N = 3;
        String str = "1 2 5";
        int[] arr = {1, 2, 5};
        int M = 15;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            arr = new int[N];
            str = br.readLine();
            String[] sr = str.split(" ");
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(sr[i]);
            str = br.readLine();
            M = Integer.parseInt(str);
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf050CoinDraw().solution(N, arr, M);
        System.out.println(rtn);
    }
    
    int answer = Integer.MAX_VALUE;
    private String solution(int N, int[] arr, int M){
        StringBuilder buff = new StringBuilder();

        answer = Integer.MAX_VALUE;
     //   recursive(N, arr, M, 0);
        
        int[] dp = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(arr);


        for(int i=0; i<N; i++){
            for(int j=arr[i]; j<= M; j++){
                dp[j] = Math.min(dp[j], dp[j - arr[i]]+1);
            }
        //    System.out.println(Arrays.toString(dp));
        }
        answer = dp[M];

        buff.append(answer);
        return buff.toString();
    }

    void recursive(int N, int[] arr, int M, int cnt){
      //  System.out.println("M : "+M+ ", cnt : "+cnt);
        if(M == 0) {
            answer = Math.min(answer, cnt);
            return;
        }
        for(int i=0; i<N; i++){
            if(M == arr[i]){
                answer = Math.min(answer, cnt+1);
            }
        }

        for(int i=0; i<N; i++){
            if(M >= arr[i]){
                recursive(N, arr, M-arr[i], cnt+1);
            }
        }
    }

}