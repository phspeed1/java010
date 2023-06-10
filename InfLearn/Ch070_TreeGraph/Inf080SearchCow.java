import java.util.*;
import java.io.*;

public class Inf080SearchCow{

    public static void main(String[] args){
        int S = 5;
        int E = 14;
        String str = "";

     //   S = 13;
     //   E = 35;

     //   S = 1;
     //   E = 321;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            S = Integer.parseInt(str.split(" ")[0]);
            E = Integer.parseInt(str.split(" ")[1]);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf080SearchCow().solution(S, E);
        System.out.println(rtn);
    }
    
    private String solution(int S, int E){
        StringBuilder buff = new StringBuilder();
        int answer = 0;
        answer = bfs(S, E);
        
        buff.append(answer);
        return buff.toString();
    }

    int bfs(int S, int E){
        int lv = 0;
        int[] dr = {1, -1, 5};
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(S);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                S = queue.poll();
          //      System.out.println("("+lv+")"+S);
                if(S == E) return lv;
                if(S > E) queue.offer(S-1);
                else if(E - S >= 4) queue.offer(S+5);
                else queue.offer(S+1);

                // 4 -> 앞 5칸 + 뒤 1칸
                // 3 -> 앞 세칸
                // 2 -> 앞 두칸
                // 1 -> 앞 한칸
            }
            lv++;
        }
        return lv;

    }

}