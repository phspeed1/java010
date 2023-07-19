import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 6;
		int M = 9;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[M][3];
		for(int i=0; i<M; i++){
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().solution(N, M, arr));
	}
	
	String solution(int N, int M, int[][] arr){

		int[] dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[1] = 0;
		DFS(arr, M, dp, 1);

		for(int i=2; i<= N; i++){
			System.out.println(i +" : "+(dp[i] == Integer.MAX_VALUE ? "Impossible" : (""+dp[i]) ) );
		}

		return "";
	}

	void DFS(int[][] arr, int M, int[] dp, int node){

		for(int i=0; i<M; i++){
			int vetex = arr[i][0];
			if(vetex == node ){
				int link = arr[i][1];
				int cost = arr[i][2];
				if(dp[vetex] + cost < dp[link]){
					dp[link] = dp[vetex] + cost;
					DFS(arr, M, dp, link);
				}

			}
		}
	}


}
