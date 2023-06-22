import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=20; i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		System.out.println(new Main().solution(N, M, graph));
	}
	int ansCnt;
	Set<Integer> ch;
	
	int solution(int N, int M, List<List<Integer>> graph){
		ansCnt = 0;
		ch = new HashSet<Integer>();
		ch.add(1);
		DFS(graph, N, 1);

		return ansCnt;
	}

	void DFS(List<List<Integer>> graph, int N, int node){
		if(node == N){
			ansCnt++;
			return;
		}
		for(int link : graph.get(node)){
			if(!ch.contains(link)){
				ch.add(link);
				DFS(graph, N, link);
				ch.remove(link);
			}
		}
	}

}
