import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int V = 9;
		int E = 12;
		V = sc.nextInt();
		E = sc.nextInt();
		int[][] arr = new int[E][3];
		for(int i=0; i<E; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().solution(V, E, arr));
	}
	

	int solution(int V, int E, int[][] arr){
		int answer = 0;
		boolean[] ch = new boolean[V+1];

		List<List<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=V; i++)graph.add(new ArrayList<Edge>());

		for(int[] ar : arr){
			graph.get(ar[0]).add(new Edge(ar[1], ar[2]));
			graph.get(ar[1]).add(new Edge(ar[0], ar[2]));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.offer(new Edge(1, 0));

		while(!pq.isEmpty()){
			Edge now = pq.poll();
			if(ch[now.vtx]) continue;
			ch[now.vtx] = true;
			answer += now.cost;

			for(Edge next : graph.get(now.vtx)){
				pq.offer(next);
			}
		}


		return answer;
	}

	class Edge implements Comparable<Edge>{
		int vtx, cost;
		Edge(int vtx, int cost){
			this.vtx = vtx; this.cost = cost;
		}
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
	}

}
