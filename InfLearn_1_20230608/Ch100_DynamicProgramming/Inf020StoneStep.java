import java.util.*;
import java.io.*;

public class Inf020StoneStep{

    public static void main(String[] args){
        int N = 7;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        int rtn = new Inf020StoneStep().solution(N);
        System.out.println(rtn);
    }

    int solution(int N){
        int[] dp = new int[N+1+1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=N+1; i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[N+1];
    }

}