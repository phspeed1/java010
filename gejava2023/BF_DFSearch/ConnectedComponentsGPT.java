import java.util.*;

public class ConnectedComponentsGPT {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        int n = 5; // 전체 노드의 개수
        
        List<List<Integer>> components = findConnectedComponents(edges, n);
        
        // 연결 요소 출력
        for (List<Integer> component : components) {
            System.out.println(component);
        }
    }
    
    public static List<List<Integer>> findConnectedComponents(int[][] edges, int n) {
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[n];
        
        // 인접 리스트 생성
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }
        
        for (int i = 0; i < n; i++) {
            System.out.println("adjacencyList["+i+"] :"+adjacencyList[i]);
        }


        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(adjacencyList, i, visited, component);
                components.add(component);
            }
        }
        
        return components;
    }
    
    public static void dfs(List<Integer>[] adjacencyList, int node, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        
        for (int neighbor : adjacencyList[node]) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, neighbor, visited, component);
            }
        }
    }
}
