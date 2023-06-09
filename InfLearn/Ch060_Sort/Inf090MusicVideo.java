import java.util.*;
import java.io.*;

public class Inf090MusicVideo{

    public static void main(String[] args){
        int N = 9;
        int M = 3;
        String str = "1 2 3 4 5 6 7 8 9";

        N=5; M=4;
        str = "1 1 1 1 1";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str.split(" ")[0]);
        //     M = Integer.parseInt(str.split(" ")[1]);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf090MusicVideo().solution(str, N, M);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N, int M){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        int tgt = 17;
        for(tgt = 0; tgt < N*M;tgt++ ){
            int dvd = 0;
            int sum = 0;
            int lt = 0;
            int rt = 0;
            while (dvd < M) {
                while(rt < N && sum + arr[rt] <= tgt) {
                    sum += arr[rt];
                    rt++;
                }
//                System.out.println("dvd : "+dvd+" rt : "+rt);
                sum = 0;
                dvd++;
            }
            if(dvd == M && rt == N) break;
        }
        buff.append(tgt);
        return buff.toString();
    }

}