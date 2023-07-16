import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 6;
		int M = 9;
/*
		N = sc.nextInt();
		M = sc.nextInt();

		for(int i=0; i<M; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}
*/
		int[][] arr = new int[M][3];
        arr[0] = new int[]{1, 2, 12};
        arr[1] = new int[]{1, 3, 4};
        arr[2] = new int[]{2, 1, 2};
        arr[3] = new int[]{2, 3, 5};
        arr[4] = new int[]{2, 5, 5};
        arr[5] = new int[]{3, 4, 5};
        arr[6] = new int[]{4, 2, 2};
        arr[7] = new int[]{4, 5, 5};
        arr[8] = new int[]{6, 4, 5};
		System.out.println(new Main().solution(N, M, arr));
	}
	

	String solution(int N, int M, int[][] arr){
		String answer = "";

		List<List<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Edge>());
		for(int[] ar : arr){
			graph.get(ar[0]).add(new Edge(ar[1], ar[2]));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		pq.offer(new Edge(1, 0));

		while(!pq.isEmpty()){
			Edge now = pq.poll();

			for(Edge next : graph.get(now.vertex)){
				if(now.cost + next.cost < dp[next.vertex]){
					dp[next.vertex] = now.cost + next.cost;
					pq.offer(new Edge(next.vertex, now.cost + next.cost));
				}
			}
		}

		for(int i=2; i<=N; i++) answer += i+" : "+ (dp[i] == Integer.MAX_VALUE?"impossible!":String.valueOf(dp[i]))+"\n";


		return answer;
	}

	class Edge implements Comparable<Edge>{
		int vertex, cost;
		Edge(int vertex, int cost){
			this.vertex=vertex; this.cost=cost;
		}
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
	}

}
