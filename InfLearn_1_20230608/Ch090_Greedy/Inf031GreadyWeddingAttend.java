import java.util.*;
import java.io.*;

public class Inf031GreadyWeddingAttend{

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
    
        String rtn = new Inf031GreadyWeddingAttend().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();

        int[] starts = new int[72];
        int[] ends = new int[72];

        for(int i=0; i<N; i++){
            starts[arr[i][0]]++;
            ends[arr[i][1]]++;
        }

        //        System.out.println(Arrays.toString(RoomArr));
        int max = 0;
        int cnt = 0;
        for(int i=0; i<72; i++){
            cnt += starts[i];
            cnt -= ends[i];
            max = Math.max(max, cnt);
        }

        buff.append(max);
        return buff.toString();
    }

    class Times implements Comparable<Times>{
        int s, e, l;
        Times(int s, int e){
            this.s = s;
            this.e = e;
            this.l = e-s;
        }
        public int compareTo(Times o){
            if(this.s == o.s) return this.e - o.e;
            return this.s - o.s;
        }
        public String toString(){
            return "{s:"+this.s+", e:"+this.e+", l:"+this.l+"}";
        }
    }

}