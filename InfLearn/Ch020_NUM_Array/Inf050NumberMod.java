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
    
        int rtn = new Inf050NumberMod().solution2(N);
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

    private int solution2(int N){
        int cnt = 0;
        for(int i=2; i<=N; i++){

            double dSqrt = Math.sqrt(i);
            int iSqrt = (int) dSqrt;
            System.out.println(i+" : "+(dSqrt)+" , "+(iSqrt));

            if(isPrime(N)){
                cnt++;
            }
        }

        return cnt;
    }

    boolean isPrime(int N){
        for(int i=2; i<N; i++){
            if(N % i == 0)
                return false;
        }
        return true;
    }


}