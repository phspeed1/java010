import java.util.*;
import java.io.*;

public class Inf040RecursiveFivonachi{

    public static void main(String[] args){
        int N = 45;
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf040RecursiveFivonachi().solution(N);
        System.out.println(rtn);
    }
    
    private String solution(int N){
        StringBuilder buff = new StringBuilder();

        // for(int i=1; i<=N; i++){
        //     long fivo = fivonachi(i, buff);
        //     buff.append(" "+fivo);
        // }

        long[] arr = new long[N+1];
        // for(int i=0; i< arr.length; i++){
        //     if(i <= 1) {
        //         arr[i] = i;
        //         continue;
        //     }
        //     arr[i] = arr[i-2] + arr[i-1];
        // }
        fivonachiDP(N, buff, arr);

        for(int i=1; i<=N; i++){
            buff.append(" "+arr[i]);
        }


        return buff.toString().trim();
    }

    long fivonachi(int n, StringBuilder buff){
        if(n <= 2) {
            return 1;
        }

        return fivonachi(n-2, buff) + fivonachi(n-1, buff);
    }
    
    long fivonachiDP(int n, StringBuilder buff, long[] fivoArr){
        if(n <= 2) {
            return fivoArr[n] =1;
        }
        if(fivoArr[n] != 0) return fivoArr[n];

        return fivoArr[n] = fivonachiDP(n-2, buff, fivoArr) + fivonachiDP(n-1, buff, fivoArr);
    }

}