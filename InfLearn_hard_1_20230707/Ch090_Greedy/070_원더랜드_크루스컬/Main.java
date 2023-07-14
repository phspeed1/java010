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

		unf = new int[V+1];
		for(int i=1; i<=V; i++) unf[i] = i;

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for(int[] ar : arr){
			pq.offer(new Edge(ar[0], ar[1], ar[2]));
		}

		while(!pq.isEmpty()){
			Edge edge = pq.poll();
			if(find(edge.v1) != find(edge.v2)){
				answer += edge.cost;
				union(edge.v1, edge.v2);
			}
		}

		return answer;
	}

	int[] unf;
	int find(int v){
		if(unf[v] == v) return v;
		return find(unf[v]);
	}

	void union(int v1, int v2){
		int f1 = find(v1);
		int f2 = find(v2);
		if(f1 != f2) unf[f1] = f2;
	}

	class Edge implements Comparable<Edge>{
		int v1, v2, cost;
		Edge(int v1, int v2, int cost){
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
	}


}
