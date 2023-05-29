import java.util.*;

public class ConnectedGroupCnt030{

    public static void main(String[] args){
        int n = 6;
        int[][] edges = {{0,1}, {1,2}, {3,4, 5}};

        String str = "str";
        System.out.println("input : "+Arrays.toString(edges));
    
        int connectedGroupCnt = new ConnectedGroupCnt030().solution(n, edges);
        System.out.println("output : "+connectedGroupCnt);
    }
    
    int solution(int N, int[][] edges){
        List<Integer>[] adjacentList = new ArrayList[N];
        for(int i=0; i<N; i++){
            adjacentList[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<edges.length; i++){
            for(int j=0; j<edges[i].length -1; j++){
                adjacentList[edges[i][j]].add(edges[i][j+1]);
                adjacentList[edges[i][j+1]].add(edges[i][j]);
            }
/*
            int u = edges[i][0];
            int v = edges[i][1];
            adjacentList[u].add(v);
            adjacentList[v].add(u);
*/            
        }
        Set<Integer> retrieved = new HashSet<Integer>();
        List<List<Integer>> resultLists = new ArrayList<>();
        for(int node=0; node<N; node++){
            if(!retrieved.contains(node)){
                List<Integer> resultList = new ArrayList<Integer>();
                dfs(adjacentList, node, resultList, retrieved);
                resultLists.add(resultList);
            }
        }
        System.out.println("resultLists : "+resultLists);
        return resultLists.size();
        
    }

    void dfs(List<Integer>[] adjacentList, int node, List<Integer> resultList, Set<Integer> retrieved){
        retrieved.add(node); resultList.add(node);
        for(int link : adjacentList[node]){
            if(!retrieved.contains(link)){
                dfs(adjacentList, link, resultList, retrieved);
            }
        }
    }

}