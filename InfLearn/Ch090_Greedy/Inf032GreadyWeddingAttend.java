import java.util.*;
import java.io.*;

public class Inf032GreadyWeddingAttend{

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
    
        String rtn = new Inf032GreadyWeddingAttend().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();

        List<Time> times = new ArrayList<Time>();
        for(int i=0; i<N; i++){
            times.add(new Time(arr[i][0], 'S'));
            times.add(new Time(arr[i][1], 'E'));
        }
        Collections.sort(times);

        //        System.out.println(Arrays.toString(RoomArr));
        int max = 0;
        int cnt = 0;
        for(Time time : times){
            if(time.type=='E')
                cnt--;
            else
                cnt++;
            max = Math.max(max, cnt);
        }

        buff.append(max);
        return buff.toString();
    }

    class Time implements Comparable<Time>{
        int time;
        char type;
        Time(int time, char type){
            this.time = time;
            this.type = type;
        }
        public int compareTo(Time o){
            if(this.time == o.time){
                if(this.type == 'E') return -1;
                else return 1;
            }
            return this.time - o.time;
        }
        public String toString(){
            return "{time:"+this.time+", type:"+this.type+"}";
        }
    }

}