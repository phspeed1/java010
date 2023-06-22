import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		System.out.println(new Main().solution(N, M, graph));
	}
	int ansCnt[];
	Set<Integer> ch;
	
	String solution(int N, int M, List<List<Integer>> graph){
		ansCnt = new int[N+1];
		Arrays.fill(ansCnt, Integer.MAX_VALUE);
		ch = new HashSet<Integer>();
		ch.add(1);
		BFS(graph, N, 1);

		String buff = "";
		for(int i=2; i<=N; i++){
			buff += i + " : "+ansCnt[i]+"\n";
		}

		return buff;
	}

	void BFS(List<List<Integer>> graph, int N, int node){
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);

		int lv = 0;
		while(!queue.isEmpty()){
			int len = queue.size();
			for(int i=0; i<len; i++){
				int temp = queue.poll();
				ansCnt[temp] = Math.min(ansCnt[temp], lv);
				
				for(int link : graph.get(temp)){
					if(!ch.contains(link)){
						ch.add(link);
						queue.offer(link);
					}
				}
			}
			lv++;

		}



	}

}
