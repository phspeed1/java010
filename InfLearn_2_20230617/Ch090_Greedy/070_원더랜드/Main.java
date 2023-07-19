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
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for(int[] ar : arr){
			pq.offer(new Edge(ar[0], ar[1], ar[2]));
		}

		uar = new int[V+1];
		for(int i=1; i<=V; i++) uar[i] = i;

		while(!pq.isEmpty()){
			Edge edge = pq.poll();
			if(find(edge.v1) != find(edge.v2)){
				union(edge.v1, edge.v2);
				answer += edge.cost;
			}
		}

		return answer;
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
		public String toString(){
			return this.v1+"-"+this.v2+" : "+this.cost;
		}
	}
	
	int[] uar;
	int find(int n){
		if(uar[n] == n) return n;
		return uar[n] = find(uar[n]);
	}
	void union(int n1, int n2){
		int u1 = find(n1);
		int u2 = find(n2);
		if(u1 != u2) uar[u1] = u2;
	}

}
