import java.util.*;
import java.io.*;

public class Inf040PrintFivo{

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
    
        String rtn = new Inf040PrintFivo().solution2(N);
        System.out.println(rtn);
    }

    private String solution2(int N){
        StringBuilder buff = new StringBuilder();
        long a=1, b=1, c;
        buff.append("1 1");
        for(long i=2; i<N; i++){
            c = a + b;
            buff.append(" "+c);
            a = b; b = c;
        }
        return buff.toString();
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

        for(int i=0; i<N; i++){
            if(i<=1){
                arr[i] = 1;
            }else{
                arr[i] = arr[i-2] + arr[i-1];
            }
        }
        return arr;

    }

}