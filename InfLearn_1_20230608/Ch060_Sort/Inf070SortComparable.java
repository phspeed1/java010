import java.util.*;
import java.io.*;

public class Inf070SortComparable{

    public static void main(String[] args){
        int N = 5;
        String str = "";
        int[][] arr = new int[N][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            arr = new int[N][2];
            for(int i=0; i<N; i++){
                str = br.readLine();
                String[] s = str.split(" ");
                arr[i][0] = Integer.parseInt(s[0]);
                arr[i][1] = Integer.parseInt(s[1]);
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf070SortComparable().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();
        List<Pair> list = new ArrayList<Pair>();
        for(int i=0; i<arr.length; i++){
            list.add(new Pair(arr[i][0], arr[i][1]));
        }
        Collections.sort(list);
        for(Pair p : list) buff.append(p.toString()+"\n");
        
        return buff.toString();
    }

    class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o){
            if(this.x == o.x){
                return  this.y - o.y;
            }
            return this.x - o.x;
        }
        public String toString(){
            return this.x + " " + this.y;
        }
    }

}