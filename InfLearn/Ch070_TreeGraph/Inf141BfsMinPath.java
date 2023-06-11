import java.util.*;
import java.io.*;

public class Inf141BfsMinPath{

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
    
        String rtn = new Inf141BfsMinPath().solution(N, graph);
        System.out.println(rtn);
    }
    
    private String solution(int N, List<List<Integer>> graph){
        StringBuilder buff = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        int[] resList = new int[N+1];

        bfs(graph, 1, resList, visited);
        buff.append(Arrays.toString(resList));
        
        return buff.toString();
    }

    void bfs(List<List<Integer>> graph, int node, int[] resList, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        resList[node] = 0;
        visited[node] = true;
        queue.offer(node);

        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int cv : graph.get(v)){
                if(!visited[cv]){
                    visited[cv] = true;
                    resList[cv] = resList[v]+1;
                    queue.offer(cv);
                }
            }

        }

    }

}