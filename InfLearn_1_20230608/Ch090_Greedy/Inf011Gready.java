import java.util.*;
import java.io.*;

public class Inf011Gready{

    public static void main(String[] args){
        int N = 5;
        String str = "";
        int[][] arr = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            arr = new int[N][2];
            for(int i=0; i<N; i++){
                str = br.readLine();
                arr[i][0] = Integer.parseInt(str.split(" ")[0]);
                arr[i][1] = Integer.parseInt(str.split(" ")[1]);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf011Gready().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();

        Stat[] statArr = new Stat[N];
        for(int i=0; i<N; i++){
            statArr[i] = new Stat(arr[i][0], arr[i][1]);
        }
        Arrays.sort(statArr);
//        System.out.println(Arrays.toString(statArr));

        int answer = 1;
        int maxWeight = statArr[0].w;

        for(int i=1; i<N; i++){
            if(statArr[i].w >=  maxWeight){
                maxWeight = statArr[i].w;
                answer++; 
            }
        }


        buff.append(answer);
        return buff.toString();
    }

    class Stat implements Comparable<Stat>{
        int h, w;
        Stat(int h, int w){
            this.h = h;
            this.w = w;
        }
        public int compareTo(Stat o){
            if(this.h == o.h) return o.w - this.w;
            return o.h - this.h;
        }
        public String toString(){
            return "{"+this.h+", "+this.w+"}";
        }
    }

}