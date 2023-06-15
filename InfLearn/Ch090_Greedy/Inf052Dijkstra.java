import java.util.*;
import java.io.*;

public class Inf052Dijkstra{

    public static void main(String[] args){
        int N = 6;
        int M = 9;
        int[][] arr;
        String str = "";
        arr = new int[M][3];
        arr[0] = new int[]{1, 2, 12};
        arr[1] = new int[]{1, 3, 4};
        arr[2] = new int[]{2, 1, 2};
        arr[3] = new int[]{2, 3, 5};
        arr[4] = new int[]{2, 5, 5};
        arr[5] = new int[]{3, 4, 5};
        arr[6] = new int[]{4, 2, 2};
        arr[7] = new int[]{4, 5, 5};
        arr[8] = new int[]{6, 4, 5};

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str.split(" ")[0]);
        //     M = Integer.parseInt(str.split(" ")[1]);
        //     arr = new int[M][3];
        //     String[] sr;
        //     for(int i=0; i<M; i++){
        //         str = br.readLine();
        //         sr = str.split(" ");
        //         arr[i][0] = Integer.parseInt(sr[0]);
        //         arr[i][1] = Integer.parseInt(sr[1]);
        //         arr[i][2] = Integer.parseInt(sr[2]);
        //     }
        // }catch(Exception ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf052Dijkstra().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int[][] arr){
        System.out.println(Arrays.deepToString(arr));
        StringBuilder buff = new StringBuilder();

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Edge>());
        }
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i=0; i<M; i++){
            list.get(arr[i][0]).add(new Edge(arr[i][1], arr[i][2]));
        }

        PriorityQueue<Edge> pQueue = new PriorityQueue<Edge>();
        dis[1] = 0;
        pQueue.offer(new Edge(1, 0));

        while(!pQueue.isEmpty()){
            Edge now = pQueue.poll();
            int nowVetax = now.vetax;
            int nowCost = now.cost;

            if(nowCost > dis[nowVetax] ) continue;
            for(Edge edge : list.get(nowVetax)){
                if(nowCost+edge.cost < dis[edge.vetax]){
                    dis[edge.vetax] = nowCost+edge.cost;
                    pQueue.offer(new Edge(edge.vetax, nowCost+edge.cost));
                }
            }
        }

        
        for(int i=2; i<N+1; i++){
            if(dis[i]==Integer.MAX_VALUE) buff.append(i+" : "+"impossible"+"\n");
            else buff.append(i+" : "+dis[i]+"\n");
        }
        return buff.toString();
    }

    class Edge implements Comparable<Edge>{
        int vetax, cost;
        Edge(int vetax, int cost){
            this.vetax = vetax;
            this.cost = cost;
        }
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }



}