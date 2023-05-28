import java.util.*;

public class ConnectedGroupCnt020{

    public static void main(String[] args){
        int n = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};

        String str = "str";
        System.out.println("input : "+str);
    
        new ConnectedGroupCnt020().solution(n, edges);
        System.out.println("output : "+str);
    }
    
    void solution(int n, int[][] edges){
        List<List<Integer>> resultLists = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<Integer>();
        List<Integer>[] adjacentList = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjacentList[i] = new ArrayList<Integer>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjacentList[u].add(v);
            adjacentList[v].add(u);
        }
        for(int node = 0; node<n; node++){
            if(!visited.contains(node)){
                List<Integer> resultList = new ArrayList<Integer>();
                dfs(adjacentList, node, visited, resultList);
                resultLists.add(resultList);
            }
        }
        System.out.println("resultLists : "+resultLists);
        
    }

    void dfs(List<Integer>[] adjacentList, int node, HashSet<Integer> visited, List<Integer> resultList){
        visited.add(node);
        resultList.add(node);
        for(int link : adjacentList[node]){
            if(!visited.contains(link)){
                dfs(adjacentList, link, visited, resultList);
            }
        }
    }

}