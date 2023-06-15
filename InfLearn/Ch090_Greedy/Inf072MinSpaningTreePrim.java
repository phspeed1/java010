import java.util.*;
import java.io.*;

public class Inf072MinSpaningTreePrim{

    public static void main(String[] args){
        int V = 9;
        int E = 12;
        int[][] arr;
        String str = "";
        arr = new int[E][3];
        arr[0] = new int[]{1, 2, 12};
        arr[1] = new int[]{1, 9, 25};
        arr[2] = new int[]{2, 3, 10};
        arr[3] = new int[]{2, 8, 17};
        arr[4] = new int[]{2, 9, 8};
        arr[5] = new int[]{3, 4, 18};
        arr[6] = new int[]{3, 7, 55};
        arr[7] = new int[]{4, 5, 44};
        arr[8] = new int[]{5, 6, 60};
        arr[9] = new int[]{5, 7, 38};
        arr[10] = new int[]{7, 8, 35};
        arr[11] = new int[]{8, 9, 15};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            V = Integer.parseInt(str.split(" ")[0]);
            E = Integer.parseInt(str.split(" ")[1]);
            arr = new int[E][3];
            String[] sr;
            for(int i=0; i<E; i++){
                str = br.readLine();
                sr = str.split(" ");
                arr[i][0] = Integer.parseInt(sr[0]);
                arr[i][1] = Integer.parseInt(sr[1]);
                arr[i][2] = Integer.parseInt(sr[2]);
            }
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf072MinSpaningTreePrim().solution(V, E, arr);
        System.out.println(rtn);
    }
    
    private String solution(int V, int E, int[][] arr){
        StringBuilder buff = new StringBuilder();
        int[] dis = new int[V+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i=0; i<=V; i++) list.add(new ArrayList<Node>());
        for(int i=0; i<E; i++){
            list.get(arr[i][0]).add(new Node(arr[i][1], arr[i][2]));
            list.get(arr[i][1]).add(new Node(arr[i][0], arr[i][2]));
        }
        PriorityQueue<Node> pQueue = new PriorityQueue<Node>();
        ///////////////////////////
//        dis[1] = 0;
        pQueue.offer(new Node(1, 0));

        int sum = 0;
        while(!pQueue.isEmpty()){
            Node nowNode = pQueue.poll();
            if(dis[nowNode.edge] != 0 ){
                dis[nowNode.edge] = 0;
                sum += nowNode.cost;
                
                for(Node link : list.get(nowNode.edge)){
                    if(dis[link.edge] != 0){
                        pQueue.offer(new Node(link.edge, link.cost));
                    }
                }

            }

        }

        buff.append(sum);
 
        return buff.toString();
    }

    class Node implements Comparable<Node>{
        int edge, cost;
        Node(int edge, int cost){
            this.edge = edge;
            this.cost = cost;
        }
        public int compareTo(Node o){
            return this.cost - o.cost ;
        }
    }




}