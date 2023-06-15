import java.util.*;
import java.io.*;

public class Inf071MinSpaningTree{

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
    
        String rtn = new Inf071MinSpaningTree().solution(V, E, arr);
        System.out.println(rtn);
    }
    
    private String solution(int V, int E, int[][] arr){
        StringBuilder buff = new StringBuilder();
        int[] grp = new int[V+1];
        for(int i=1; i<V+1; i++) grp[i] = i;

        ArrayList<Edge> list = new ArrayList<Edge>();
        for(int[] a : arr){
            list.add(new Edge(a[0], a[1], a[2]));
        }
        Collections.sort(list);

        ///////////////////////////
        int answer = 0;
        for(Edge edge : list){
            int f1 = find(grp, edge.v1);
            int f2 = find(grp, edge.v2);
            if(f1 != f2){
                answer += edge.cost;
                union(grp, edge.v1, edge.v2);
            }
        }


        buff.append(answer);
 
        return buff.toString();
    }

    int find(int[] grp, int v){
        if(v == grp[v]) return grp[v];
        else return grp[v] = find(grp, grp[v]);
    }

    void union(int[] grp, int a, int b){
        int fa = find(grp, a);
        int fb = find(grp, b);
        if(fa != fb) grp[fa] = grp[fb];
    }

    class Edge implements Comparable<Edge>{
        int v1, v2, cost;
        Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        public int compareTo(Edge o){
            return this.cost - o.cost ;
        }
        public String toString(){
            return v1+" - "+v2+" : "+cost;
        }
    }




}