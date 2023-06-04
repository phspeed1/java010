import java.util.*;
import java.io.*;

public class Inf050NumberMod{

    public static void main(String[] args){
        int N = 0;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        int rtn = new Inf050NumberMod().solution(N);
        System.out.println(rtn);
    }
    
    private int solution(int N){
        StringBuilder buff = new StringBuilder();
        int cnt = 0;
        boolean[] checks = new boolean[N+1];

        for(int i=2; i<=N; i++){
            if(checks[i]) continue;

            cnt++;
            for(int j=i; j<= N; j = j + i){
                checks[j] = true;
            }
        }
        
        return cnt;
    }

    boolean isSosu(int N){
        for(int i=2; i<N; i++){
            if(N % i == 0)
                return false;
        }
        return true;
    }


}