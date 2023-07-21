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

		new Main().solution(N, graph);
		
	}
	int[] dis;
	
	void solution(int N,  List<List<Integer>> graph){
		dis = new int[N+1];
		boolean[] visited = new boolean[N+1];
		
		BFS(graph, N, visited);
		
		for(int i=2; i<=N; i++){
			int ans = dis[i];
			System.out.println(i + " : "+ans);
		}

	}

	void BFS(List<List<Integer>> graph, int N, boolean[] visited){
		Queue<Integer> Q = new LinkedList<Integer>();
		visited[1] = true;
		Q.offer(1);
		int lv = 0;

		while(!Q.isEmpty()){
			int l = Q.size();
			for(int i=0; i<l; i++){
				int t = Q.poll();
				dis[t] = lv;

				for(int n : graph.get(t)){
					if(visited[n]) continue;
					visited[n] = true;
					Q.offer(n);
				}
			}
			lv++;
		}
	}


}
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

*/
/*
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
*/
