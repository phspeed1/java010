import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());

		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		System.out.println(new Main().solution(N, M, graph));
	}
	int answer;
	
	int solution(int N, int M, List<List<Integer>> graph){
		answer = 0;
		boolean[] visited = new boolean[N+1];
		visited[1] = true;
		DFS(graph, N, 1, visited, 1+" ");

		return answer;
	}

	void DFS(List<List<Integer>> graph, int N, int n, boolean[] visited, String path){
		if(n == N){
			answer++;
			System.out.println(path);
			return;
		}
		
		for(int t : graph.get(n)){
			if(visited[t]) continue;
			visited[t] = true;
			DFS(graph, N, t, visited, path+t+" ");
			visited[t] = false;
		}

	}
	/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
*/

}
