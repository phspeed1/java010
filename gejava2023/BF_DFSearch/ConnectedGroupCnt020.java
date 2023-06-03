import java.util.*;

public class ConnectedGroupCnt020{

    public static void main(String[] args){
        int nodeCnt = 5;
        int[][] edges = {{0,1}, {1,2}, {3,4}};

        String str = "str";
        System.out.println("input : "+str);
    
        int connectedCnt = new ConnectedGroupCnt020().solution(nodeCnt, edges);
        System.out.println("output : "+connectedCnt);
    }
    
    List<List<Integer>> resultList;
    boolean[] visited;

    int solution(int n, int[][] edges){
        resultList = new ArrayList<>();
        visited = new boolean[n];
        List<Integer>[] adjacentList = new List[n];
        for(int i=0; i< adjacentList.length; i++){
            adjacentList[i] = new LinkedList<Integer>();
        }
        for(int i=0; i<edges.length; i++){
            int U = edges[i][0];
            int V = edges[i][1];
            adjacentList[U].add(V);
            adjacentList[V].add(U);
        }
        System.out.println("adjacentList : "+Arrays.deepToString(adjacentList));

        for(int startNode=0; startNode<n; startNode++){
            if(visited[startNode]) continue;

            ArrayList<Integer> result = new ArrayList<Integer>();
            Queue<Integer> queue = new LinkedList<Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            visited[startNode] = true;
            queue.offer(startNode);
//            bfs(adjacentList, queue, result);
            stack.push(startNode);
            dfs(adjacentList, stack, result);
            resultList.add(result);
        }
        System.out.println("resultList : "+(resultList));
        return resultList.size();
    }

    void bfs(List<Integer>[] adjacentList, Queue<Integer>queue, List<Integer> result){
        if(queue.isEmpty()) return;

        int node = queue.poll();
        result.add(node);
        visited[node] = true;

        for(int link : adjacentList[node]){
            if(!visited[link])
                queue.offer(link);
        }
        bfs(adjacentList, queue, result);
    }

   void dfs(List<Integer>[] adjacentList, Stack<Integer> stack, List<Integer> result){
        if(stack.empty()) return;
        
        int node = stack.pop();
        result.add(node);
        visited[node] = true;

        for(int link : adjacentList[node]){
            if(!visited[link])
                stack.push(link);
        }
        dfs(adjacentList, stack, result);
   }

}