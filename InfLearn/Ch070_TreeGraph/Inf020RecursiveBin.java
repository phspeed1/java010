import java.util.*;
import java.io.*;

public class Inf020RecursiveBin{

    public static void main(String[] args){
        int N = 11;
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf020RecursiveBin().solution(N);
        System.out.println(rtn);
    }
    
    private String solution(int N){
        StringBuilder buff = new StringBuilder();

        for(int i = 0; i<N; i++){
            buff = new StringBuilder();
            DFS(i, buff);
          // System.out.println("["+i+"]"+buff.toString());
        }
        DFS(N, buff);
        return buff.toString().trim();
    }
    
    void DFS(int n, StringBuilder buff){
        if(n == 0) return;

        int v = n / 2;
        int m = n % 2;
        DFS(v, buff);
        buff.append(m);
    }

}