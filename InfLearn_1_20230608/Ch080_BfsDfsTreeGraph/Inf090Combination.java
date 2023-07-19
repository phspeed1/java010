import java.util.*;
import java.io.*;

public class Inf090Combination{

    public static void main(String[] args){
        String str = "5 3";
        int N =0, M = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
//            str = br.readLine();
            String[] sr = str.split(" ");
            N = Integer.parseInt(sr[0]);
            M = Integer.parseInt(sr[1]);
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf090Combination().solution(N, M);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M){
        StringBuilder buff = new StringBuilder();
        int[] ans = new int[M];
        combination(N, M, 0, 1, ans);
        return buff.toString();
    }

    void combination(int N, int M, int lv, int start, int[] ans){
        if(lv == M){
            for(int x : ans) System.out.print(x+ " ");
            System.out.println();
            return;
        }

        for(int i=start; i<=N; i++){
            ans[lv] = i;
            combination(N, M, lv+1, i+1, ans);
        }
    }

}