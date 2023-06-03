import java.util.*;

public class RoomsAndKeys{
    public static void main(String[] args){
        int rooms[][] = {{1,3}, {3,0,1}, {2}, {0} };
        String str = "str";
        System.out.println("input : "+str);

        new RoomsAndKeys().solution(rooms);
        System.out.println("output : "+str);
    }

    void solution(int[][] arr){
        ArrayList<Integer> visited = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int node = 0;
        visited.add(node);
        stack.push(node);
        dfs(arr, visited, stack);
        System.out.println("visited[DFS] : "+visited);

        Queue<Integer> queue = new LinkedList<Integer>();
        visited.clear();
        queue.add(node);
        visited.add(node);
        bfs(arr, visited, queue);
        System.out.println("visited[BFS] : "+visited);

        bfsLoop(arr);

        visited.clear();
        dfsCallStack(arr, node, visited);
        System.out.println("visited[DFS CallStack] : "+visited);
        
    }

    void dfs(int[][] arr, ArrayList<Integer> visited, Stack<Integer> stack){
        if(stack.empty()) return;

        int node = stack.pop();
        for (int link : arr[node]) {
            if(!visited.contains(link)){
                stack.push(link);
                visited.add(link);
            }
        }
        dfs(arr, visited, stack);
    }

    void bfs(int[][] arr, ArrayList<Integer> visited, Queue<Integer> queue){
        if(queue.isEmpty()) return;

        int node = queue.poll();
        for(int link : arr[node]){
            if(!visited.contains(link)){
                queue.add(link);
                visited.add(link);
            }
        }
        bfs(arr, visited, queue);
    }

    void bfsLoop(int[][] arr){
        ArrayList<Integer> visitOrder = new ArrayList<Integer>();
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        visited[0] = true;
        visitOrder.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int link : arr[node]) {
                if(!visited[link]){
                    queue.offer(link);
                    visited[link] = true;
                    visitOrder.add(link);
                }
            }
        }
        System.out.println("[BFS LOOP]visitOrder : "+visitOrder);
    }

    void dfsCallStack(int[][] arr, int node, ArrayList<Integer> visited){
        visited.add(node);

        for(int link : arr[node]){
            if(!visited.contains(link)){
                dfsCallStack(arr, link, visited);
            }
        }
    }
    
}



