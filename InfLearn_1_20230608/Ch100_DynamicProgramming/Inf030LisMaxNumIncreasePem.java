import java.util.*;
import java.io.*;

public class Inf030LisMaxNumIncreasePem{

    public static void main(String[] args){
        int N = 8;
        String str = "5 3 7 8 6 2 9 4";
        int[] arr = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
            String[] sr = str.split(" ");
            arr = new int[N];
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(sr[i]);

        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf030LisMaxNumIncreasePem().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[] arr){
        StringBuilder buff = new StringBuilder();
        int[] dp = new int[N];
        dp[0] = 1;
        int answer = dp[0];

        for(int i=1; i<N; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i]) max = Math.max(max, dp[j]); 
            }
            dp[i] = max+1;
            answer = Math.max(answer, dp[i]);
        }
        buff.append(answer);
        return buff.toString();
    }

}