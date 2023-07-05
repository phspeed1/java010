import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 7;
		N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}
	/*
	// 0 1 2 3 4 5 6 7 
	       1
              2
			     3
			        5
			           8
			              13
			                  21
	*/
	int[] dp;
	int solution(int N){	
		dp = new int[N+1];
		int answer = dp(N);
		return answer;
	}

	int dp(int N){
		if(N == 1) return 1;
		if(N == 2) return 2;

		return dp[N] = dp(N-2) + dp(N-1);
	}

}
