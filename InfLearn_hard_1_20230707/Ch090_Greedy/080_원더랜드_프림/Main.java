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

		List<List<Edge>> list = new ArrayList<>();
		for(int i=0; i<E; i++) list.add(new ArrayList<Edge>());

		for(int[] ar : arr){
			list.get(ar[0]).add(new Edge(ar[1], ar[2]));
			list.get(ar[1]).add(new Edge(ar[0], ar[2]));
		}

		boolean[] ch = new boolean[V+1];

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(1, 0));

		while(!pq.isEmpty()){
			Edge temp = pq.poll();
			if(ch[temp.vtx]) continue;
			ch[temp.vtx] = true;
			answer += temp.cost;
			for(Edge edge : list.get(temp.vtx)){
//				if(ch[edge.vtx]) continue;
				pq.offer(edge);
			}
		}

		return answer;
	}

	class Edge implements Comparable<Edge>{
		int vtx,  cost;
		Edge(int vtx, int cost){
			this.vtx = vtx;
			this.cost = cost;
		}
		public int compareTo(Edge o){
			return this.cost - o.cost;
		}
	}

}
