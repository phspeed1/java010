import java.util.*;

public class ConnectedGroupCnt010{

    public static void main(String[] args){
        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};

        String str = "str";
        System.out.println("input : "+str);
    
        new ConnectedGroupCnt010().solution(n, edges);
        System.out.println("output : "+str);
    }
    
    void solution(int n, int[][] edges){
        boolean[] visited = new boolean[n];

        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] nodeLists = new ArrayList[n];
        for(int i=0; i<n; i++){
            nodeLists[i] = new ArrayList<Integer>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            nodeLists[u].add(v);
            nodeLists[v].add(u);
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                List<Integer> res = new ArrayList<Integer>();
                dfs(nodeLists, i, visited, res);
                result.add(res);
            }
        }
        
        System.out.println("result : "+result);
        System.out.println("ConnectionGroupCnt : "+result.size());
        

        
    }

    void dfs(List<Integer>[] nodeLists, int node, boolean[] visited, List<Integer> result){
        visited[node] = true;
        result.add(node);

        for(int link : nodeLists[node]){
            if(!visited[link]){
                dfs(nodeLists, link, visited, result);
            }
        }
    }

}