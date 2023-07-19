import java.util.*;
import java.io.*;

public class Inf020GreadyConfRoom{

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
    
        String rtn = new Inf020GreadyConfRoom().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();

        Room[] rooms = new Room[N];
        for(int i=0; i<N; i++){
            rooms[i] = new Room(arr[i][0], arr[i][1]);
        }
        Arrays.sort(rooms);
//        System.out.println(Arrays.toString(RoomArr));

        int answer = 0;

        int ed = -1;
        for(Room room : rooms){
            if(room.s >= ed){
                ed = room.e;
                answer++;
            }
        }


        buff.append(answer);
        return buff.toString();
    }

    class Room implements Comparable<Room>{
        int s, e, l;
        Room(int s, int e){
            this.s = s;
            this.e = e;
            this.l = e-s;
        }
        public int compareTo(Room o){
            if(this.e == o.e) return this.s - o.s;
            return this.e - o.e;
        }
        public String toString(){
            return "{s:"+this.s+", e:"+this.e+", l:"+this.l+"}";
        }
    }

}