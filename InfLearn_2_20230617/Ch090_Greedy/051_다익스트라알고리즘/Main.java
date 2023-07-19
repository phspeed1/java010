import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 6;
		int M = 9;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[M][3];
		for(int i=0; i<M; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().solution(N, M, arr));
	}
	

	String solution(int N, int M, int[][] arr){
		List<List<Edge>> graph = new ArrayList<>();
		
		for(int i=0; i<=N; i++){
			graph.add(new ArrayList<Edge>());
		}
		
		for(int[] ar : arr){
			graph.get(ar[0]).add(new Edge(ar[1], ar[2]));
		}

		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;

		System.out.println(graph);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));

		while(!pq.isEmpty()){
			int len = pq.size();

			System.out.println(pq);
			for(int i=0; i<len; i++){
				Edge now = pq.poll();
				if(now.cost > dp[now.vertex]) continue;

				for(Edge next : graph.get(now.vertex)){
					if(dp[now.vertex] + next.cost < dp[next.vertex]){
						dp[next.vertex] = dp[now.vertex] + next.cost;
						pq.offer(next);
					}
				}
			}
		}




		for(int i=2; i<= N; i++){
			System.out.println(i +" : "+(dp[i] == Integer.MAX_VALUE ? "Impossible" : (""+dp[i]) ) );
		}

		return "";
	}

	class Edge implements Comparable<Edge>{
		int vertex;
		int cost;
		Edge(int vertex, int cost){
			this.vertex = vertex;
			this.cost = cost;
		}
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
		public String toString(){
			return " "+this.vertex+":"+this.cost;
		}
	}

}
