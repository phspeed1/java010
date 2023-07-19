import java.util.*;
import java.io.*;

public class Inf140BfsMinPath{

    public static void main(String[] args){
        int N = 6;
        String str = "";
        str += "1 3\n";
        str += "1 4\n";
        str += "2 1\n";
        str += "2 5\n";
        str += "3 4\n";
        str += "4 5\n";
        str += "4 6\n";
        str += "6 2\n";
        str += "6 5\n";

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<= N; i++){
            graph.add(new ArrayList<Integer>());
        }
        StringTokenizer st = new StringTokenizer(str, "\n");
        while(st.hasMoreTokens()){
            String[] s = st.nextToken().split(" ");
            graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
        }

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf140BfsMinPath().solution(N, graph);
        System.out.println(rtn);
    }
    
    private String solution(int N, List<List<Integer>> graph){
        StringBuilder buff = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        int[] resList = new int[N+1];
        for(int i=0; i<= N; i++) resList[i] = Integer.MAX_VALUE;

        bfs(graph, 1, resList, visited);
        buff.append(Arrays.toString(resList));
        
        return buff.toString();
    }

    void bfs(List<List<Integer>> graph, int node, int[] resList, boolean[] visited){
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.offer(node);
        visited[node] = true;
        int lv = 0;

        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                node = Q.poll();
                resList[node] = Math.min(resList[node], lv);

                for(int link : graph.get(node)){
                    if(!visited[link]){
                        visited[link] = true;
                        Q.offer(link);
                    }
                }
            }
            lv++;

        }

    }

}