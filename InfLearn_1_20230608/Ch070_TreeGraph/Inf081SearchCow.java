import java.util.*;
import java.io.*;

public class Inf081SearchCow{

    public static void main(String[] args){
        int S = 5;
        int E = 14;
        String str = "";

        S = 13;
        E = 35;

        S = 1;
        E = 321;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            S = Integer.parseInt(str.split(" ")[0]);
            E = Integer.parseInt(str.split(" ")[1]);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf081SearchCow().solution(S, E);
        System.out.println(rtn);
    }
    
    private String solution(int S, int E){
        StringBuilder buff = new StringBuilder();
        int MAX = 10000;
        boolean[] visited = new boolean[MAX+1];
        int answer = 0;
        answer = bfs(S, E, MAX, visited);
        
        buff.append(answer);
        return buff.toString();
    }

    int bfs(int S, int E, int MAX, boolean[] visited){
        int[] dx = {1, -1, 5};
        int lv = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(S);
        visited[S] = true;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                int x = queue.poll();
                if(x == E) return lv;

                for(int dr : dx){
                    int nx = x+dr;
                    
                    if(nx == E) return lv+1;

                    if(nx >=1 && nx <= MAX && !visited[nx]){
                        visited[nx] = true;
                        queue.offer(nx);
                    }
                }
            }
            lv++;
        }
        
        return -1;
    }

}