import java.util.*;
import java.io.*;

public class Inf051Dijkstra{

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
    
        String rtn = new Inf051Dijkstra().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int[][] arr){
        StringBuilder buff = new StringBuilder();

        System.out.println(Arrays.deepToString(arr));

        int[] dis = new int[N+1]; // 시작노드에서 n노드까지 걸리는 최단거리 비용배열
        boolean[] fns = new boolean[N+1];
        for(int i=0; i<dis.length; i++) dis[i] = Integer.MAX_VALUE;
        dis[1] = 0;
        
        for(int i=0; i<N; i++){
            
            int stIdx = -1;
            int stMin = Integer.MAX_VALUE;
            for(int j=1; j<=N; j++){
                if(!fns[j] && dis[j] < stMin && dis[j] != Integer.MAX_VALUE){
                    stMin = dis[j];
                    stIdx = j;
                }
            }
            if(stIdx == -1) continue;

            fns[stIdx] = true;
            for(int j=0; j<M; j++){

                if(arr[j][0] != stIdx) continue;
                if(dis[stIdx] + arr[j][2] >= dis[arr[j][1]]) continue;

                dis[arr[j][1]] = dis[stIdx] + arr[j][2];
            }
System.out.println(Arrays.toString(dis));

        }
        
        //DFS(arr, M, 1, 0, dis);
        
        for(int i=2; i<N+1; i++){
            if(dis[i]==Integer.MAX_VALUE)
                buff.append(i+" : "+"impossible"+"\n");
            else
                buff.append(i+" : "+dis[i]+"\n");
        }
        return buff.toString();
    }

    void DFS(int[][] arr, int M, int node, int sum, int[] dis){
        for(int i=0; i<M; i++){

            if(arr[i][0] != node) continue;
            if(sum+arr[i][2] >= dis[arr[i][1]]) continue;

            System.out.println(arr[i][1]+" : "+dis[arr[i][1]] +" -> "+(sum+arr[i][2]));
            dis[arr[i][1]] = sum+arr[i][2];
            DFS(arr, M, arr[i][1], sum+arr[i][2], dis);

        }
    }


    class Node{
        int node;
        List<Node> adjacentes;
        Node(int node){
            this.node = node;
            adjacentes = new ArrayList<Node>();
        }
        void addAdjacent(Node node){
            this.adjacentes.add(node);
        }
    }

}