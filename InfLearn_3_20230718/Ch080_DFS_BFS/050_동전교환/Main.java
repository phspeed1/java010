import java.util.*;
public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();

		System.out.println(new Main().solution(N, arr, M));
	}

	int answer;

	int solution(int N, Integer[] arr, int M){
		answer = Integer.MAX_VALUE;
		int[] visited = new int[M+1];
		Arrays.fill(visited, Integer.MAX_VALUE);

		Arrays.sort(arr, Collections.reverseOrder());


		DFS(N, arr, M, 0, 0, visited, "");
		return answer;
	}

	void DFS(int N, Integer[] arr, int M, int lv, int sum, int[] visited, String path){
		if(sum > M) return;
		if(lv > answer) return;
		if(sum == M){
	//		System.out.println(lv + " : "+path);
			answer = Math.min(answer, lv);
			return;
		}

		for(int i=0; i<N; i++){
			int ns = sum + arr[i];
//			if(ns <= M && lv+1 < visited[ns]){
//				visited[ns] = lv+1;
				DFS(N, arr, M, lv+1, ns, visited, path+" "+arr[i]);
//			}
		}
	}
/*
5
1 8 20 25 50
129

5

50 50 20 8 1
*/

}
