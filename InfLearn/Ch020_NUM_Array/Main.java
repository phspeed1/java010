import java.util.*;
import java.io.*;

public class Main{

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
    
        String rtn = new Main().solution(N);
        System.out.println(rtn);
    }
    
    private String solution(int N){
        StringBuilder buff = new StringBuilder();
        long[] arr = fivo(N);
        for(int i=0; i<arr.length; i++){
            buff.append(" "+arr[i]);
        }
        return buff.toString().trim();
    }

    private long[] fivo(int N){
        long[] arr = new long[N];

        arr[0] = 1;
        if(N == 0)  return arr;
        
        arr[1] = 1;
        if(N == 1)  return arr;

        for(int i=2; i<N; i++){
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr;

    }

}