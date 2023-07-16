import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();

		System.out.println(new Main().solution(N, F));
	}

	String ans = "";

	int[] weight;
	String solution(int N, int F){
		ans = "";
		
		dp = new int[N+1][N+1];
		weight = new int[N];
		for(int i=0; i<N; i++){
			weight[i] = cntCombi(N-1, i);
		}

//		System.out.println("weight : "+Arrays.toString(weight));

		finished = false;
		DFS(N, F, 0, new int[N], new boolean[N+1]);

		return ans;
	}
	boolean finished;

	void DFS(int N, int F, int lv, int[] res, boolean[] visited){
		if(finished) return;

		if(lv == N){
//			System.out.println(Arrays.toString(res));
			int sum = 0;
			for(int i=0; i<N; i++){
				sum += res[i] * weight[i];
			}
			if(sum == F){
				finished = true;
				for(int n : res) ans += n+ " ";
			}
			return;
		}

		for(int i=1; i<=N; i++){
			if(visited[i]) continue;

			visited[i] = true;
			res[lv] = i;
			DFS(N, F, lv+1, res, visited);
			visited[i] = false;
		}
	}

	int[][] dp;

	int cntCombi(int n, int r){
		if(n == r || r == 0) return 1;
		if(dp[n][r] != 0) return dp[n][r];
		return dp[n][r] = cntCombi(n-1, r-1) + cntCombi(n-1, r);
	}
}

