import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 3;
		N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();

		System.out.println(new Main().solution(N, arr, M));
	}

	int solution(int N, int[] arr, int M){	
		int answer = 0;

		int[] dp = new int[M+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for(int c : arr){
			for(int j = c; j<= M; j++){
				dp[j] = Math.min(dp[j], dp[j - c]+1);
			}
		}
		answer = dp[M];

		return answer;
	}



}
