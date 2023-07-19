import java.util.*;
import java.io.*;

public class Inf030RecursiveFactorial{

    public static void main(String[] args){
        int N = 5;
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf030RecursiveFactorial().solution(N);
        System.out.println(rtn);
    }
    
    private String solution(int N){
        StringBuilder buff = new StringBuilder();

        for(int i = 0; i<=N; i++){
            buff = new StringBuilder();
            long fnum = factorial(i, buff);
           System.out.println("["+i+"]("+fnum+")"+buff.toString());
        }
        buff = new StringBuilder();
        long fnum = factorial(N, buff);
        buff.append(fnum);
        return buff.toString().trim();
    }
    
    long factorial(int n, StringBuilder buff){
        if(n<=1) return 1;
        buff.append("*"+n);
        return n * factorial(n-1, buff);
    }
}