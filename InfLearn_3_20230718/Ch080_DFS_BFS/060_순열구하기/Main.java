import java.util.*;
public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, M, arr));
	}

	String answer;
	String solution(int N, int M, int[] arr){
		answer = "";
		boolean[] visited = new boolean[N];
		int[] res = new int[M];

		DFS(N, M, arr, 0, res, visited);
		return answer;
	}

	void DFS(int N, int M, int[] arr, int lv, int[] res, boolean[] visited){
		if(lv == M){
			for(int n : res) answer += n + " ";
			answer += "\n";
			return;
		}
		for(int i=0; i<N; i++){
			if(visited[i]) continue;
			res[lv] = arr[i];
			visited[i] = true;
			DFS(N, M, arr, lv+1, res, visited);
			visited[i] = false;
		}
	}
}
/*
3 2
3 6 9

*/