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
		
		List<List<Edge>> graph = new ArrayList<>();
		for(int i=0; i<=V; i++) graph.add(new ArrayList<Edge>());

		for(int[] ar : arr){
			graph.get(ar[0]).add(new Edge(ar[1], ar[2]));
			graph.get(ar[1]).add(new Edge(ar[0], ar[2]));
		}
		boolean[] visited = new boolean[V+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 0));

		while(!pq.isEmpty()){
			Edge edge = pq.poll();
			if(visited[edge.v]) continue;
			visited[edge.v] = true;
			answer += edge.cost;
			for(Edge temp : graph.get(edge.v)){
				if(visited[temp.v]) continue;
				pq.offer(temp);
			}
		}


		return answer;
	}

	class Edge implements Comparable<Edge>{
		int v, cost;
		Edge(int v, int cost){
			this.v = v;
			this.cost = cost;
		}
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
		public String toString(){
			return this.v+" : "+this.cost;
		}
	}
}
